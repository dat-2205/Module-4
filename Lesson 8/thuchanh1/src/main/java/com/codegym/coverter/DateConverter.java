package com.codegym.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateConverter implements Converter<String, Date > {
    private String dateString;

    public DateConverter(String dateString) {
        this.dateString = dateString;
    }
    @Override
    public Date convert(String source) {
        try {
            return new SimpleDateFormat(dateString).parse(source);
        } catch (DateTimeParseException | ParseException e) {
            // the error message will be displayed in <form:errors>
            throw new IllegalArgumentException("invalid date format. Please use this pattern\""
                    + dateString + "\"");
        }
    }
}
