package cn.wbhan.disaster.controller;

import cn.wbhan.disaster.config.CustomConfig;
import cn.wbhan.disaster.model.User;
import cn.wbhan.disaster.repository.UserRepository;
import cn.wbhan.disaster.service.CookieService;
import cn.wbhan.disaster.util.PassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    CustomConfig customConfig;
    @Resource
    UserRepository userRepository;
    @Autowired
    CookieService cookieService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String main(HttpServletRequest request) {
        // 检测cookie是否存在
        Cookie[] cookies = request.getCookies();
        String userOpt = cookieService.findCookie(request);
        if (userOpt == null) return "account-page";
        User user = userRepository.findByUsername(PassUtil.decode(userOpt));
        request.getSession().setAttribute("user", user);
        logger.info(user.toString());
        return "main-page";
    }
}
