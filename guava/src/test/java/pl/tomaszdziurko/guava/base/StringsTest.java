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

        //�����������ȫ�ģ�һ�����ٸ��ַ���Ȼ�����ö��ٸ���ȫ�����ַ���

        assertThat(Strings.padEnd("Nothing special", 20, '*')).isEqualTo("Nothing special*****");
    }

    @Test
    public void shouldPadStart() throws Exception {

        //�ھ��ײ�ȫ��һ���ĳ��ȡ�

        assertThat(Strings.padStart("Nothing special", 20, ' ')).isEqualTo("     Nothing special");
    }

    @Test
    public void shouldRepeatGivenString() throws Exception {

        //���ַ������ظ���չʾ�������ظ�չʾһ���ַ����ˡ�

        assertThat(Strings.repeat("Hello ", 3)).isEqualTo("Hello Hello Hello ");
    }
}
