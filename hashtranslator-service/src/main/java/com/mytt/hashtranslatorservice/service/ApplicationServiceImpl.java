package com.mytt.hashtranslatorservice.service;

import com.mytt.hashtranslatorservice.dto.ApplicationDto;
import com.mytt.hashtranslatorservice.model.Application;
import com.mytt.hashtranslatorservice.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private static final String URI = "https://md5decrypt.net/en/Api/api.php?hash=";
    private static final String HASH_TYPE = "md5";
    private static final String EMAIL = "budevichac01@gmail.com";
    private static final String CODE = "b4c9f70544a52835";

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

    @Override
    public ApplicationDto getHash(int id) {
        Application application = get(id);
        List<String> hashes = application.getHashes();
        ApplicationDto applicationDto = new ApplicationDto();
        Map<String, String> result = new HashMap<>(hashes.size());
        hashes.forEach(hash -> result.put(hash, getMD5(hash)));
        applicationDto.setHashes(result);
        return applicationDto;
    }

    private static String getMD5(String hash) {
        log.info("request " + URI);
        String uri = URI + hash + "&hash_type=" + HASH_TYPE + "&email=" + EMAIL + "&code=" + CODE;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
