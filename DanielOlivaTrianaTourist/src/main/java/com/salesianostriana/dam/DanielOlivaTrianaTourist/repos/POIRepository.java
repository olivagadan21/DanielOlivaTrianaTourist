package com.salesianostriana.dam.DanielOlivaTrianaTourist.repos;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {

    @Query(value = """
            select *
            from POI
            where category = :id 
            """, nativeQuery = true)
    List<POI> AllCategoriesOfOnePOI(@Param("id") Long id);

}
