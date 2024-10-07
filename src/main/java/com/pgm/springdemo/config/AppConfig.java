package com.pgm.springdemo.config;

import com.pgm.springdemo.sample.SampleDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SampleDTO myDto1(){
        String[] hobbies = {"여행", "코딩"};
        return new SampleDTO("오은호", 27, hobbies);
    }
    @Bean
    public SampleDTO myDto2(){
        String[] hobbies = {"독서", "운동"};
        return new SampleDTO("박경미", 20, hobbies);
    }
}
