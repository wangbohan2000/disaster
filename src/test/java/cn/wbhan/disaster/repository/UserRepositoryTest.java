package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.Role;
import cn.wbhan.disaster.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class UserRepositoryTest {

    @Resource
    UserRepository userRepository;
    @Resource
    RoleRepository roleRepository;

    @Test
    void testInsert() {
        Role admin = roleRepository.findByName("admin");
        userRepository.insert(new User("paul", "paul", true, new Date(), admin));
    }

    @Test
    void testDeleteById() {
        userRepository.deleteById(6L);
    }

    @Test
    void testUpdate() {
        User paul = userRepository.findByUsername("paul");
        paul.setPassword("zcn");
        userRepository.update(paul);
    }

    @Test
    void testFindById() {
        String actual = userRepository.findById(7L).getUsername();
        Assert.assertEquals("paul", actual);
    }
}
