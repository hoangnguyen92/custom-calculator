package com.ezbob.task.integration;

import com.ezbob.task.utils.TestFileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(args = "{\"numbers\":[1,2,3,4,5],\"operator\":\"plus\"}")
class PlusOperatorTests {

	@Test
	@DisplayName("Execute with plus operation --- expected correct number")
	void test_correct_result() throws IOException {
		assertThat(TestFileUtils.returnLasLine()).isEqualTo("15");
	}

}
