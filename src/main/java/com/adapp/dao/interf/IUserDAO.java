package com.adapp.dao.interf;

import com.adapp.common.IOperations;
import com.adapp.dto.User;

/**
 * Created by Dom on 22.06.2016.
 */
public interface IUserDAO extends IOperations<User> {

    public User findByMail(String email);

    User findByMailWithCriteria(String email);
}
