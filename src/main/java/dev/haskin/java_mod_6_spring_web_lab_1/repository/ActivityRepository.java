package dev.haskin.java_mod_6_spring_web_lab_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.haskin.java_mod_6_spring_web_lab_1.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
