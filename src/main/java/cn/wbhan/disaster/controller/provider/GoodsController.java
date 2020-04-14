package cn.wbhan.disaster.controller.provider;

import cn.wbhan.disaster.model.Goods;
import cn.wbhan.disaster.model.User;
import cn.wbhan.disaster.repository.GoodsRepository;
import cn.wbhan.disaster.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/provider")
public class GoodsController {

    @Resource
    GoodsRepository goodsRepository;
    @Resource
    UserRepository userRepository;

    @ResponseBody
    @GetMapping("/goods")
    public List<Goods> getAllGoods(
            @RequestParam String order,
            @RequestParam String limit,
            @RequestParam String offset) {
        return goodsRepository.findAll(order, offset, limit);
    }

    @ResponseBody
    @GetMapping("/goods/{un}")
    public List<Goods> getAllGoods(
            @RequestParam String order,
            @RequestParam String limit,
            @RequestParam String offset,
            @PathVariable String un) {
        return goodsRepository.findAllByUsername(order, offset, limit, un);
    }

    @PostMapping("/goods")
    public String uploadGoods(
            @RequestParam("current_user") String username,
            @RequestParam("goods_name") String goodsName,
            @RequestParam("goods_mount") Double cnt,
            @RequestParam("goods_unit") String unit,
            @RequestParam("create_time") String createDate
    ) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(createDate);
            User provider = userRepository.findByUsername(username);
            Goods goods = new Goods(goodsName, cnt, unit, date, provider);
            goodsRepository.insert(goods);
        } catch (ParseException e) {
            System.err.println("parsing date exception...");
        }
        return "redirect:/public/goodsList";
    }
}

