package com.adapp.service.interf;


import com.adapp.common.IOperations;
import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;

/**
 * Created by Dom on 22.06.2016.
 */
public interface IUserService extends IOperations<User> {
     void register(User user);
     void createVerificationToken(User user, String token);
     VerificationToken getVerificationToken(String token);

}
