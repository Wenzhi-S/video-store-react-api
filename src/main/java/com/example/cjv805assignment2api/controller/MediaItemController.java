package com.example.cjv805assignment2api.controller;

import com.example.cjv805assignment2api.model.MediaItem;
import com.example.cjv805assignment2api.service.MediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mediaItems")
public class MediaItemController {

    private final MediaItemService service;

    @Autowired
    public MediaItemController(MediaItemService service) {
        this.service = service;
    }

    @PostMapping
    public MediaItem createMediaItem(@RequestBody MediaItem item) {
        return service.saveMediaItem(item);
    }

    @GetMapping("/movies")
    public List<MediaItem> getAllMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/tvShows")
    public List<MediaItem> getAllTvShows() {
        return service.getAllTvShows();
    }

    @GetMapping("/search")
    public List<MediaItem> searchByTitle(@RequestParam String title) {
        return service.searchByTitle(title);
    }

    @GetMapping("/featured/movies")
    public List<MediaItem> getFeaturedMovies() {
        return service.getFeaturedMovies();
    }

    @GetMapping("/featured/tvShows")
    public List<MediaItem> getFeaturedTvShows() {
        return service.getFeaturedTvShows();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaItem> getById(@PathVariable String id) {
        MediaItem item = service.findById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
