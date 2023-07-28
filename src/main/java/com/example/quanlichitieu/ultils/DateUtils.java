package com.example.quanlichitieu.ultils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Slf4j
public class DateUtils {
  private DateUtils() {
  }

  public static String getCurrentDateString() {
    return LocalDate.now().toString();
  }

  public static Long convertToTimestamp(String dateString) {

    log.info("(convertToTimestamp) dateString: {}", dateString);
    if (Objects.isNull(dateString)) return null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      Date date = dateFormat.parse(dateString);
      return date.getTime();
    } catch (ParseException e) {
      log.error(e.toString());
    }
    return null;
  }

  public static String getTimeStamp() {
    log.info("(getTimeStamp)");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    return dateFormatter.format(new Date());
  }

}
