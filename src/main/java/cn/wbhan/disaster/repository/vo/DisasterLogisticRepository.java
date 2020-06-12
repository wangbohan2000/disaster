package cn.wbhan.disaster.repository.vo;

import cn.wbhan.disaster.model.vo.DisasterLogisticVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DisasterLogisticRepository {
    List<DisasterLogisticVo> findAllDLByUsername(String offset, String limit, String un);
}
