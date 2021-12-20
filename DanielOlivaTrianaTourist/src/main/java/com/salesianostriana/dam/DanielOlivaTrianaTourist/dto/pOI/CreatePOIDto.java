package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.pOI;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.ExistingCategory;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueURL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UniqueURL(url1 = "coverPhoto", url2 = "photo2", url3 = "photo3", message = "Una de las imágenes está repetida.")
public class CreatePOIDto {

    private Long id;

    private String name;

    @Pattern(regexp = "^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$", message = "{format.location}")
    private String location;

    private String description;

    private LocalDate date;

    @ExistingCategory(message = "{existing.category}")
    private Long category;

    @URL(message = "{url}")
    @NotBlank(message = "{not.blank}")
    private String coverPhoto;

    @URL(message = "{url}")
    private String photo2;

    @URL(message = "{url}")
    private String photo3;

}
