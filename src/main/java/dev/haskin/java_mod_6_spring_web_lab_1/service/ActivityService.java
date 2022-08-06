
package dev.haskin.java_mod_6_spring_web_lab_1.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.ActivityDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Activity;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.ActivityRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.util.MapperUtil;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MapperUtil mapperUtil;

    public List<ActivityDTO> readAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return mapperUtil.mapList(activities, ActivityDTO.class);
    }
}