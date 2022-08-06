
package dev.haskin.java_mod_6_spring_web_lab_1.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.SignupDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Signup;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.SignupRepository;

@Service
public class SignupService {
    @Autowired
    SignupRepository signupRepository;
    @Autowired
    ModelMapper modelMapper;

    public SignupDTO createSignup(SignupDTO signupDTO) {
        Signup signup = modelMapper.map(signupDTO, Signup.class);
        try {
            signup = signupRepository.save(signup);
            return modelMapper.map(signup, SignupDTO.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation errors");
        }
    }
}