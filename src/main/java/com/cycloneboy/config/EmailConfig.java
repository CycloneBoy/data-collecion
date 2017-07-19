package com.cycloneboy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by CycloneBoy on 2017/7/18.
 */
@Component
public class EmailConfig {

    /**
     * 发件邮箱
     */
    //@Value("${spring.email.username}")
    private String emailFrom;

    public EmailConfig() {
    }

    public EmailConfig(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
}
