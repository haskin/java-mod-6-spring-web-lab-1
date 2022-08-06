
package dev.haskin.java_mod_6_spring_web_lab_1.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.SignupDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Signup;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.ActivityRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.CamperRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.SignupRepository;

@Service
public class SignupService {
    @Autowired
    SignupRepository signupRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    CamperRepository camperRepository;
    @Autowired
    ModelMapper modelMapper;

    public SignupDTO createSignup(SignupDTO signupDTO) {
        Signup signup = modelMapper.map(signupDTO, Signup.class);
        signup.setCamper(camperRepository.findById(signupDTO.getCamperId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation error")));
        signup.setActivity(activityRepository.findById(signupDTO.getActivityId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation error")));
        try {
            signup = signupRepository.save(signup);
            signupDTO = modelMapper.map(signup, SignupDTO.class);
            signupDTO.setActivityId(signup.getActivity().getId());
            signupDTO.setCamperId(signup.getCamper().getId());
            return signupDTO;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation errors");
        }
    }
}