package dev.haskin.java_mod_6_spring_web_lab_1;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaMod6SpringWebLab1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaMod6SpringWebLab1Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return (args) -> {
			System.out.println("hello World");
		};
	}

}
