package org.example.themuseumcinemayadesktopbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.example.themuseumcinemayadesktopbackend.dto.FilmDTO;
import org.example.themuseumcinemayadesktopbackend.repository.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            filmRepository.save(film);
            return ResponseEntity.status(HttpStatus.CREATED).body("Film created successfully");
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
            if(existingFilm.get().getIsLocked()){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The film is locked and cannot be deleted.");
            }else{
                filmRepository.deleteByFilmNumber(id);
                return ResponseEntity.status(HttpStatus.OK).body("Film successfully deleted. Film number: " + String.format("%05d", existingFilm.get().getFilmNumber()));
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found");
        }
    }

    @Override
    public ResponseEntity<String> setAsLocked(Integer id) {
        Optional<Film> existingFilmOptional  = filmRepository.findByFilmNumber(id);

        if(existingFilmOptional.isPresent()){
            Film existingFilm = existingFilmOptional.get();

            if(existingFilm.getIsLocked()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("The film is already locked");
            }else{
                existingFilm.setIsLocked(true);
                filmRepository.save(existingFilm);
                return ResponseEntity.status(HttpStatus.OK).body("Film successfully set as locked");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found with film number: " + String.format("%05d", id));
        }
    }

    @Override
    public ResponseEntity<String> setAsUnlocked(Integer id) {
        Optional<Film> existingFilmOptional  = filmRepository.findByFilmNumber(id);

        if(existingFilmOptional.isPresent()){
            Film existingFilm = existingFilmOptional.get();

            if(!existingFilm.getIsLocked()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("The film is already unlocked");
            }else{
                existingFilm.setIsLocked(false);
                filmRepository.save(existingFilm);
                return ResponseEntity.status(HttpStatus.OK).body("Film successfully set as unlocked");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film not found with film number: " + String.format("%05d", id));
        }
    }

    @Override
    public Page<FilmDTO> infiniteScroll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("filmNumber"));
        return getFilmDTOS(pageable);
    }

    @Override
    public Page<FilmDTO> searchFilms(String entityName, String searchValue, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("filmNumber"));

        // Construct the query based on the selected entity name and search value
        if ("filmNumber".equalsIgnoreCase(entityName)) {
            int value;
            try{
                value = Integer.parseInt(searchValue);
                return filmRepository.findByFilmNumber(value, pageable);
            }catch (Exception e){
                return getFilmDTOS(pageable);
            }
        } else if ("reference".equalsIgnoreCase(entityName)) {
            return filmRepository.findByReferenceContaining(searchValue, pageable);
        } else if ("releaseDate".equalsIgnoreCase(entityName)) {
            return filmRepository.findByReleaseDateContaining(searchValue, pageable);
        }else if ("filmTitle".equalsIgnoreCase(entityName)) {
            return filmRepository.findByFilmTitleContaining(searchValue, pageable);
        }else if ("synopsis".equalsIgnoreCase(entityName)) {
            return filmRepository.findBySynopsisContaining(searchValue, pageable);
        }else if ("production".equalsIgnoreCase(entityName)) {
            return filmRepository.findByProductionContaining(searchValue, pageable);
        }else if ("director".equalsIgnoreCase(entityName)) {
            return filmRepository.findByDirectorContaining(searchValue, pageable);
        }else if ("producer".equalsIgnoreCase(entityName)) {
            return filmRepository.findByProducerContaining(searchValue, pageable);
        }

        // Default case: if no specific entity name is selected, return all films
        return getFilmDTOS(pageable);
    }

    private Page<FilmDTO> getFilmDTOS(Pageable pageable) {
        Page<Film> films = filmRepository.findAll(pageable);

        return films.map(film -> FilmDTO.builder()
                .filmNumber(film.getFilmNumber())
                .reference(film.getReference())
                .releaseDate(film.getReleaseDate())
                .filmTitle(film.getFilmTitle())
                .synopsis(film.getSynopsis())
                .production(film.getProduction())
                .director(film.getDirector())
                .producer(film.getProducer())
                .build());
    }
}
