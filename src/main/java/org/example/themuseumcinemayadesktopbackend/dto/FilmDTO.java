package org.example.themuseumcinemayadesktopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private Integer filmNumber;
    private String reference;
    private String releaseDate;
    private String filmTitle;
    private String synopsis;
    private String production;
    private String[] director;
    private String[] producer;
}
