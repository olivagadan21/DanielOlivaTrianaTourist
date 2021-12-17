package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreatePOIDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category/")
public class CategoryController {

    private final CategoryService servicio;

    /* @GetMapping("")
    public List<Category> todos() {
        return servicio.findAll();
    }

     */

    /* @GetMapping("{id}")
    public Category uno(@PathVariable Long id) {
        return servicio.findById(id);
    }

     */

    @PutMapping("{id}")
    public Optional<Category> editar(@RequestBody Category category, @PathVariable Long id){
        return servicio.edit(category, id);
    }

    @PostMapping("")
    public ResponseEntity<Category> crear(@Valid @RequestBody CreateCategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(categoryDto));
    }

    @DeleteMapping("{id}")
    public void borrarProducto(@PathVariable Long id) {
        servicio.deleteById(id);
    }

}
