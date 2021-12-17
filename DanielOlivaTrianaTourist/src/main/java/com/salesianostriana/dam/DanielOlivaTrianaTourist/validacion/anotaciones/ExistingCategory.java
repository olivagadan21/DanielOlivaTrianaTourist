package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores.ExistingCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingCategoryValidator.class)
@Documented
public @interface ExistingCategory {

    String message() default "Las categoría introducida debe existir.";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
