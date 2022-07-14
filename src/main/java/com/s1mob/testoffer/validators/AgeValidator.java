package com.s1mob.testoffer.validators;

import com.s1mob.testoffer.validators.annotations.AgeValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class AgeValidator implements ConstraintValidator<AgeValidation, Date>
{
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${date.user.adult-min-age}")
    private String minAge;


    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if(minAge==null) minAge="18";
        if(date != null) {
            final int age = Period.between(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
            boolean isUserAdult = age >= Integer.parseInt(minAge);
            if (!isUserAdult) log.error("validation error!! the user is not an adult");
            return isUserAdult;
        }
        return false;
    }

}