package dev.haskin.java_mod_6_spring_web_lab_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.haskin.java_mod_6_spring_web_lab_1.model.Camper;

public interface CamperRepository extends JpaRepository<Camper, Long> {

}
