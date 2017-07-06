package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test class for Multiset
 */

@Test
public class MultisetTest {


    @Test
    public void shouldAddElementTwoTimes() throws Exception {

        // given
        Multiset<String> multiset = HashMultiset.create();

        // when
        multiset.add("nothing");
        multiset.add("nothing");

        // then
        assertThat(multiset.count("nothing")).isEqualTo(2);
        assertThat(multiset.count("something")).isEqualTo(0);
    }

    @Test
    public void shouldUserCustomAddRemoveAndSetCount() throws Exception {

        // given
        Multiset<String> multiset = HashMultiset.create();

        // when
        multiset.add("ball");
        multiset.add("ball", 10);  //这里的用法是添加多个元素，一次性添加10个元素。

        // then
        assertThat(multiset.count("ball")).isEqualTo(11);


        // when
        multiset.remove("ball", 5);  //这里是移除5个相同的ball元素。

        // then
        assertThat(multiset.count("ball")).isEqualTo(6);

        
        // when
        multiset.setCount("ball", 2);    //设置ball的数量，无形之中将ball的数量锐减了。
      
        // then
        assertThat(multiset.count("ball")).isEqualTo(2);
    }


    @Test
    public void shouldRetainOnlySelectedKeys() throws Exception {

        //取交集的操作。

        // given
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("ball");
        multiset.add("ball");
        multiset.add("cow");
        multiset.setCount("twelve", 12);

        // when
        multiset.retainAll(Arrays.asList("ball", "horse"));

        assertThat(multiset.count("ball")).isEqualTo(2);
        assertThat(multiset.count("twelve")).isEqualTo(0);
    }

}
