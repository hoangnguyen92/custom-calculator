package com.ezbob.task.domain;

import com.ezbob.task.exceptions.TaskException;
import com.ezbob.task.exceptions.TaskInputValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinusOperatorCalculatorTest {
    @Test
    void test_empty_numbers(){
        MinusOperatorCalculator calculator = new MinusOperatorCalculator();
        calculator.setNumbers(Collections.emptyList());

        TaskInputValidationException thrown = assertThrows(
                TaskInputValidationException.class,
                () -> calculator.calculateResult(),
                "Expected calculateResult() to throw TaskInputValidationException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Numbers should have at least 1 number!"));
    }

    @DisplayName("Test different input")
    @ParameterizedTest
    @MethodSource("provideNumbersAndResult")
    void test(List<Integer> numbers, BigDecimal expected) throws TaskException {
        MinusOperatorCalculator calculator = new MinusOperatorCalculator();
        calculator.setNumbers(numbers);

        assertThat(calculator.calculateResult()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5), BigDecimal.valueOf(-13)),
                Arguments.of(Collections.singletonList(1), BigDecimal.valueOf(1)),
                Arguments.of(Collections.singletonList(123456789), BigDecimal.valueOf(123456789)),
                Arguments.of(Arrays.asList(1234567899), BigDecimal.valueOf(1234567899)),
                Arguments.of(Arrays.asList(1234567899, 1234567899, 1234567899, 1234567899, 1234567899), BigDecimal.valueOf(-3703703697l))
        );
    }
}
