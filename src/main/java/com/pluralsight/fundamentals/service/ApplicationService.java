package com.pluralsight.fundamentals.service;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }
}
