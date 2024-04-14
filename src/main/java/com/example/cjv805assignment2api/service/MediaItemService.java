package com.example.cjv805assignment2api.service;

import com.example.cjv805assignment2api.model.MediaItem;
import com.example.cjv805assignment2api.repository.MediaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemService {

    private final MediaItemRepository repository;

    @Autowired
    public MediaItemService(MediaItemRepository repository) {
        this.repository = repository;
    }

    public MediaItem saveMediaItem(MediaItem item) {
        return repository.save(item);
    }

    public List<MediaItem> getAllMovies() {
        return repository.findByType("movie");
    }

    public List<MediaItem> getAllTvShows() {
        return repository.findByType("tvShow");
    }

    public List<MediaItem> searchByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<MediaItem> getFeaturedMovies() {
        return repository.findByFeaturedAndType(true, "movie");
    }

    public List<MediaItem> getFeaturedTvShows() {
        return repository.findByFeaturedAndType(true, "tvShow");
    }

    public MediaItem findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


}
