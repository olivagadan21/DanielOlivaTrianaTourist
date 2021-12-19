package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.category;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component@RequiredArgsConstructor
public class CategoryDtoConverter {

    public Category createCategoryDtoToCategory (CreateCategoryDto createCategoryDto) {

        return Category.builder()
                .name(createCategoryDto.getName())
                .build();

    }

}
