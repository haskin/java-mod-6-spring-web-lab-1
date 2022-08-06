package dev.haskin.java_mod_6_spring_web_lab_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.haskin.java_mod_6_spring_web_lab_1.model.Activity;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Camper;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Signup;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.ActivityRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.CamperRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.SignupRepository;

@SpringBootApplication
public class JavaMod6SpringWebLab1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaMod6SpringWebLab1Application.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner runner(ActivityRepository activityRepository, CamperRepository camperRepository,
			SignupRepository signupRepository, ModelMapper ModelMapper) {
		return (args) -> {
			Activity archery = activityRepository
					.save(new Activity(1L, "Archery", 2, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Activity swimming = activityRepository
					.save(new Activity(2L, "Swimming", 3, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Camper caitlin = camperRepository
					.save(new Camper(1L, "Caitlin", 8, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Camper lizzie = camperRepository
					.save(new Camper(2L, "Lizzie", 9, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Signup archerySignup = signupRepository
					.save(new Signup(1L, 9, LocalDate.now(), LocalDate.now(), archery, caitlin));
			Signup swimmingSignup = signupRepository
					.save(new Signup(2L, 10, LocalDate.now(), LocalDate.now(), swimming, caitlin));
			archery.setSignups(List.of(archerySignup, swimmingSignup));
			caitlin.setSignups(List.of(archerySignup, swimmingSignup));
		};
	}

}
