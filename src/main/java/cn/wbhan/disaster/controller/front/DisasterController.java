package cn.wbhan.disaster.controller.front;

import cn.wbhan.disaster.model.Disaster;
import cn.wbhan.disaster.model.User;
import cn.wbhan.disaster.model.dto.Result;
import cn.wbhan.disaster.model.vo.DisasterLogisticVo;
import cn.wbhan.disaster.repository.DisasterRepository;
import cn.wbhan.disaster.repository.UserRepository;
import cn.wbhan.disaster.repository.vo.DisasterLogisticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/front")
public class DisasterController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    UserRepository userRepository;
    @Resource
    DisasterRepository disasterRepository;
    @Resource
    DisasterLogisticRepository disasterLogisticRepository;

//    @ResponseBody
//    @GetMapping("/disaster/{un}")
//    public List<Disaster> getAllDisasterByUser(
//            String order,
//            String offset,
//            String limit,
//            @PathVariable String un
//    ) {
//        return disasterRepository.findAllByUsername(order, offset, limit, un);
//    }

    @ResponseBody
    @GetMapping("/disaster/{un}")
    public List<DisasterLogisticVo> getAllDisasterByUser(
            @RequestParam String order,
            @RequestParam String offset,
            @RequestParam String limit,
            @PathVariable String un
    ) {
        System.err.println(offset + "," + limit + "," + un);
        return disasterLogisticRepository.findAllDLByUsername(offset, limit, un);
    }

    @PostMapping("/disaster")
    public String uploadDisaster(
            @RequestParam("current_user") String providerName,
            @RequestParam("disaster_name") String title,
            @RequestParam("create_time") String createDate,
            @RequestParam("disaster_details") String details,
            @RequestParam("expect_goods") String expectGoodsName,
            @RequestParam("expect_cnt") String expectGoodsCnt,
            @RequestParam("expect_unit") String expectGoodsUnit
    ) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            Date date = dateFormat.parse(createDate);
            User user = userRepository.findByUsername(providerName);
            Disaster disaster = new Disaster(title, details, date, user, expectGoodsName, Double.parseDouble(expectGoodsCnt), expectGoodsUnit);
            disasterRepository.insert(disaster);
        } catch (ParseException e) {
            logger.error("格式化日期失败");
            return "redirect:/error-500";
        }
        return "redirect:/front/selfDisasterList";
    }

    @DeleteMapping("/disaster/{id}")
    @ResponseBody
    public Result<Boolean> deleteDisaster(@PathVariable Long id) {
        try {
            disasterRepository.deleteById(id);
        } catch (Exception e) {
            return Result.fail(500, "删除失败");
        }
        return Result.success(200, "删除成功", true);
    }
}
