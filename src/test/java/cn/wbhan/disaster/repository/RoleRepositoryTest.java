package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RoleRepositoryTest {

    @Resource
    RoleRepository roleRepository;

    @Test
    void testInsert() {
        Role role = new Role("wbh", "王博函");
        roleRepository.insert(role);
        Assert.assertNotNull(roleRepository.findByName("wbh"));

        roleRepository.deleteById(role.getId());
    }

    @Test
    void testFindByName() {
        long actual = roleRepository.findByName("admin").getId();
        Assert.assertEquals(4, actual);
    }

    @Test
    void testFindById() {
        String actual = roleRepository.findById(4L).getName();
        Assert.assertEquals("admin", actual);
    }
}
