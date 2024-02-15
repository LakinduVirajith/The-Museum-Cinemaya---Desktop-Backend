package org.example.themuseumcinemayadesktopbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.themuseumcinemayadesktopbackend.model.Task;
import org.example.themuseumcinemayadesktopbackend.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class filmController {

    private final MuseumService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createFilm(@RequestBody Task task){
        return service.addfillm(task);
    }
    @GetMapping
    private List<Task> grtFilm(){
        return service.findAllFilm();
    }

    @GetMapping("/{fid}")
    public Task getFilm(@PathVariable String fid){
        return service.getfilmskByfid(fid);
    }
    @GetMapping("/ filmnumber/{filmnumber}")
    public List<Task> findTaskUsingfilmnumber(@PathVariable int filmnumber){
        return service.getfilmByfilmnumber(filmnumber);
    }
    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return service.updatefilm(task);
    }
    @DeleteMapping("/{fid}")
    public String deleteTask(@PathVariable String fid){
        return service.deletefilm(fid);
    }


}
