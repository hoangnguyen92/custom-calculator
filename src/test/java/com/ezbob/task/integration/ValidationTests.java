package com.ezbob.task.integration;

import com.ezbob.task.utils.TestFileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTests {

	@Nested
	@SpringBootTest(args = "{\"numbers\":[],\"operator\":\"minus\"}")
	class ValidateEmptyNumbers {
		@Test
		@DisplayName("Execute with empty numbers --- expected correct error message")
		void get_correct_error_message() throws IOException {
			assertThat(TestFileUtils.returnLasLine()).isEqualTo("[ERROR]Numbers should have at least 1 number!");
		}
	}

	@Nested
	@SpringBootTest(args = "{\"numbers\":[1,2],\"operator\":\"sd\"}")
	class ValidateOperator{
		@Test
		@DisplayName("Execute with invalid operator --- expected correct error message")
		void get_correct_error_message() throws IOException {
			assertThat(TestFileUtils.returnLasLine()).isEqualTo("[ERROR]Can not parse input json string!");
		}
	}
}
