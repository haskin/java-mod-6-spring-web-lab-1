
package dev.haskin.java_mod_6_spring_web_lab_1.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.ActivityDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.dto.CamperDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Activity;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Camper;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Signup;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.CamperRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.util.MapperUtil;

@Service
public class CamperService {

    @Autowired
    CamperRepository camperRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MapperUtil mapperUtil;

    public List<CamperDTO> readAllCampers() {
        List<Camper> campers = camperRepository.findAll();
        List<CamperDTO> campersDTO = mapperUtil.mapList(camperRepository.findAll(), CamperDTO.class);
        // campers.stream().map(camper -> (HashMap<Camper, List<Signup>>)Map.of(camper,
        // camper.getSignups())).;
        IntStream.range(0, campers.size())
                .forEach(i -> campersDTO.get(i).setActivities(
                        campers.get(i).getSignups().stream()
                                .map(Signup::getActivity)
                                .map(activity -> modelMapper.map(activity, ActivityDTO.class))
                                .collect(Collectors.toList())));
        return campersDTO;
    }

    public CamperDTO readCamperById(Long id) {
        Camper camper = camperRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Camper not found"));
        CamperDTO camperDTO = modelMapper.map(camper, CamperDTO.class);
        List<Signup> signups = camper.getSignups();
        List<Activity> activities = signups.stream().map(Signup::getActivity).collect(Collectors.toList());
        camperDTO.setActivities(mapperUtil.mapList(activities, ActivityDTO.class));
        return camperDTO;
    }

    public CamperDTO createCamper(CamperDTO camperDTO) {
        Camper camper = modelMapper.map(camperDTO, Camper.class);
        try {
            camper = camperRepository.save(camper);
            return modelMapper.map(camper, CamperDTO.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation errors");
        }
    }
}