package dev.haskin.java_mod_6_spring_web_lab_1.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.ActivityDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.dto.CamperDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Activity;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Camper;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Signup;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.CamperRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.util.MapperUtil;

@RestController
@RequestMapping("/campers")
public class CamperController {

    @Autowired
    CamperRepository camperRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MapperUtil mapperUtil;

    @GetMapping
    public List<CamperDTO> getAllCampers() {
        return mapperUtil.mapList(camperRepository.findAll(), CamperDTO.class);
    }

    @GetMapping("/{id}")
    public CamperDTO getCamperById(@PathVariable Long id) throws Exception {
        Camper camper = camperRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Camper not found"));
        CamperDTO camperDTO = modelMapper.map(camper, CamperDTO.class);
        List<Signup> signups = camper.getSignups();
        List<Activity> activities = signups.stream().map(Signup::getActivity).collect(Collectors.toList());
        camperDTO.setActivities(
                activities.stream()
                        .map(activity -> modelMapper.map(activity, ActivityDTO.class))
                        .collect(Collectors.toList()));
        return camperDTO;
    }

    @PostMapping
    public CamperDTO postCamper(@RequestBody CamperDTO camperDTO) {
        Camper camper = modelMapper.map(camperDTO, Camper.class);
        try {
            camper = camperRepository.save(camper);
            return modelMapper.map(camper, CamperDTO.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation errors");
        }
    }
}
