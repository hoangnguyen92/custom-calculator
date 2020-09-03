package com.ezbob.task.domain;

import com.ezbob.task.exceptions.TaskInputValidationException;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;


import java.math.BigDecimal;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "operator",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MinusOperatorCalculator.class, name = "minus"),
        @JsonSubTypes.Type(value = PlusOperatorCalculator.class, name = "plus")
})
@Data
public abstract class BaseCalculator {

    private List<Integer> numbers;
    private String operator;

    public abstract BigDecimal calculateResult() throws TaskInputValidationException;
}
