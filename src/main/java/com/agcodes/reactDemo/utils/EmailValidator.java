package com.agcodes.reactDemo.utils;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Predicate<String> {

private static final Predicate<String> emailRegexPattern = Pattern.compile(
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",Pattern.CASE_INSENSITIVE)
        .asPredicate();

    @Override
    public boolean test(String email) {
        return emailRegexPattern.test(email);
    }
}
