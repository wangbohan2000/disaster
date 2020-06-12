package cn.wbhan.disaster.service;

import cn.wbhan.disaster.model.Disaster;
import cn.wbhan.disaster.model.Goods;
import cn.wbhan.disaster.model.Logistic;
import cn.wbhan.disaster.repository.DisasterRepository;
import cn.wbhan.disaster.repository.GoodsRepository;
import cn.wbhan.disaster.repository.LogisticRepository;
import cn.wbhan.disaster.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;

@Service
public class DisasterLogisticsService {

    @Resource
    DisasterRepository disasterRepository;
    @Resource
    UserRepository userRepository;
    @Resource
    GoodsRepository goodsRepository;
    @Resource
    LogisticRepository logisticRepository;

    @Transactional
    public Logistic makeLogistic(String manager, String destName, Long did, String expectGoodsName, Double expectGoodsCnt) {
        // 改变disaster状态
        disasterRepository.updateStatus(did, "审批通过");
        Disaster disaster = disasterRepository.findById(did);


        // 减去库存
        Goods goods = goodsRepository.findByName(expectGoodsName);
        goods.setCnt(goods.getCnt() - expectGoodsCnt);
        goodsRepository.update(goods);

        // 生成物流信息
        Instant now = Instant.now();
        goods.setCnt(expectGoodsCnt);
        Logistic logistic = new Logistic(
                userRepository.findByUsername(manager),
                userRepository.findByUsername(destName),
                "未发货",
                Date.from(now),
                goods,
                disaster);
        logisticRepository.insert(logistic);
        return logistic;
    }

}
