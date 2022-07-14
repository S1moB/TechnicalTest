package com.s1mob.testoffer.service.impl;

import com.s1mob.testoffer.handlers.exceptions.ValidationException;
import com.s1mob.testoffer.model.Gender;
import com.s1mob.testoffer.model.User;
import com.s1mob.testoffer.repository.UserRepository;
import com.s1mob.testoffer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getRegisteredUser(String userName) {
        final User user = userRepository.findUserByUserName(userName);
        if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user with name "+ userName + " doesnt exist in the database");
        user.setGender(Gender.getGender(user.getGender()).toString());
        return user;
    }

    @Override
    public User saveUser(User userToAdd) throws Exception {
        final User user;
        try {
            user = userRepository.save(userToAdd);
        }catch (TransactionSystemException exception){
            throw new ValidationException("Error while persisting user data");
        }
        return user;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
