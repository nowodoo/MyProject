package pl.tomaszdziurko.guava.base;

import com.google.common.base.Throwables;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Throwables showcase
 */
public class ThrowablesTest {

    @Test
    public void shouldListAllExceptionsChain() throws Exception {

        try {
            try {
                try {
                    throw new RuntimeException("Innermost exception");
                }
                catch(Exception e) {
                    throw new SQLException("Middle tier exception", e);
                }
            }
            catch(Exception e) {
                throw new IllegalStateException("Last exception", e);
            }
        }
        catch(Exception e) {

            //获取之前所有的方法抛出的异常

            List<Throwable> exceptionsChain = Throwables.getCausalChain(e);
            assertThat(exceptionsChain).onProperty("message")
                    .containsExactly("Last exception", "Middle tier exception", "Innermost exception");
        }
    }

    @Test
    public void shouldExtractInnermostException() throws Exception {

        try {
            try {
                try {
                    throw new RuntimeException("Innermost exception");
                }
                catch(Exception e) {
                    throw new SQLException("Middle tier exception", e);
                }
            }
            catch(Exception e) {
                throw new IllegalStateException("Last exception", e);
            }
        }
        catch(Exception e) {

            //获取最根本的异常信息

            assertThat(Throwables.getRootCause(e).getMessage()).isEqualTo("Innermost exception");
        }
    }

    @Test
    public void shouldGetStackTrace() throws Exception {

        try {
            try {
                try {
                    throw new RuntimeException("Innermost exception");
                }
                catch(Exception e) {
                    throw new SQLException("Middle tier exception", e);
                }
            }
            catch(Exception e) {
                throw new IllegalStateException("Last exception", e);
            }
        }
        catch(Exception e) {

            //这个是很实用的，直接将异常的信息自己取出来，这个很给力的。

            assertThat(Throwables.getStackTraceAsString(e))
                    .contains("Caused by: java.lang.RuntimeException: Innermost exception");
        }
    }
}
