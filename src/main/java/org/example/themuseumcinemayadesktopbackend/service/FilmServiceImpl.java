package org.example.themuseumcinemayadesktopbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.example.themuseumcinemayadesktopbackend.repository.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService{

    private final FilmRepository filmRepository;

    @Override
    public ResponseEntity<String> addFilm(Film film) {
        Optional<Film> existingFilm = filmRepository.findByFilmNumber(film.getFilmNumber());

        if(existingFilm.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A film with the given number already exists");
        }else{
            try {
                filmRepository.save(film);
                return ResponseEntity.status(HttpStatus.CREATED).body("Film created successfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create the film");
            }
        }
    }

    @Override
    public Optional<Film> getFilmById(Integer id) {
        return filmRepository.findByFilmNumber(id);
    }

    @Override
    public ResponseEntity<String> updateFilm(Film film) {
        Optional<Film> existingFilm = filmRepository.findByFilmNumber(film.getFilmNumber());

        if (existingFilm.isPresent()) {
            filmRepository.save(film);
            return ResponseEntity.ok("Film updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found");
        }
    }

    @Override
    public ResponseEntity<String> deleteFilm(Integer id) {
        Optional<Film> existingFilm = filmRepository.findByFilmNumber(id);

        if(existingFilm.isPresent()){
            filmRepository.deleteByFilmNumber(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Film successfully deleted. Film ID: " + existingFilm.get().getFilmNumber());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found");
        }
    }
}
