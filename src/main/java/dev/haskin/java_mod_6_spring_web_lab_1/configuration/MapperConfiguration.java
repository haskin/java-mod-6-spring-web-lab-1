package dev.haskin.java_mod_6_spring_web_lab_1.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    ModelMapper getMapper() {
        return new ModelMapper();
    }
}
