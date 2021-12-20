package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.POIRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.CategoryService;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category/")
@Validated
public class CategoryController {

    private final CategoryService servicio;
    private final POIService poiService;

    @GetMapping("")
    public List<Category> todos() {
        return servicio.findAll();
    }


    @GetMapping("{id}")
    public Category uno(@PathVariable @Min(value = 0, message = "No se pueden buscar categorias con un identificador negativo") Long id) {
        return servicio.findById(id);
    }

    @PutMapping("{id}")
    public Optional<Category> editar(@Valid @RequestBody Category category, @PathVariable @Min(value = 0, message = "No se pueden editar categorias con un identificador negativo") Long id){
        return servicio.edit(category, id);
    }

    @PostMapping("")
    public ResponseEntity<Category> crear(@Valid @RequestBody CreateCategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(categoryDto));
    }

    @DeleteMapping("{id}")
    public void borrarProducto(@PathVariable @Min(value = 0, message = "No se pueden eliminar categorias con un identificador negativo") Long id) {

        servicio.deleteById(id);

    }

}
