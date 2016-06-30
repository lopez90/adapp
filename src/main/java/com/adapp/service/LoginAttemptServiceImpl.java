package com.adapp.service;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dom on 27.06.2016.
 */
@Service
public class LoginAttemptServiceImpl {
    private final int MAX_ATTEMPT = 5;
    private LoadingCache<String, Integer> attemptsCache;

    public LoginAttemptServiceImpl() {
        super();
        attemptsCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Integer>() {
            @Override
            public Integer load(String key) throws Exception {
                return 0;
            }
        });
    }

    public void loginSucceeded(String key) {
        attemptsCache.invalidate(key);
    }

    public void loginFailed(String key) {
        int attemps = 0;

        try {
            attemps = attemptsCache.get(key);
        } catch (ExecutionException e) {
            attemps = 0;
            e.printStackTrace();
        }
        attemps++;
        attemptsCache.put(key, attemps);
    }

    public boolean isBlocked(String key) {
        try {
            return attemptsCache.get(key) >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }
}
