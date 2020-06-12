package cn.wbhan.disaster.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("disaster")
@Configuration
public class CustomConfig {
    private String cookieKey;
    private String passwordCharset;

    public CustomConfig() {
    }

    public CustomConfig(String cookieKey, String passwordCharset) {
        this.cookieKey = cookieKey;
        this.passwordCharset = passwordCharset;
    }

    public String getCookieKey() {
        return cookieKey;
    }

    public void setCookieKey(String cookieKey) {
        this.cookieKey = cookieKey;
    }

    public String getPasswordCharset() {
        return passwordCharset;
    }

    public void setPasswordCharset(String passwordCharset) {
        this.passwordCharset = passwordCharset;
    }
}
