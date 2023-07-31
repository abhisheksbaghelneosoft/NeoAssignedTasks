package com.ff4j.loggertoggle;

import com.ff4j.loggertoggle.configs.AppenderManipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerToggleApplication implements CommandLineRunner {

	@Autowired
	private AppenderManipulation appenderManipulation;

	public static void main(String[] args) {
		SpringApplication.run(LoggerToggleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appenderManipulation.saveAllAppenders();
	}
}
