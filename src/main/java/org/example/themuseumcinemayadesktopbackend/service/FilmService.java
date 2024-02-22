package org.example.themuseumcinemayadesktopbackend.service;

import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface FilmService {

    ResponseEntity<String> addFilm(Film film);

    Optional<Film> getFilmById(Integer id);

    ResponseEntity<String> updateFilm(Film film);

    ResponseEntity<String> deleteFilm(Integer id);

    Page<Film> infiniteScroll(Pageable pageable);
}
