package com.hongjiaoliu.lcn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * spring cloud configuration, auto load from spring cloud conf. Created by
 * whydk on 2/20/2017.
 */
@Component
public class ConfigProperties implements Serializable {

    private static final long serialVersionUID = 3158439972759918879L;

    @Value("${jdbc.driver}")
    protected String driver;

    @Value("${jdbc.url}")
    protected String url;

    @Value("${jdbc.username}")
    protected String username;

    @Value("${jdbc.password}")
    protected String password;

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }



}
