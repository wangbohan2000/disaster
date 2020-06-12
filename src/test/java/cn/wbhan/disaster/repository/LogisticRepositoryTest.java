package cn.wbhan.disaster.repository;

import cn.wbhan.disaster.service.LogisticService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class LogisticRepositoryTest {
    @Resource
    LogisticService logisticService;
}
