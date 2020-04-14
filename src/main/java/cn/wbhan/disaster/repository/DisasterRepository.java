package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.Disaster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DisasterRepository {
    void insert(Disaster disaster);

    void deleteById(Long id);

    void update(Disaster disaster);

    void updateStatus(Long id, String status);

    Disaster findById(Long id);

    List<Disaster> findAll(String order, String offset, String limit);

    List<Disaster> findAllByUsername(String order, String offset, String limit, String username);

    List<Disaster> findAllByPass(String order, String offset, String limit, String pass);

    List<Disaster> findAllApproved(String order, String offset, String limit);
}
