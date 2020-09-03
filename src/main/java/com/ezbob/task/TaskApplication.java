package com.ezbob.task;

import com.ezbob.task.exceptions.TaskException;
import com.ezbob.task.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ezbob.task.utils.LogFileUtils;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class TaskApplication implements CommandLineRunner {
	private final TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Override
	public void run(String... args) {

		if(args.length > 0){
			try {
				taskService.runTaskAndSaveResult(args[0]);
			} catch (TaskException e) {
				e.printStackTrace();
				LogFileUtils.logErrorToLogFile(e.getMessage());
			}
		}else{
			log.error("Please provide an json string!");
		}
	}
}
