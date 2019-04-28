package com.liyao.authentication.deferredresult;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 初始化一个容器，系统启动后要做的事情
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ChengGeQueue chengGeQueue;

    @Autowired
    private DeferredResultHodler deferredResultHodler;

    private Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //无限循环
        new Thread(()->{
            /**
             * 监听这个消息队列是否有值
             */
            while (true) {
                if (StringUtils.isNotBlank(chengGeQueue.getCompleteOrder())) {
                    String completeOrder = chengGeQueue.getCompleteOrder();
                    logger.info("返回订单处理结果："+completeOrder);
                    //在调用这个setResult的时候就意味着这个异步请求就完成了需要给前台返回结果啦
                    deferredResultHodler.getMap().get(completeOrder).setResult("成哥最帅");
                    chengGeQueue.setCompleteOrder(null);
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
