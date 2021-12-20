package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.RouteService;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniquePOI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePOIValidator implements ConstraintValidator<UniquePOI, Long> {

    @Autowired
    private Route route;

    @Override
    public void initialize(UniquePOI constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {

        if (id != null) {

            for (POI p : route.getSteps()) {

                return !p.getId().equals(id);

            }

        }

        return false;

    }
}
