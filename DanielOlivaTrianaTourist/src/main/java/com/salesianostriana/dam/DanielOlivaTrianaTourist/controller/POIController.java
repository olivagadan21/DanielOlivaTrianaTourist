package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.pOI.CreatePOIDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
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
@RequestMapping("/POI/")
@Validated
public class POIController {

    private final POIService servicio;

    @GetMapping("")
    public List<POI> todos() {
        return servicio.findAll();
    }

    @GetMapping("{id}")
    public POI uno(@PathVariable @Min(value = 0, message = "No se pueden buscar POI con un identificador negativo") Long id) {
        return servicio.findById(id);
    }

    @PutMapping("{id}")
    public Optional<POI> editar(@Valid @RequestBody POI poi, @PathVariable @Min(value = 0, message = "No se pueden editar POI con un identificador negativo") Long id){
        return servicio.edit(poi, id);
    }

    @PostMapping("")
    public ResponseEntity<POI> crear(@Valid @RequestBody CreatePOIDto poiDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(poiDto));
    }

    @DeleteMapping("{id}")
    public void borrarProducto(@PathVariable @Min(value = 0, message = "No se pueden eliminar POI con un identificador negativo") Long id) {

        if (servicio.findById(id) != null) {

            servicio.deleteById(id);

        } else {

            throw new SingleEntityNotFoundException(id.toString(), Route.class);

        }

    }

}
