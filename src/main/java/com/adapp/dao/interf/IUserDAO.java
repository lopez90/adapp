package com.adapp.dao.interf;

import com.adapp.dto.User;

/**
 * Created by Dom on 22.06.2016.
 */
public interface IUserDAO {

     User register(String username, String password);
}
