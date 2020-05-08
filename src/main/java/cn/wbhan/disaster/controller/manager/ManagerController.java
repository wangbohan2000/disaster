package cn.wbhan.disaster.controller.manager;

import cn.wbhan.disaster.model.Disaster;
import cn.wbhan.disaster.model.Goods;
import cn.wbhan.disaster.model.Logistic;
import cn.wbhan.disaster.model.dto.Result;
import cn.wbhan.disaster.repository.DisasterRepository;
import cn.wbhan.disaster.repository.GoodsRepository;
import cn.wbhan.disaster.repository.LogisticRepository;
import cn.wbhan.disaster.service.DisasterLogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    DisasterRepository disasterRepository;
    @Resource
    LogisticRepository logisticRepository;
    @Resource
    GoodsRepository goodsRepository;
    @Autowired
    DisasterLogisticsService logisticsService;

    @GetMapping("/disaster_not_approve")
    @ResponseBody
    public List<Disaster> findAllDisasterNotApprove(
            String order,
            String offset,
            String limit
    ) {
        return disasterRepository.findAllByPass(order, offset, limit, "暂未审批");
    }

    @GetMapping("/disaster_approved")
    @ResponseBody
    public List<Disaster> findAllDisasterApprove(String order, String offset, String limit) {
        return disasterRepository.findAllApproved(order, offset, limit);
    }

    @PostMapping("/approve")
    @ResponseBody
    public Result<Logistic> approve(
            @RequestParam("manager_name") String managerName,
            @RequestParam("dest_name") String destName,
            @RequestParam("disaster_id") Long disasterID,
            @RequestParam("expect_goods_name") String expectGoodsName,
            @RequestParam("expect_goods_cnt") Double expectGoodsCnt
    ) {
        Goods goods = goodsRepository.findByName(expectGoodsName);
        if (goods == null || goods.getCnt() < expectGoodsCnt)
            return Result.fail(400, "需要的商品暂时缺货哦!");
        Logistic logistic = logisticsService.makeLogistic(managerName, destName, disasterID, expectGoodsName, expectGoodsCnt);
        return Result.success(200, "调度成功！", logistic);
    }

    @PostMapping("/unApprove")
    @ResponseBody
    public Result<Boolean> unApprove(
            @RequestParam("disaster_id") Long disasterID
    ) {
        disasterRepository.updateStatus(disasterID, "审批未通过");
        return Result.success(200, "操作成功", true);
    }

    @GetMapping("/logistic")
    @ResponseBody
    public List<Logistic> logistics(String order, String offset, String limit) {
        return logisticRepository.findAll(order, offset, limit);
    }

    @PostMapping("/logistic/change_logistic_status")
    @ResponseBody
    public Result<Boolean> changeLogisticStatus(@RequestParam Integer id,
                                                @RequestParam String status) {
        // TODO: 2020/4/24 更改物流状态
        System.err.println(id);
        System.err.println(status);
        logisticRepository.updateStatus(id, status);
        return Result.success(200, "更改成功", true);
    }
}