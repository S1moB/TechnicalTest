package com.s1mob.testoffer.validators.annotations;

import com.s1mob.testoffer.validators.CountryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target( FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CountryValidator.class)
public @interface CountryValidation {
    String message() default "Invalid country: user should be from France";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}