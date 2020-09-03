package com.ezbob.task.services;

import com.ezbob.task.domain.BaseCalculator;
import com.ezbob.task.exceptions.ParseTaskInputException;
import com.ezbob.task.exceptions.TaskException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ezbob.task.utils.JsonUtils;
import com.ezbob.task.utils.LogFileUtils;

import java.io.IOException;
import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    public void runTaskAndSaveResult(String jsonString) throws TaskException {
        BaseCalculator baseCalculator = null;
        try {
            baseCalculator = JsonUtils.getObjectFromJsonString(jsonString, BaseCalculator.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseTaskInputException("Can not parse input json string!");
        }

        BigDecimal result = baseCalculator.calculateResult();
        LogFileUtils.appendResultToLogFile(result);
        
        log.info("Result: {} {}", result, baseCalculator.getOperator());
    }
}
