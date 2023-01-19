package com.mytt.hashtranslatorservice.repository;

import com.mytt.hashtranslatorservice.model.Application;

import java.util.Optional;

public interface ApplicationRepository {

    Optional<Application> get (int id);

    Application save (Application application);
}
