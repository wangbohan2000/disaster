package cn.wbhan.disaster.service;

import cn.wbhan.disaster.repository.LogisticRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class LogisticService {
    @Resource
    LogisticRepository logisticRepository;

    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(int id, String status) {
        logisticRepository.updateStatus(id, status);
    }
}
