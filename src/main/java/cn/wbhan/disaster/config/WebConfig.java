package cn.wbhan.disaster.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements ErrorPageRegistrar, WebMvcConfigurer {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage ep404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-404");
        ErrorPage ep403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error-403");
        ErrorPage ep500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-500");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/userList").setViewName("admin/user-list-page");

        registry.addViewController("/provider/uploadGoods").setViewName("provider/upload-goods-page");
        registry.addViewController("/provider/selfGoodsList").setViewName("provider/self-goods-list-page");

        registry.addViewController("/front/uploadDisaster").setViewName("front/upload-disaster-page");
        registry.addViewController("/front/selfDisasterList").setViewName("front/self-disaster-list-page");

        registry.addViewController("/pub/goodsList").setViewName("pub/goods-list-page");

        registry.addViewController("/manager/approveDisaster").setViewName("manager/approve-disaster-page");
        registry.addViewController("/manager/approveList").setViewName("manager/approve-list-page");
    }
}
