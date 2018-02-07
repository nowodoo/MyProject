package pl.tomaszdziurko.guava.retry;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class RetryTest {
    private static final Logger logger = LoggerFactory.getLogger(RetryTest.class);

    @Test
    public void retryTest() {
        //重试需要执行的逻辑
        Callable<Boolean> callable = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                logger.info("进入实际执行的方法!");
                return true; // do something useful here
            }
        };


        //构建重试配置
        logger.info("开始构建重试配置...");
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>isNull())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();


        //开始真正调用
        try {
            logger.info("开始调用...");
            retryer.call(callable);
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
