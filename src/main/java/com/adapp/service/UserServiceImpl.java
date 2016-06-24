package com.adapp.service;

import com.adapp.dao.UserDAO;
import com.adapp.service.abstr.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dom on 22.06.2016.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<UserDAO>{

}
