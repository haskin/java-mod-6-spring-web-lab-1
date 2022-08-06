package dev.haskin.java_mod_6_spring_web_lab_1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupDTO {
    private int time;
    private Long camperId;
    private Long activityId;
}
