package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.services.RouteService;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniquePOI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePOIValidator implements ConstraintValidator<UniquePOI, POI> {

    @Autowired
    private Route route;

    @Autowired
    private RouteService routeService;

    @Override
    public void initialize(UniquePOI constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(POI poi, ConstraintValidatorContext constraintValidatorContext) {
        if (poi != null) {

            for ( Route r : routeService.findAll() ) {

                for ( POI p : r.getSteps() ) {

                    if (p.equals(poi)){

                        return false;

                    } else {

                        return true;

                    }

                }

            }

        }

        return false;

    }
}
