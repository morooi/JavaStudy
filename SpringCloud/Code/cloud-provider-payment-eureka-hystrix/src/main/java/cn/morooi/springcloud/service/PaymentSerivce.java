package cn.morooi.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentSerivce {

    /**
     * 正常访问，肯定 OK
     *
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + ", paymentInfoOK, id: " + id + "   🥳";
    }

//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String paymentInfoTimeout(Integer id) {
        int time = 2000;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + ", paymentInfoTimeout, id: " + id + " 😥, 耗时 " + time + " 秒";
    }

    public String paymentInfoTimeoutFallback(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + ", paymentInfoTimeoutFallback, id: " + id + " Fallback";
    }


}
