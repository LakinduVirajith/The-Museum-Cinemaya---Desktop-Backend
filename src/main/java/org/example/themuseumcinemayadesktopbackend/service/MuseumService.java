package org.example.themuseumcinemayadesktopbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.themuseumcinemayadesktopbackend.model.Task;
import org.example.themuseumcinemayadesktopbackend.repository.museumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class MuseumService {

    private final museumRepository repository;

public Task addfillm(Task task){
    task.setfid(UUID.randomUUID().toString().split("-")[0]);
    return repository.save(task);
}
public List<Task> findAllFilm(){
    return repository.findAll();
}

public Task getfilmskByfid(String fid){
    return repository.findById(fid).get();
}
public List<Task> getfilmByfilmnumber(int filmnumber){
    return repository.findByFilmnumber(filmnumber);
}
public Task updatefilm(Task taskRequest){
   Task extask = repository.findById(taskRequest.getFid()).get();
    extask.setAcknolegement(taskRequest.getAcknolegement());
    extask.setArtdirector(taskRequest.getArtdirector());
    return repository.save(extask);
}
public String deletefilm(String fid){
    repository.deleteById(fid);
    return fid+"Delete";
}
}
