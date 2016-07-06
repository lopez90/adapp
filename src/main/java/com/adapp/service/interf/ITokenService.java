package com.adapp.service.interf;

import com.adapp.common.IOperations;
import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;

/**
 * Created by Dom on 06.07.2016.
 */
public interface ITokenService extends IOperations<VerificationToken> {

    void createVerificationToken(User user, String token);
    VerificationToken getVerificationToken(String token);
}
