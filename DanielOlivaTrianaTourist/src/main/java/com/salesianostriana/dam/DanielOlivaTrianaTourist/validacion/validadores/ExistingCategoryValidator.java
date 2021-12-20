package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.ExistingCategory;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueURL;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistingCategoryValidator implements ConstraintValidator<ExistingCategory, Long> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void initialize(ExistingCategory constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long categoria, ConstraintValidatorContext context) {

        return categoryRepository.existsById(categoria) && categoria!=null;

    }
}
