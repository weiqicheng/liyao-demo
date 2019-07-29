package com.liyao;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.liyao.common.util.HttpClientUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

/**
 * 消息服务
 *
 */
@EnableScheduling
@ComponentScan
//@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker//对hystrix熔断机制的支持，使用hystrix监控仪表盘时也需要此注解
public class LiyaoSMSApplication {

    /**
     * 短信应用 SDK AppID
     */
    private static Integer appId=1400235586;
    /**
     * 短信应用 SDK AppKey
     */
    private static String appKey="9bfedaad1eec0195ee0ea36b9cde8ff5";
    /**
     * 需要发送短信的手机号码
     */
    private static String[] phoneNumbers={"15011575211"};
    /**
     * 短信模板 ID，需要在短信应用中申请
     */
    private static Integer templateId=383031;
    /**
     * 签名内容
     */
    private static String smsSign="weimaomao211";

    private static Logger logger = LoggerFactory.getLogger(LiyaoSMSApplication.class);
    public static void main(String[] args) {
//        SpringApplication.run(LiyaoSMSApplication.class, args);
        String loveWord = HttpClientUtils.httpGet("http://guozhivip.com/nav/api/api.php");
        System.out.println(loveWord.substring(loveWord.indexOf("\"")+1,loveWord.lastIndexOf("\"")));

      /*  try {
            String[] params = {"1","天气晴","爱你哦"};
            SmsMultiSender msender = new SmsMultiSender(appId, appKey);
            // 签名参数未提供或者为空时，会使用默认签名发送短信
            SmsMultiSenderResult result = msender.sendWithParam("86", phoneNumbers, templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }*/

    }

}