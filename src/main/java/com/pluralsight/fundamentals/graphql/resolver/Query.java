package com.pluralsight.fundamentals.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final ApplicationRepository applicationRepository;

    public Iterable<Application> findAllApplications() {
        return applicationRepository.findAll();
    }

    public long countApplications() {
        return applicationRepository.count();
    }
}
