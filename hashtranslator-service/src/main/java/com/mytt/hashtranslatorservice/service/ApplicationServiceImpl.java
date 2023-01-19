package com.mytt.hashtranslatorservice.service;

import com.mytt.hashtranslatorservice.model.Application;
import com.mytt.hashtranslatorservice.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final SequenceGeneratorService sequenceGeneratorService;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.applicationRepository = applicationRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Application get(int id) {
        return applicationRepository.get(id).orElse(null);
    }

    @Override
    public Application save(Application application) {
        application.setId(sequenceGeneratorService.getNextSequence("db_sequence"));
        return applicationRepository.save(application);
    }
}
