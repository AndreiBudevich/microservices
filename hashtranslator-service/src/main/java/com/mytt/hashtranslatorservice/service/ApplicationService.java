package com.mytt.hashtranslatorservice.service;

import com.mytt.hashtranslatorservice.model.Application;


public interface ApplicationService {

    Application get(int id);

    Application save(Application application);
}