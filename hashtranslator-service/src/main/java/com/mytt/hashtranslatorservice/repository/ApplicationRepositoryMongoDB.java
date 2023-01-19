package com.mytt.hashtranslatorservice.repository;

import com.mytt.hashtranslatorservice.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepositoryMongoDB extends MongoRepository <Application, Integer> {
}
