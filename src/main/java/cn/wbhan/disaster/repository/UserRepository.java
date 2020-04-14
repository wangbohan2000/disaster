package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    void insert(User user);

    void deleteById(Long id);

    void update(User user);

    User findById(Long id);

    User findByUsername(String username);

    List<User> findAllDisabled(String offset, String limit, String order);

    void modifyUserEnable(Long id, Boolean enable);
}
