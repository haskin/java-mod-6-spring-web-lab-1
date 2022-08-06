package dev.haskin.java_mod_6_spring_web_lab_1.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.haskin.java_mod_6_spring_web_lab_1.dto.ActivityDTO;
import dev.haskin.java_mod_6_spring_web_lab_1.model.Activity;
import dev.haskin.java_mod_6_spring_web_lab_1.repository.ActivityRepository;
import dev.haskin.java_mod_6_spring_web_lab_1.service.ActivityService;
import dev.haskin.java_mod_6_spring_web_lab_1.util.MapperUtil;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping
    List<ActivityDTO> getActivities() {
        return activityService.readAllActivities();
    }

    @DeleteMapping("/{id}")
    ActivityDTO delectActivityById(@PathVariable Long id) {
        return activityService.deleteActivityById(id);
    }
    // @GetMapping
    // <ActivityDTO> getActivities() {
    // List<Activity> activities = activityRepository.findAll();
    // s.stream()
    // .map(activity -> modelMapper.map(activity, ActivityDTO.class))
    // .collect(Collectors.toList());
    // }
}
