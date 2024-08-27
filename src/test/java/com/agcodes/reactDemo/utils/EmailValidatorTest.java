package com.agcodes.reactDemo.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailValidatorTest {

    private final EmailValidator underTest = new EmailValidator();

    @Test
    void itShouldValidateCorrectEmail() {
        // Given
        String emailTest = "hello@gmail.com";
        // When
        assertThat(underTest.test(emailTest)).isTrue();
    }

    @Test
    void itShouldValidateIncorrectEmail() {
        // Given
        String emailTest = "hellogmail.com";
        // When
        assertThat(underTest.test(emailTest)).isFalse();
    }


    @Test
    void itShouldValidateIncorrectEmailWithoutDotAtTheEnd() {
        // Given
        String emailTest = "hellogmailcom";
        // When
        assertThat(underTest.test(emailTest)).isFalse();
    }
}