package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores.UniquePOIValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePOIValidator.class)
@Documented
public @interface UniquePOI {

    String message() default "El POI que intenta añadir ya está en otra ruta.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
