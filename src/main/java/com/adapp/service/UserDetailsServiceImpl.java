package com.adapp.service;

/**
 * Created by Dom on 27.06.2016.
 */

import com.adapp.dao.UserDAO;
import com.adapp.dto.Privilege;
import com.adapp.dto.User;
import com.adapp.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrzej Olkiewicz on 2015-11-04.
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    HttpServletRequest request;

    @Autowired
    LoginAttemptServiceImpl loginAttemptService;

    @Autowired
    UserDAO userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String ip = request.getRemoteAddr();

        if(loginAttemptService.isBlocked(ip)) {
            LOGGER.error("IP BLOCKED ERROR");
            throw new RuntimeException("Address Blocked");
        }

        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                LOGGER.error("USER ERROR");
                return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true, getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
            }

            LOGGER.error("OK OK OK !!!!");
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }

    //

    public final Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private final List<String> getPrivileges(Collection<Role> roles) {
        final List<String> privileges = new ArrayList<>();
        final List<Privilege> list = new ArrayList<>();

        for(final Role role: roles) {
            list.addAll(role.getPrivileges());
        }

        for(final Privilege privilege: list) {
            privileges.add(privilege.getName());
        }
        return privileges;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();

        for(final String privilege: privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }

        return authorities;
    }
}