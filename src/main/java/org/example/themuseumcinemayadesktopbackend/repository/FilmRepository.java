package org.example.themuseumcinemayadesktopbackend.repository;

import org.example.themuseumcinemayadesktopbackend.collection.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {

    Optional<Film> findByFilmNumber(int filmNumber);

    void deleteByFilmNumber(Integer id);
}
