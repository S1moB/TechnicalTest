package com.s1mob.testoffer.model;


import com.s1mob.testoffer.validators.annotations.AgeValidation;
import com.s1mob.testoffer.validators.annotations.CountryValidation;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "registered_user")
@Data
public class User {
    @Id
    @NotBlank(message = "UserName is mandatory")
    private String userName;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "birthday is mandatory")
    @AgeValidation
    private Date birthday;
    @NotBlank(message = "country is mandatory")
    @CountryValidation
    private String country;
    private String phoneNumber;
    private String gender;

}
