package com.adapp.dao.interf;

import com.adapp.common.IOperations;
import com.adapp.dto.VerificationToken;

/**
 * Created by Dom on 05.07.2016.
 */
public interface IVerificationTokenDAO extends IOperations<VerificationToken> {
    public VerificationToken findByTokenWithCriteria(String token);
}
