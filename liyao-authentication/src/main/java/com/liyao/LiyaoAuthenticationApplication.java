package com.liyao;

import com.github.pagehelper.PageHelper;

import com.liyao.common.base.MyBaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@EnableScheduling
@ComponentScan
@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableAutoConfiguration
public class LiyaoAuthenticationApplication {

    private final static Logger logger = LoggerFactory.getLogger(LiyaoAuthenticationApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(LiyaoAuthenticationApplication.class, args);
        logger.info("liyao-sso启动啦！");
        logger.error("liyao-sso启动啦！");
        logger.debug("liyao-sso启动啦！");
    }


    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper() {
        System.out.println("开始配置数据分页插件");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        //配置mysql数据库的方言
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    /**
     * 自定义通用mapper配置项
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperHelper() {
        Properties properties = new Properties();
        properties.setProperty("mappers", MyBaseMapper.class.getName());
        properties.setProperty("IDENTITY", "MYSQL"); // 数据库方言（主要用于：取回主键的方式）
        properties.setProperty("notEmpty", "false"); // insert和update中，是否判断字符串类型!=''，少数方法会用到
        properties.setProperty("style", Style.camelhump.name());
        MapperScannerConfigurer scan = new MapperScannerConfigurer();
        scan.setSqlSessionFactoryBeanName("sqlSessionFactory"); // 多数据源时，必须配置
        scan.setBasePackage("com.liyao.*.mapper");//mapper.java文件的路径
        scan.setMarkerInterface(MyBaseMapper.class); // 直接继承了MyBaseMapper接口的才会被扫描，basePackage可以配置的范围更大。
        scan.setProperties(properties);
        return scan;
    }

}
