package cn.wbhan.disaster.controller;

import cn.wbhan.disaster.config.CustomConfig;
import cn.wbhan.disaster.model.User;
import cn.wbhan.disaster.model.dto.Result;
import cn.wbhan.disaster.repository.UserRepository;
import cn.wbhan.disaster.service.AccountService;
import cn.wbhan.disaster.service.CookieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountController {

    @Resource
    UserRepository userRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    CookieService cookieService;
    @Autowired
    CustomConfig customConfig;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/signOn")
    public String signOn(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam("repassword") String password2,
            @RequestParam("choose_identity") String roleName
    ) {
        boolean isSuccess = accountService.signOn(username, password, password2, roleName);
        if (isSuccess) return "wait-accept-page";
        return "account-page";
    }

    @PostMapping("/signIn")
    public String signIn(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        boolean isSuccess = accountService.signIn(username, password, response);
        if (isSuccess) return "redirect:/";
        return "account-page";
    }

    @GetMapping("/signOut")
    public String signOut(String un, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        String userOpt = cookieService.findCookie(request);
        if (userOpt == null) return "redirect:/";
        Cookie cookie = new Cookie(customConfig.getCookieKey(), "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    /**
     * check whether use exists.
     *
     * @param username username.
     * @return true or false.
     */
    @ResponseBody
    @GetMapping("/user_exists/{username}")
    public Result<Boolean> userExists(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        return user == null
                ? Result.success(200, "用户不存在", false)
                : Result.success(200, "用户已存在", true);
    }
}
