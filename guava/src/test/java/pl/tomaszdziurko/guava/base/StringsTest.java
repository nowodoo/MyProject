package pl.tomaszdziurko.guava.base;

import com.google.common.base.Strings;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Class to show features of Strings class
 */
public class StringsTest {

    @Test
    public void shouldReturnTrueOnNullString() throws Exception {
      assertThat(Strings.isNullOrEmpty(null)).isTrue();
    }

    @Test
    public void shouldConvertNullToEmpty() throws Exception {
        assertThat(Strings.nullToEmpty(null)).isEqualTo("");
    }

    @Test
    public void shouldConvertEmptyToNull() throws Exception {
        assertThat(Strings.emptyToNull("")).isNull();
    }

    @Test
    public void shouldPadEnd() throws Exception {

        //这个是用来不全的，一共多少个字符，然后是用多少个补全整个字符。

        assertThat(Strings.padEnd("Nothing special", 20, '*')).isEqualTo("Nothing special*****");
    }

    @Test
    public void shouldPadStart() throws Exception {

        //在句首补全到一定的长度。

        assertThat(Strings.padStart("Nothing special", 20, ' ')).isEqualTo("     Nothing special");
    }

    @Test
    public void shouldRepeatGivenString() throws Exception {

        //将字符进行重复性展示，就是重复展示一个字符罢了。

        assertThat(Strings.repeat("Hello ", 3)).isEqualTo("Hello Hello Hello ");
    }
}
