package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.category;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueNameCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDto {

    private Long id;

    @NotBlank(message = "{not.blank}")
    @UniqueNameCategory(message = "{unique.name}")
    private String name;

}
