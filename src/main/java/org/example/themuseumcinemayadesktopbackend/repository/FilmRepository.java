package org.example.themuseumcinemayadesktopbackend.repository;

import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.example.themuseumcinemayadesktopbackend.dto.FilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {

    Optional<Film> findByFilmNumber(Integer filmNumber);

    void deleteByFilmNumber(Integer id);

    Page<FilmDTO> findByFilmNumber(Integer searchValue, Pageable pageable);

    Page<FilmDTO> findByReferenceContaining(String searchValue, Pageable pageable);

    Page<FilmDTO> findByReleaseDateContaining(String searchValue, Pageable pageable);

    Page<FilmDTO> findByFilmTitleContaining(String searchValue, Pageable pageable);

    Page<FilmDTO> findBySynopsisContaining(String searchValue, Pageable pageable);

    Page<FilmDTO> findByProductionContaining(String searchValue, Pageable pageable);

    Page<FilmDTO> findByDirectorContaining(String searchValue, Pageable pageable);

    Page<FilmDTO> findByProducerContaining(String searchValue, Pageable pageable);
}
