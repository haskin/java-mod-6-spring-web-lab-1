package dev.haskin.java_mod_6_spring_web_lab_1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Validations:
 * x must have a name
 * x must have an age between 8 and 18
 */
@Entity
@Table(name = "campers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String name;
    @Min(8)
    @Max(18)
    private int age;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "camper", cascade = CascadeType.REMOVE)
    List<Signup> signups = new ArrayList<>();
}
