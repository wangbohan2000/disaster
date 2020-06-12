package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsRepository {
    void insert(Goods goods);

    void deleteById(Long id);

    void update(Goods goods);

    Goods findByName(String name);

    Goods findById(Long id);

    List<Goods> findAll(String order, String offset, String limit);

    List<Goods> findAllByUsername(String order, String offset, String limit, String username);
}
