package com.pluralsight.fundamentals.util;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DatabaseLoader {

    @Bean
    public CommandLineRunner demo(ApplicationRepository applicationRepository) {
        return args -> {
            applicationRepository.save(Application.builder().name("Trackzilla").owner("kesha.williams").description("Application for tracking bugs.").build());
            applicationRepository.save(Application.builder().name("Expenses").owner("mary.jones").description("Application to track expense reports.").build());
            applicationRepository.save(Application.builder().name("Notifications").owner("karen.kane").description("Application to send alerts and notifications.").build());

            applicationRepository.findAll().forEach(application -> log.info("The application is {}", application.toString()));
        };
    }
}
