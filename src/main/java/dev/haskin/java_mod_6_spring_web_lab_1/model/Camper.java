package dev.haskin.java_mod_6_spring_web_lab_1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "campers")
@Data
@NoArgsConstructor
public class Camper {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @Min(8)
    @Max(18)
    private int age;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "camper")
    List<Signup> singups = new ArrayList<>();
}
