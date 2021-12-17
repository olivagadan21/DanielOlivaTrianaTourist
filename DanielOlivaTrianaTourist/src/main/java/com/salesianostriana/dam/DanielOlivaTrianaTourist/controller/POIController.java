package com.salesianostriana.dam.DanielOlivaTrianaTourist.controller;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreatePOIDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/POI/")
public class POIController {

    private final POIService servicio;

    /* @GetMapping("")
    public List<POI> todos() {
        return servicio.findAll();
    }

     */

    /* @GetMapping("{id}")
    public POI uno(@PathVariable Long id) {
        return servicio.findById(id);
    }

     */

    @PutMapping("{id}")
    public Optional<POI> editar(@RequestBody POI poi, @PathVariable Long id){
        return servicio.edit(poi, id);
    }

    @PostMapping("")
    public ResponseEntity<POI> crear(@Valid @RequestBody CreatePOIDto poiDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(poiDto));
    }

    @DeleteMapping("{id}")
    public void borrarProducto(@PathVariable Long id) {
        servicio.deleteById(id);
    }

}
