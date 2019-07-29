package com.liyao.backend.authentication.deferredresult;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

//    @RequestMapping("/getInfo")
//    public String getInfo() throws InterruptedException {
//        logger.info("主线程调用开始");
//        Thread.sleep(1000);
//        logger.info("主线程调用结束");
//        return "成哥最帅";
//    }


//    @RequestMapping("/getInfo")
//    public Callable<String> getInfo() throws InterruptedException {
//        logger.info("主线程调用开始");
//        Thread.sleep(1000);
//        Callable<String> result=new Callable<String>(){
//            @Override
//            public String call() throws Exception {
//                logger.info("副线程开始");
//                Thread.sleep(1000);
//                logger.info("副线程结束");
//                return "成哥最帅";
//            }
//        };
//        logger.info("主线程调用结束");
//        return result;
//    }

    @Autowired
    private ChengGeQueue chengGeQueue;

    @Autowired
    private DeferredResultHodler deferredResultHodler;
    /**
     *  当收到请求的时候，随机生成一个8位的随机数当成订单号放入消息队列里面
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/getInfo")
    public DeferredResult<String> getInfo() throws InterruptedException {
        logger.info("主线程开始");
        //随机生成一个8位的随机数当成订单号
        String orderNumber=RandomStringUtils.randomNumeric(8);
        //把订单放入消息队列里面
        chengGeQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result=new DeferredResult<String>();
        deferredResultHodler.getMap().put(orderNumber, result);
        logger.info("主线程结束");
        return result;

    }
}
