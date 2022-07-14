package com.s1mob.testoffer.model;

import java.util.Arrays;

public enum Gender {
    male("male"), female("female"), other("other");

    String genderValue;
    Gender(String value) {
        genderValue = value;
    }

    public static Gender getGender(String gender) {
        return Arrays.stream(Gender.values()).filter(aEnum -> aEnum.genderValue.equals(gender)).findFirst().orElse(Gender.other);
    }



    @Override
    public String toString() {
        return genderValue;
    }
}