package dev.haskin.java_mod_6_spring_web_lab_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.CamperDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Camper;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.CamperRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.util.MapperUtil;

@RestController
@RequestMapping("/campers")
public class CamperController {

    @Autowired
    CamperRepository camperRepository;

    @Autowired
    MapperUtil<List<Camper>, CamperDTO> mapperUtil;

    @GetMapping
    public List<CamperDTO> getAllCampers() {
        return mapperUtil.mapList(camperRepository.findAll(), CamperDTO.class);
    }
}
