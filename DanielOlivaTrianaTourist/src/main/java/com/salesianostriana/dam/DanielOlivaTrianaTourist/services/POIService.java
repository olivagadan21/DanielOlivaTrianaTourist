package com.salesianostriana.dam.DanielOlivaTrianaTourist.services;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.pOI.CreatePOIDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.pOI.POIDtoConverter;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository repositorio;
    private final POIDtoConverter poiDtoConverter;


    public List<POI> findAll() {
        List<POI> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }


    public POI findById(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI save(CreatePOIDto poiDto) {
        POI poi = poiDtoConverter.createPOIDtoToPOI(poiDto);
        repositorio.save(poi);
        return poi;
    }

    public Optional<POI> edit(POI poi, Long id){

        if (repositorio.findById(id).isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        }
        return repositorio.findById(id).map(p -> {
            p.setName(poi.getName());
            p.setLocation(poi.getLocation());
            p.setDescription(poi.getDescription());
            p.setDate(poi.getDate());
            p.setCategory(poi.getCategory());
            p.setCoverPhoto(poi.getCoverPhoto());
            p.setPhoto2(poi.getPhoto2());
            p.setPhoto3(poi.getPhoto3());
            return repositorio.save(p);
        });
    }

    public void deleteById(Long id){

        if (repositorio.findById(id) != null) {

            repositorio.deleteById(id);

        } else {

            throw new SingleEntityNotFoundException(id.toString(), POI.class);

        }    }

}
