package com.mytt.hashtranslatorservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ApplicationDto {

    private Map<String, String> hashes;
}