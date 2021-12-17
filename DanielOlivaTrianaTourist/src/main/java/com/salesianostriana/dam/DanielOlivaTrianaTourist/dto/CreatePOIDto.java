package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePOIDto {

    private String name;

    private String location;

    private String description;

    private LocalDate date;

    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

}
