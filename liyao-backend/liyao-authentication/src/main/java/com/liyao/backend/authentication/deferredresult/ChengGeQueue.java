package com.liyao.backend.authentication.deferredresult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟队列的类
 */
@Component
public class ChengGeQueue {

    private Logger logger = LoggerFactory.getLogger(ChengGeQueue.class);


    //下单字段
    private String placeOrder;
    //订单完成字段
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    /**
     * 收到下单请求后，睡一秒，然后让其完成下单的字段赋值
     * @param placeOrder
     * @throws InterruptedException
     */
    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(()->{
            //模拟一下下单请求并完成的操作
            logger.info("接到下单请求");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //这里让下单的订单直接给订单完成赋值，代表着订单完成。
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完成："+placeOrder);
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
