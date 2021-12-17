package com.salesianostriana.dam.DanielOlivaTrianaTourist.repos;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //boolean existsByNombre(String name);
}
