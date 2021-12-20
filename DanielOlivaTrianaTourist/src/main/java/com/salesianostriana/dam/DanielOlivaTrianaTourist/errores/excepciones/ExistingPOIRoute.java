package com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones;

public class ExistingPOIRoute extends EntityNotFoundException {

    public ExistingPOIRoute(Class clazz) {
        super(String.format("No se pueden encontrar el POI del tipo %s ", clazz.getName()));
    }

}
