package com.adapp.service.interf;


import com.adapp.common.IOperations;
import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;

/**
 * Created by Dom on 22.06.2016.
 */
public interface IUserService extends IOperations<User> {
     User register(User user);
}
