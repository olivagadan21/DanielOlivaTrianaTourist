package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDto {

    private String name;

}
