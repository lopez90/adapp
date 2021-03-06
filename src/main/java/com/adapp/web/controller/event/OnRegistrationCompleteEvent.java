package com.adapp.web.controller.event;

import com.adapp.dto.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Created by Dom on 05.07.2016.
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private final String appUrl;
    private final Locale locale;
    private final User user;
    private boolean invoked;

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }

    public boolean isInvoked() {
        return invoked;
    }

    public void setInvoked(boolean invoked) {
        this.invoked = invoked;
    }
}