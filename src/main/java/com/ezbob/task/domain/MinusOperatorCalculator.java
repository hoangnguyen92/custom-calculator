package com.ezbob.task.domain;

import com.ezbob.task.exceptions.TaskInputValidationException;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MinusOperatorCalculator extends BaseCalculator {

    @Override
    public BigDecimal calculateResult() throws TaskInputValidationException {
        validate();

        BigDecimal result = BigDecimal.valueOf(getNumbers().get(0));
        for (int i = 1; i < getNumbers().size(); i++) {
            result = result.subtract(BigDecimal.valueOf(getNumbers().get(i)));
        }
        return result;
    }

    private void validate() throws TaskInputValidationException {
        if(getNumbers().size() < 1)
            throw new TaskInputValidationException("Numbers should have at least 1 number!");
    }
}
