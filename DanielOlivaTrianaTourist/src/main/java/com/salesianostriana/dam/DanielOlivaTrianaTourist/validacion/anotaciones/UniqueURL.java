package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores.UniqueURLValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueURLValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueURL {

    String message() default "Las URL introducidas coinciden";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String url1();
    String url2();
    String url3();

}
