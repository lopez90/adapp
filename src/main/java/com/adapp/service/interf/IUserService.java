package com.adapp.service.interf;

import com.adapp.dao.UserDAO;
import com.adapp.dto.User;

/**
 * Created by Dom on 22.06.2016.
 */
public interface IUserService {
    void registerService(String username, String password);
}
