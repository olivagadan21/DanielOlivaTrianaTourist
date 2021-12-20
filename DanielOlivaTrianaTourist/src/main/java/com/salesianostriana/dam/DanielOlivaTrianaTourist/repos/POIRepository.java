package com.salesianostriana.dam.DanielOlivaTrianaTourist.repos;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface POIRepository extends JpaRepository<POI, Long> {
    /*
    @Query(value = """
            select p.name
            from POI p LEFT JOIN ROUTE ro
            where p.name IN (
            select p.name from ROUTEPOI
            """)

     */

}
