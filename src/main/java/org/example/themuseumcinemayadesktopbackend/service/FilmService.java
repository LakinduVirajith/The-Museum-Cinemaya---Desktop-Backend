package org.example.themuseumcinemayadesktopbackend.service;

import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.example.themuseumcinemayadesktopbackend.dto.FilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface FilmService {

    ResponseEntity<String> addFilm(Film film);

    Optional<Film> getFilmById(Integer id);

    ResponseEntity<String> updateFilm(Film film);

    ResponseEntity<String> deleteFilm(Integer id);

    ResponseEntity<String> setAsLocked(Integer id);

    ResponseEntity<String> setAsUnlocked(Integer id);

    Page<FilmDTO> infiniteScroll(Pageable pageable);

    Page<FilmDTO> searchFilms(String entityName, String searchValue, Pageable pageable);
}
