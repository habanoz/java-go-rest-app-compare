package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@SpringBootApplication
public class Main {

    private final Map<String, Album> albums;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(Main.class, args);
        System.out.println("Ready"+(System.currentTimeMillis()-start));
    }

    public Main() {
        albums = new ConcurrentHashMap<>();
        albums.put("1", new Album("1", "Blue Train", "John Coltrane", 56.99f));
        albums.put("2", new Album("2", "Jeru", "Gerry Mulligan", 17.99f));
        albums.put("3", new Album("3", "Sarah Vaughan and Clifford Brown", "Sarah Vaughan", 39.99f));
    }

    @GetMapping("/albums")
    public Collection<Album> getAlbums() {
        return albums.values();
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<?> getAlbumById(@PathVariable String id) {
        Album album = albums.get(id);
        if (album != null) return ResponseEntity.ok(album);
        return ResponseEntity.status(404).body("message: album not found");
    }

    @PostMapping("/albums")
    public ResponseEntity<?> postAlbums(@RequestBody Album album) {
        albums.put(album.id(), album);
        return ResponseEntity.status(HttpStatus.CREATED).body(album);
    }

}

record Album(String id, String title, String artist, float price) {
}
