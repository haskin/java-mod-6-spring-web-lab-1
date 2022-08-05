package dev.haskin.java_mod_6_spring_web_lab_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @GetMapping
    String getActivities() {
        return "new ArrayList<>()";
    }
}
