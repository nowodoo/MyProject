package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.ObjectArrays;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * ObjectArrays showcase
 */
public class ObjectArraysTest {
    
    String[] array1 = new String[] {"one", "two", "three"};
    String[] array2 = new String[] {"four", "five"};

    @Test
    public void shouldContactTwoArrays() throws Exception {

        //将集合进行简单的合并

        // when
        String[] newArray = ObjectArrays.concat(array1, array2, String.class);

        // then
        assertThat(newArray.length).isEqualTo(5);
    }

    @Test
    public void shouldAppendElement() throws Exception {

        //将一个集合和单个元素合并

        // when
        String[] newArray = ObjectArrays.concat(array2, "six");

        // then
        assertThat(newArray.length).isEqualTo(3);
        assertThat(newArray[2]).isEqualTo("six");
    }

    @Test
    public void shouldPrependElement() throws Exception {

        // when
        String[] newArray = ObjectArrays.concat("zero", array1);

        // then
        assertThat(newArray.length).isEqualTo(4);
        assertThat(newArray[0]).isEqualTo("zero");
    }
}
