
package dev.haskin.java_mod_6_spring_web_lab_1.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    private Optional<Activity> readActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public ActivityDTO deleteActivityById(Long id) {
        Activity activity = readActivityById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Activity not found"));
        activityRepository.delete(activity);
        return modelMapper.map(activity, ActivityDTO.class);
    }
}