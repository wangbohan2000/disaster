package cn.wbhan.disaster.service;

import cn.wbhan.disaster.config.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class CookieService {

    @Autowired
    CustomConfig customConfig;

    public String findCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) return null;
        for (Cookie c : cookies
        ) {
            String k = c.getName();
            if (customConfig.getCookieKey().equals(k)) {
                return c.getValue();
            }
        }
        return null;
    }
}
