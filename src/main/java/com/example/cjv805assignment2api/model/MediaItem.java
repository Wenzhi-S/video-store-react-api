package com.example.cjv805assignment2api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mediaItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaItem {
    @Id
    private String id;
    private String title;
    private String synopsis;

    @ElementCollection
    private List<String> actors;

    private String type;
    private String poster;
    private double rentPrice;
    private double purchasePrice;
    private boolean featured;
}
