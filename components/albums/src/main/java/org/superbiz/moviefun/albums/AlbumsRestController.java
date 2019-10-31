package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsRestController {

    private AlbumsRepository albumsRepository;

    public AlbumsRestController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album){
        albumsRepository.addAlbum(album);
    }

    @DeleteMapping("/{albumId}")
    public void delete(@PathVariable Long albumId){
        Album album = this.find(albumId);
        if(album != null) {
            albumsRepository.deleteAlbum(album);
        }
    }

    @PostMapping("/{albumId}")
    public void update(@RequestBody Album album){
        albumsRepository.updateAlbum(album);
    }

    @GetMapping("/{albumId}")
    public Album find(@PathVariable Long albumId){
        return albumsRepository.find(albumId);
    }

    @GetMapping
    public List<Album> findAll(){
        return albumsRepository.getAlbums();
    }
}
