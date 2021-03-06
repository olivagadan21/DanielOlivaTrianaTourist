package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.RouteRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueNameRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
        return StringUtils.hasText(name) && !routeRepository.existsByName(name);
    }
}