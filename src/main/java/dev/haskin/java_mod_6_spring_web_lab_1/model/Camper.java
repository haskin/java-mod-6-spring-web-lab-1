package dev.haskin.java_mod_6_spring_web_lab_1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "campers")
@Data
public class Camper {
    private Long id;
    private String name;
    private int age;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "camper")
    List<Signup> singups = new ArrayList<>();
}
