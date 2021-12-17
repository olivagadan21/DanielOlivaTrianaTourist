package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreateRouteDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.CategoryService;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route/")
public class RouteController {

    private final RouteService servicio;

    /* @GetMapping("")
    public List<Route> todos() {
        return servicio.findAll();
    }

     */

    /* @GetMapping("{id}")
    public Route uno(@PathVariable Long id) {
        return servicio.findById(id);
    }

     */

    @PutMapping("{id}")
    public Optional<Route> editar(@RequestBody Route route, @PathVariable Long id){
        return servicio.edit(route, id);
    }

    @PostMapping("")
    public ResponseEntity<Route> crear(@Valid @RequestBody CreateRouteDto routeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(routeDto));
    }

    @DeleteMapping("{id}")
    public void borrarProducto(@PathVariable Long id) {
        servicio.deleteById(id);
    }

}
