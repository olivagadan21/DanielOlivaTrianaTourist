package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.pOI;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component@RequiredArgsConstructor
public class POIDtoConverter {

    private final CategoryService categoryService;

    public POI createPOIDtoToPOI (CreatePOIDto p) {

        return POI.builder()
                .id(p.getId())
                .name(p.getName())
                .location(p.getLocation())
                .description(p.getDescription())
                .date(p.getDate())
                .category(categoryService.findById(p.getCategory()))
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();

    }

}
