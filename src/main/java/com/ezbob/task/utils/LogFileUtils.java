package com.ezbob.task.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public abstract class LogFileUtils {

    public static final String NEW_LINE = "\n";
    public static final String LOG_FILE_NAME = "result.log";

    public static void appendResultToLogFile(BigDecimal result) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true))) {
            writer.append(result.toString())
                    .append(NEW_LINE);
        } catch (IOException e) {
            e.printStackTrace();
            logErrorToLogFile(e.getMessage());
        }
    }

    public static void logErrorToLogFile(String message) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true))) {
            writer.append("[ERROR]")
                    .append(message)
                    .append(NEW_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
