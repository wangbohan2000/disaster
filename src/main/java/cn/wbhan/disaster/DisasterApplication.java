package cn.wbhan.disaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("cn.wbhan.disaster.repository")
public class DisasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(DisasterApplication.class, args);
    }
}
