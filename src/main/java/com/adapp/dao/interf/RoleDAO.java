package com.adapp.dao.interf;

import com.adapp.dto.Role;

/**
 * Created by Dom on 29.06.2016.
 */
public interface RoleDAO {
    Role findByName(String roleName);
}
