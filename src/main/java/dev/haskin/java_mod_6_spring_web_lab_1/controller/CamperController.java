package dev.haskin.java_mod_6_spring_web_lab_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.CamperDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.dto.CamperNoActivityDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.service.CamperService;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    CamperService camperService;

    @GetMapping
    public List<CamperNoActivityDTO> getAllCampers() {
        return camperService.readAllCampers();
    }

    @GetMapping("/{id}")
    public CamperDTO getCamperById(@PathVariable Long id) throws Exception {
        return camperService.readCamperById(id);
    }

    @PostMapping
    public CamperNoActivityDTO postCamper(@RequestBody CamperDTO camperDTO) {
        return camperService.createCamper(camperDTO);
    }
}
