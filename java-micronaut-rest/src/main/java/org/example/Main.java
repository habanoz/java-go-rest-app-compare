package org.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.runtime.Micronaut;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller("/albums")
public class Main {

    private final Map<String, Album> albums;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Micronaut.run(Main.class, args);
        System.out.println("Ready"+(System.currentTimeMillis()-start));
    }

    public Main() {
        albums = new ConcurrentHashMap<>();
        albums.put("1", new Album("1", "Blue Train", "John Coltrane", 56.99f));
        albums.put("2", new Album("2", "Jeru", "Gerry Mulligan", 17.99f));
        albums.put("3", new Album("3", "Sarah Vaughan and Clifford Brown", "Sarah Vaughan", 39.99f));
    }

    @Get
    public Collection<Album> getAlbums() {
        return albums.values();
    }

    @Get("/{id}")
    public HttpResponse<?> getAlbumById(String id) {
        Album album = albums.get(id);
        if (album != null) return HttpResponse.ok(album);
        return HttpResponse.status(HttpStatus.NOT_FOUND).body("message: album not found");
    }

    @Post
    public HttpResponse<Album> postAlbums(@Body Album album) {
        albums.put(album.id(), album);
        return HttpResponse.status(HttpStatus.CREATED).body(album);
    }

}


@Introspected
record Album(String id, String title, String artist, float price) {
}
