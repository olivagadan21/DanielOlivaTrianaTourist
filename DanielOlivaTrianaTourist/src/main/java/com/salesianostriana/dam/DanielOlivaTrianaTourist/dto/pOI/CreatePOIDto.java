package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.pOI;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.ExistingCategory;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueURL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UniqueURL(url1 = "coverPhoto", url2 = "photo2", url3 = "photo3", message = "Una de las imágenes está repetida.")
public class CreatePOIDto {

    private String name;

    private String location;

    private String description;

    private LocalDate date;

    private Long category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

}
