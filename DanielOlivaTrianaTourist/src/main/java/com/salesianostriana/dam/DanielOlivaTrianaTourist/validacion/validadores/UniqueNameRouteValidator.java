package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.RouteRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueNameRoute;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameRouteValidator implements ConstraintValidator<UniqueNameRoute, String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(UniqueNameRoute constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (routeRepository.existsByName(name) || name == null) {
            return false;
        } else {
            return true;
        }
    }
}