package com.mytt.hashtranslatorservice.web;

import com.mytt.hashtranslatorservice.dto.ApplicationDto;
import com.mytt.hashtranslatorservice.model.Application;
import com.mytt.hashtranslatorservice.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = ApplicationController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    static final String REST_URL = "/api/users/application";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> createWithLocation(@RequestBody @Valid Application application) {
        Application created = applicationService.save(application);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("/{id}/hash")
    public ApplicationDto getHash(@PathVariable int id) {
        return applicationService.getHash(id);
    }

    @GetMapping("/{id}")
    public Application get(@PathVariable int id) {
        return applicationService.get(id);
    }
}