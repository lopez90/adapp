package com.adapp.dao.interf;

import com.adapp.dto.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Dom on 29.06.2016.
 */
public interface IRoleDAO  {
    Role findByName(String roleName);
}
