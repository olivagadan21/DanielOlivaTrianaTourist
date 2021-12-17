package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.route.CreateRouteDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.RouteService;
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
@RequestMapping("/route/")
@Validated
public class RouteController {

    private final RouteService servicio;

    @GetMapping("")
    public List<Route> todos() {
        return servicio.findAll();
    }

    @GetMapping("{id}")
    public Route uno(@PathVariable @Min(value = 0, message = "No se pueden buscar rutas con un identificador negativo") Long id) {
        return servicio.findById(id);
    }

    @PutMapping("{id}")
    public Optional<Route> editar(@Valid @RequestBody Route route, @PathVariable @Min(value = 0, message = "No se pueden editar rutas con un identificador negativo") Long id){
        return servicio.edit(route, id);
    }

    @PostMapping("")
    public ResponseEntity<Route> crear(@Valid @RequestBody CreateRouteDto routeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(routeDto));
    }

    @DeleteMapping("{id}")
    public void borrarProducto(@PathVariable @Min(value = 0, message = "No se pueden eliminar rutas con un identificador negativo") Long id) {
        servicio.deleteById(id);
    }

}
