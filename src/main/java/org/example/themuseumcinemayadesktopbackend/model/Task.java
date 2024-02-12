package org.example.themuseumcinemayadesktopbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String fid;
    private int filmnumber;
    private String referance;
    private String rdate;
    private String rday;
    private String ftitle;
    private String synopsis;
    private String production;
    private String director;
    private String producer;
    private String cast;
    private String script;
    private String camera;
    private String editor;
    private String music;
    private String story;
    private String dialogue;
    private String assdirector;
    private String lyrics;
    private String songs;
    private String makeup;
    private String artdirector;
    private String audiocontroller;
    private String tittle;
    private String theaters;
    private String awardspre;
    private String awardsarasaviya;
    private String awardocic;
    private String awardothers;
    private String festivals;
    private String article;
    private String critics;
    private String others;
    private String refferance;
    private String special;
    private String poster;
    private String image;
    private String acknolegement;
    private String payoffline;
    private String lastupdate;

    public void setfid(String s) {
    }
}
