package cn.wbhan.disaster.service;

import cn.wbhan.disaster.config.CustomConfig;
import cn.wbhan.disaster.model.Role;
import cn.wbhan.disaster.model.User;
import cn.wbhan.disaster.repository.RoleRepository;
import cn.wbhan.disaster.repository.UserRepository;
import cn.wbhan.disaster.util.PassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class AccountService {

    @Resource
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CustomConfig customConfig;

    public boolean signOn(String username, String password, String password2, String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (!password.equals(password2) || role == null)
            return false;
        User user = new User(username, password, false, new Date(), role);
        userRepository.insert(user);
        return true;
    }

    /**
     * sign in
     *
     * @param username username
     * @param password password
     * @param response repassword
     * @return successful
     */
    public boolean signIn(String username, String password, HttpServletResponse response) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            return false;
        if (!password.equals(user.getPassword()))
            return false;
        Cookie cookie = new Cookie(customConfig.getCookieKey(), PassUtil.encode(username));
        response.addCookie(cookie);
        return true;
    }
}
