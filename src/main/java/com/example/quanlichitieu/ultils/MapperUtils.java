package com.example.quanlichitieu.ultils;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


public class MapperUtils {

  private MapperUtils() {}

  public static final ModelMapper MODEL_MAPPER = new ModelMapper();

  public static <T, R> List<R> toDTOs(List<T> entities, Class<R> dtoClass) {
    return entities
          .stream()
          .map(entity -> MODEL_MAPPER.map(entity, dtoClass))
          .collect(Collectors.toList());
  }

  public static <T, R> List<R> toEntities(List<T> requestDTOs, Class<R> entityClass) {
    return requestDTOs
          .stream()
          .map(dto -> MODEL_MAPPER.map(dto, entityClass))
          .collect(Collectors.toList());
  }

  public static <T, R> R toDTO(T entity, Class<R> dtoClass) {
    return MODEL_MAPPER.map(entity, dtoClass);
  }

  public static <T, R> R toEntity(T dto, Class<R> entityClass) {
    return MODEL_MAPPER.map(dto, entityClass);
  }

}
