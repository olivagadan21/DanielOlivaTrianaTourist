package com.salesianostriana.dam.DanielOlivaTrianaTourist.services;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repositorio;
    private final CategoryDtoConverter categoryDtoConverter;
    private final POIRepository poiRepository;

    public List<Category> findAll() {

        List<Category> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return result;
        }
    }


    public Category findById(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }


    public Category save(CreateCategoryDto categoryDto) {
        Category category = categoryDtoConverter.createCategoryDtoToCategory(categoryDto);
        repositorio.save(category);
        return category;
    }

    public Optional<Category> edit(Category category, Long id){
        return repositorio.findById(id).map(c -> {
            c.setName(category.getName());
            return repositorio.save(c);
        });
    }

    public void deleteById(Long id){
        Optional<Category> category = repositorio.findById(id);

        if (repositorio.findById(id) != null){

            List<POI> poi = poiRepository.AllCategoriesOfOnePOI(id);

            poi.forEach(
                    p -> {
                        p.setCategory(null);
                        poiRepository.save(p);
                    }
            );

            repositorio.deleteById(id);

        } else {

            throw new SingleEntityNotFoundException(id.toString(), Category.class);

        }    }

}
