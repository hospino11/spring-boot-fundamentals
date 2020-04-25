package com.pluralsight.fundamentals.web;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.fundamentals.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/tza")
@RequiredArgsConstructor
public class TzaRestController {

    private final ApplicationService applicationService;

    @GetMapping("applications")
    public ResponseEntity<Iterable<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.listApplications());
    }

    @GetMapping("applications/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(applicationService.getApplicationById(id));
        } catch (ApplicationNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
        }
    }
}
