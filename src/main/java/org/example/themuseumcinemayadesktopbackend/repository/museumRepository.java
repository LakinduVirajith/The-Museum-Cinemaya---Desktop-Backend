package org.example.themuseumcinemayadesktopbackend.repository;

import org.example.themuseumcinemayadesktopbackend.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
public interface museumRepository extends MongoRepository<Task, String> {
List<Task> findByFilmnumber(int filmnumber);


}
