package com.salesianostriana.dam.DanielOlivaTrianaTourist.services;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreatePOIDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository repositorio;


    /* public List<POI> findAll() {
        List<POI> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }

     */


    /* public POI findById(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }
     */


    public POI save(CreatePOIDto poiDto) {
        return repositorio.save(POI.builder()
                .name(poiDto.getName())
                .location(poiDto.getLocation())
                .description(poiDto.getDescription())
                .date(poiDto.getDate())
                .category(poiDto.getCategory())
                .coverPhoto(poiDto.getCoverPhoto())
                .photo2(poiDto.getPhoto2())
                .photo3(poiDto.getPhoto3())
                .build());
    }

    public Optional<POI> edit(POI poi, Long id){
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
        repositorio.deleteById(id);
    }

}
