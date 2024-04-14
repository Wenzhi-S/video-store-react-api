package com.example.cjv805assignment2api.repository;

import com.example.cjv805assignment2api.model.MediaItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MediaItemRepository extends MongoRepository<MediaItem, String> {
    List<MediaItem> findByType(String type);
    List<MediaItem> findByTitleContainingIgnoreCase(String title);
    List<MediaItem> findByFeaturedAndType(boolean featured, String type);
}
