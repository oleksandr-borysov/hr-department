package com.ab.hr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * The Spring boot application entry point.
 * 
 * @author ab
 */
@Import(CtxConfiguration.class)
@SpringBootApplication(scanBasePackages = { "com.ab.hr" })
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
}
