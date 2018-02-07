package pl.tomaszdziurko.guava.retry;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class RetryTest {
    static volatile int tryTimes = 0;
    private static final Logger logger = LoggerFactory.getLogger(RetryTest.class);


    @Test
    public void retryTest() {
        //重试需要执行的逻辑
        Callable<Boolean> callable = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                tryTimes++;
                logger.info("执行次数：{}, 进入实际执行的方法!", tryTimes);
                //抛出异常测试
//                if (3 != tryTimes) {
//                    logger.info("执行次数：{}, 进入异常", tryTimes);
//                    throw new Exception("自定义异常!");
//                }


                //返回结果测试
                if (1 == tryTimes) {
                    return true;
                }else{
                    return null;
                }
            }
        };


        //构建重试配置
        logger.info("开始构建重试配置...");
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>isNull())
                .retryIfExceptionOfType(Exception.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(10))
                .build();


        //开始真正调用
        try {
            logger.info("开始调用...");
            retryer.call(callable);
            logger.info("结束调用...");
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
