package dev.haskin.java_mod_6_spring_web_lab_1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupDTO {
    private int time;
    @JsonProperty("camper_id")
    private Long camperId;
    @JsonProperty("activity_id")
    private Long activityId;
}
