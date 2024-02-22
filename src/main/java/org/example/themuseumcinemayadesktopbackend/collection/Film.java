package org.example.themuseumcinemayadesktopbackend.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Builder
@Document("Films")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    private Integer filmNumber;
    private String reference;
    private String releaseDate;
    private String filmTitle;
    private String synopsis;
    private String production;
    private String[] director;
    private String[] producer;
    private String cast;
    private String script;
    private String camera;
    private String editor;
    private String music;
    private String story;
    private String dialogue;
    private String assistantDirector;
    private String lyrics;
    private String songs;
    private String makeup;
    private String artDirector;
    private String audioController;
    private String title;
    private String theaters;
    private String awardPresidential;
    private String awardSarasaviya;
    private String awardsOcic;
    private String awardOthers;
    private String festivals;
    private String article;
    private String critics;
    private String others;
    private String Special;
    private String Poster;
    private String Image;
    private String acknowledgement;
    private String payOffLine;
    private String lastUpDate;
}
