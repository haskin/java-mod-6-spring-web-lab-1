package dev.haskin.java_mod_6_spring_web_lab_1.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CamperNoActivityDTO {
    private Long id;
    private String name;
    private int age;
    // private List<ActivityDTO> activities = new ArrayList<>();
}