package com.example.quanlichitieu.filter;

import com.example.quanlichitieu.exception.token.TokenExpiredException;
import com.example.quanlichitieu.exception.token.TokenInvalidException;
import com.example.quanlichitieu.service.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.quanlichitieu.constant.Constant.AuthConstant.*;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtTokenService jwtTokenService;

  @Override
  protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
  ) throws ServletException, IOException {
    log.debug(
          "(doFilterInternal)request: {}, response: {}, filterChain: {}",
          request,
          response,
          filterChain
    );

    String accessToken = request.getHeader(AUTHORIZATION);

    if (Objects.isNull(accessToken)) {
      filterChain.doFilter(request, response);
      return;
    } else if (!accessToken.startsWith(TYPE_TOKEN)) {
      filterChain.doFilter(request, response);
      return;
    }

    var jwtToken = accessToken.substring(AUTHORIZATION_TYPE_SIZE);
    try {
      var userid = jwtTokenService.getSubjectFromToken(jwtToken);
      var username = jwtTokenService.getUsernameFromToken(jwtToken);

      var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
            userid, username,new ArrayList<>()
      );
      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      filterChain.doFilter(request, response);
    } catch (TokenInvalidException e) {
      response.sendError(HttpStatus.UNAUTHORIZED.value(), INVALID_TOKEN);
    } catch (TokenExpiredException e) {
      response.sendError(HttpStatus.UNAUTHORIZED.value(), EXPIRED_TOKEN);
    }

    filterChain.doFilter(request,response);


  }
}
