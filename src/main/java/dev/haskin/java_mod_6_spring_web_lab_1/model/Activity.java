package dev.haskin.java_mod_6_spring_web_lab_1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "activities")
@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int difficulty;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "activity")
    List<Signup> singups = new ArrayList<>();
}
