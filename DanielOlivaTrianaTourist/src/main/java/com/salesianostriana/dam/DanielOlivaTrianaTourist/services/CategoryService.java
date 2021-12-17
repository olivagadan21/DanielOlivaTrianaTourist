package com.salesianostriana.dam.DanielOlivaTrianaTourist.services;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreatePOIDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repositorio;


    /* public List<Category> findAll() {
        List<Category> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return result;
        }
    }

     */


    /* public Category findById(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }
     */


    public Category save(CreateCategoryDto categoryDto) {
        return repositorio.save(Category.builder()
                .name(categoryDto.getName())
                .build());
    }

    public Optional<Category> edit(Category category, Long id){
        return repositorio.findById(id).map(c -> {
            c.setName(category.getName());
            return repositorio.save(c);
        });
    }

    public void deleteById(Long id){
        repositorio.deleteById(id);
    }

}
