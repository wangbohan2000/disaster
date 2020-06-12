package cn.wbhan.disaster.controller.admin;

import cn.wbhan.disaster.model.User;
import cn.wbhan.disaster.model.dto.Result;
import cn.wbhan.disaster.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserManageController {

    @Resource
    UserRepository userRepository;

    @GetMapping("/disabled_users")
    public List<User> disableUsers(String limit, String offset, String order) {
        return userRepository.findAllDisabled(offset, limit, order);
    }

    @PostMapping("/accept_user_sign_on")
    public Result<Boolean> modifyUserEnable(Long uid, Boolean agree) {
        try {
            if (agree) {
                userRepository.modifyUserEnable(uid, true);
            } else {
                userRepository.deleteById(uid);
            }
        } catch (Exception e) {
            return Result.fail(500, "服务器错误");
        }
        return Result.success(200, "成功修改", null);
    }
}
