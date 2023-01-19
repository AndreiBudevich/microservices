package com.mytt.hashtranslatorservice.repository;

import com.mytt.hashtranslatorservice.model.Application;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final ApplicationRepositoryMongoDB applicationRepositoryMongoDB;

    public ApplicationRepositoryImpl(ApplicationRepositoryMongoDB applicationRepositoryMongoDB) {
        this.applicationRepositoryMongoDB = applicationRepositoryMongoDB;
    }

    @Override
    public Optional<Application> get(int id) {
        return applicationRepositoryMongoDB.findById(id);
    }

    @Override
    public Application save(Application application) {
        return applicationRepositoryMongoDB.save(application);
    }
}
