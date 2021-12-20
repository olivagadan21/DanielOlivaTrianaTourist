package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.route.CreateRouteDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.ExistingPOIRoute;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.POIRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.POIService;
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
    private final POIService poiService;

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
    public void borrarRoute(@PathVariable @Min(value = 0, message = "No se pueden eliminar rutas con un identificador negativo") Long id) {
        if (servicio.findById(id) != null){
            servicio.deleteById(id);
        } else {
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        }
    }

    @PostMapping("{id1}/POI/{id2}")
    public Route addPoiToRoute (@PathVariable Long id1, @PathVariable Long id2) {

        return servicio.addPoiToRoute(id1, id2);

    }

    @DeleteMapping("{id1}/POI/{id2}")
    public void removePoiToRoute (@PathVariable Long id1, @PathVariable Long id2) {

        if (servicio.findById(id1) != null && poiService.findById(id2) != null){
            servicio.removePoiToRoute(id1, id2);
        } else {

            if (servicio.findById(id1) == null){
                throw new SingleEntityNotFoundException(id1.toString(), Route.class);
            }

            if (poiService.findById(id2) == null) {
                throw new SingleEntityNotFoundException(id2.toString(), POI.class);
            }

        }

    }

}
