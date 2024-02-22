package org.example.themuseumcinemayadesktopbackend.repository;

import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {

    Optional<Film> findByFilmNumber(int filmNumber);

    void deleteByFilmNumber(Integer id);

    Page<Film> findByFilmNumberContaining(String searchValue, Pageable pageable);

    Page<Film> findByReferenceContaining(String searchValue, Pageable pageable);

    Page<Film> findByReleaseDateContaining(String searchValue, Pageable pageable);

    Page<Film> findByFilmTitleContaining(String searchValue, Pageable pageable);

    Page<Film> findBySynopsisContaining(String searchValue, Pageable pageable);

    Page<Film> findByProductionContaining(String searchValue, Pageable pageable);

    Page<Film> findByDirectorContaining(String searchValue, Pageable pageable);

    Page<Film> findByProducerContaining(String searchValue, Pageable pageable);
}
