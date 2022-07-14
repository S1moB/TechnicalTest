package com.s1mob.testoffer.validators;

import com.s1mob.testoffer.validators.annotations.CountryValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<CountryValidation, String>
{
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${data.user.country}")
    private String country;

    public boolean isValid(String countryValue, ConstraintValidatorContext cxt) {
        if(country == null) country = "France";
        if(countryValue != null) {
            boolean isCountryAccepted = country.equalsIgnoreCase(countryValue);
            if (!isCountryAccepted) log.error("Validation Error!! The user should be from " + country);
            return isCountryAccepted;
        }
        return false;
    }
}