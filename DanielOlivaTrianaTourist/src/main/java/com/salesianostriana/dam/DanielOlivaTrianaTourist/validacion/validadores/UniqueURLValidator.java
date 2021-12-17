package com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.validadores;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueURL;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueURLValidator implements ConstraintValidator<UniqueURL, Object> {

    private String url1;
    private String url2;
    private String url3;

    @Override
    public void initialize(UniqueURL constraintAnnotation) {

        url1 = constraintAnnotation.url1();
        url2 = constraintAnnotation.url2();
        url3 = constraintAnnotation.url3();


    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        String coverPhoto = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(url1);
        String photo2 = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(url2);
        String photo3 = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(url3);

        if ((photo2 == null || photo2 == null) || (photo2 == null && photo2 ==null)) {
            return true;
        } else {

            if (coverPhoto!=photo2 && coverPhoto != photo3 && photo2!=photo3){
                return true;
            }

            return false;

        }

    }
}
