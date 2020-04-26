package com.pluralsight.fundamentals.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutator implements GraphQLMutationResolver {

    private final ApplicationRepository applicationRepository;

    public Application newApplication(String name, String description, String owner) {
        Application newApplication = Application.builder()
                .name(name)
                .description(description)
                .owner(owner)
                .build();
        return applicationRepository.save(newApplication);
    }

    public boolean deleteApplication(Integer id) {
        applicationRepository.deleteById(id);
        return true;
    }

    public Application updateApplicationOwner(Integer id, String newOwner) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found", id));

        Application newApplication = application.toBuilder()
                .owner(newOwner)
                .build();

        return applicationRepository.save(newApplication);
    }
}
