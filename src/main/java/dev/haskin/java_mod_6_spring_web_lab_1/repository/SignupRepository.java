package dev.haskin.java_mod_6_spring_web_lab_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.haskin.java_mod_6_spring_web_lab_1.model.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {

}
