package org.example.themuseumcinemayadesktopbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.example.themuseumcinemayadesktopbackend.dto.FilmDTO;
import org.example.themuseumcinemayadesktopbackend.service.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
@Tag(name = "film-controllers")
public class FilmController {

    private final FilmService filmService;

    @PostMapping("/create")
    @Operation(summary = "create film", description = "record a new film details by providing the necessary details")
    public ResponseEntity<String> createFilm(@RequestBody Film film){
        return filmService.addFilm(film);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get film", description = "retrieve film based on id")
    public ResponseEntity<?> getFilm(@PathVariable Integer id){
        Optional<Film> optionalFilm = filmService.getFilmById(id);

        if (optionalFilm.isPresent()) {
            return ResponseEntity.ok(optionalFilm.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found with film number: " + String.format("%05d", id));
        }
    }

    @PutMapping("/update")
    @Operation(summary = "update film", description = "update film based on id")
    public ResponseEntity<String> updateFilm(@RequestBody Film film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete film", description = "delete film based on id")
    public ResponseEntity<String> deleteFilm(@PathVariable Integer id){
        return filmService.deleteFilm(id);
    }

    @PutMapping("/set/locked/{id}")
    @Operation(summary = "set as locked film", description = "set as locked film based on id")
    public ResponseEntity<String> setAsLocked(@PathVariable Integer id){
        return filmService.setAsLocked(id);
    }

    @PutMapping("/set/unlocked/{id}")
    @Operation(summary = "set as unlocked film", description = "set as unlocked film based on id")
    public ResponseEntity<String> setAsUnlocked(@PathVariable Integer id){
        return filmService.setAsUnlocked(id);
    }

    @GetMapping("/scroll")
    @Operation(summary = "get films with pagination and sorting", description = "retrieve a paginated list of films sorted by film number for the home page")
    public Page<FilmDTO> infiniteScroll(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "60") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return filmService.infiniteScroll(pageable);
    }

    @GetMapping("/search")
    @Operation(summary = "search films by entity name with pagination and sorting", description = "retrieve a paginated list of films sorted by film number, with optional search criteria by entity name")
    public Page<FilmDTO> searchFilms(@RequestParam String entityName,
                                  @RequestParam String searchValue,
                                  @RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "60") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return filmService.searchFilms(entityName, searchValue, pageable);
    }
}
