package com.pluralsight.fundamentals.service;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Integer id) throws ApplicationNotFoundException {
        return applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException("Application does not exist"));
    }
}
