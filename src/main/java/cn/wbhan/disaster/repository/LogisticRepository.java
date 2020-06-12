package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.Logistic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface LogisticRepository {
    void insert(Logistic logistic);

    void deleteById(Long id);

    void update(Logistic logistic);

    Logistic findById(Long id);

    List<Logistic> findAll(String order, String offset, String limit);

    void updateStatus(int id, String status);
}
