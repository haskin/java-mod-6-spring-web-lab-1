package dev.haskin.java_mod_6_spring_web_lab_1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "singups")
@Data
public class Signup {
    @Id
    @GeneratedValue
    private Long id;
    private int time;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Camper camper;
}
