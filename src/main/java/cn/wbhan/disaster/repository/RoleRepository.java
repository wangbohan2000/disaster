package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {
    /**
     * insert a role.
     *
     * @param role role model.
     */
    void insert(Role role);

    /**
     * delete a role by its id.
     *
     * @param id role's id.
     */
    void deleteById(Long id);

    /**
     * update role by a new role model.
     *
     * @param role new role model.
     */
    void update(Role role);

    /**
     * find a role model by role English name.
     *
     * @param name the role's English name.
     * @return role model.
     */
    Role findByName(String name);

    /**
     * find a role model by role's id.
     *
     * @param id role's id.
     * @return a role model.
     */
    Role findById(Long id);
}
