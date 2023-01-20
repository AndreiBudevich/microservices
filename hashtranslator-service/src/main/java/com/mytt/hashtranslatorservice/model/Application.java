package com.mytt.hashtranslatorservice.model;

import com.mytt.common.model.util.util.validation.NoHtml;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "applications")
@Getter
@Setter
public class Application {

    @Id
    private int id;

    @NoHtml
    @NotNull
    private List<String> hashes;

    public Application(int id, List<String> hashes) {
        this.id = id;
        this.hashes = hashes;
    }
}
