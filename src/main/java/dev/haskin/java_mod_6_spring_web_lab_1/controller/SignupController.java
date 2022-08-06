package dev.haskin.java_mod_6_spring_web_lab_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.SignupDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.service.SignupService;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    SignupService signupService;

    @PostMapping
    SignupDTO postSignup(@RequestBody SignupDTO signupDTO) {
        return signupService.createSignup(signupDTO);
    }
}
