package com.liyao.backend.sms.scheduler;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.liyao.common.util.HttpClientUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class WeatherScheduler {
    /**
     * 短信应用 SDK AppID
     */
    @Value("sms.appid")
    private Integer appId;
    /**
     * 短信应用 SDK AppKey
     */
    @Value("sms.appkey")
    private String appKey;
    /**
     * 需要发送短信的手机号码
     */
    @Value("#{'${sms.phoneNumbers}'.split(',')}")
    private String[] phoneNumbers;
    /**
     * 短信模板 ID，需要在短信应用中申请
     */
    @Value("sms.templateId")
    private Integer templateId;
    /**
     * 签名内容
     */
    @Value("sms.smsSign")
    private String smsSign;

    /**
     * 每日爱言链接
     */
    @Value("sms.loveWordUrl")
    private String loveWordUrl;

    /**
     * 添加定时任务
     */
    @Scheduled(cron = "0 16 23 ? * *")
    public void sendWeatherSms() {
        try {
            String loveWord = HttpClientUtils.httpGet(loveWordUrl);
            if (StringUtils.isNotEmpty(loveWord)) {
                if (loveWord.indexOf("document.write") >= 0) {
                    loveWord = loveWord.substring(loveWord.indexOf("\"") + 1, loveWord.lastIndexOf("\""));
                }
            } else {
                loveWord = "我爱你！";
            }
            //相爱开始时间
            LocalDate loveBeginDate = LocalDate.of(2013, 04, 23);
            Period p = Period.between(loveBeginDate, LocalDate.now());
            String loveDate = String.format("%s年%s月%s天", p.getYears(), p.getMonths(), p.getDays());
            //天气情况处理


            String[] params = {loveDate, "天气晴", loveWord};
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
        }
    }

}
