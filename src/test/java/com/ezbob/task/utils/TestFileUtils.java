package com.ezbob.task.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.math.BigDecimal;

public abstract class TestFileUtils {
    public static final String LOG_FILE_NAME = "result.log";

    public static String returnLasLine() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_NAME))) {
            String lastLine = "", currentLine = "";

            while ((currentLine = reader.readLine()) != null)
            {
                lastLine = currentLine;
            }
            return lastLine;
        }
    }
}
