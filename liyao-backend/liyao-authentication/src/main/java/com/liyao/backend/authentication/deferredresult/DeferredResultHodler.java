package com.liyao.backend.authentication.deferredresult;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类，主要是传递DeferredResult用的，因为spring里面都是单实例，
 * 所以在其他的地方调用map就会获取到里面的DeferredResult，就可以返回结果啦
 */
@Component
public class DeferredResultHodler {
    /**
     * 这个map的key就是我们的订单号，每一个订单号会对应一个我们订单的处理结果DeferredResult<String>
     */
    private Map<String,DeferredResult<String>> map=new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
