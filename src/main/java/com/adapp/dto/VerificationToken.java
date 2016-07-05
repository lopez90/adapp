package com.adapp.dto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Dom on 05.07.2016.
 */
@Entity
@AttributeOverride(name="id", column= @Column(name="idToken"))
public class VerificationToken extends BaseEntity {
    private final static int EXPIRATION =  60 * 24;

    @Column(name="token")
    private String token;

    @Column(name="dateExpired")
    private Date dateExpire;

    @Column(name="verified")
    private boolean verified;

    @OneToOne(targetEntity = User.class,fetch=FetchType.EAGER)
    @JoinColumn(nullable=false,name="userId")
    private User user;

    public VerificationToken(){
    }

    public VerificationToken(String token, User user){
        this.token=token;
        this.user=user;
        this.dateExpire=calculateExpireDate(EXPIRATION);
        this.verified = false;
    }

    private Date calculateExpireDate(int expiryTimeInMinutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static int getEXPIRATION() {
        return EXPIRATION;
    }
}
