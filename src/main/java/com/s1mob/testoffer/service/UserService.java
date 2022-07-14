package com.s1mob.testoffer.service;

import com.s1mob.testoffer.model.User;

public interface UserService {
    User getRegisteredUser(final String userName);
    User saveUser(final User userToAdd) throws Exception;
}
