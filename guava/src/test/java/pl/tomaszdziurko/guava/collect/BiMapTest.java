package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.fail;

/**
 * BiMap showcase
 */
public class BiMapTest {

    @Test
    public void shouldInverseBiMap() throws Exception {

        //其实这个就是一个简单的双向map罢了。

        BiMap<Integer, String> bimap = HashBiMap.create();

        // when
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");

        BiMap<String, Integer> inversedBiMap = bimap.inverse();

        // then
        assertThat(inversedBiMap.get("one")).isEqualTo(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "value already present: one")
    public void shouldNotAllowToPutExistingValue() throws Exception {

        //这个主要是测试双向map的唯一性。

        BiMap<Integer, String> bimap = HashBiMap.create();

        // when
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");
        bimap.put(10, "one");

        fail("Should throw IllegalArgumentException");
    }

    @Test
    public void shouldAllowToPutExistingValueWithForcePut() throws Exception {

        //这里可以用forcePut来解决重复的问题，很简单。

        BiMap<Integer, String> bimap = HashBiMap.create();

        // when
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");
        bimap.forcePut(10, "one");

        assertThat(bimap.get(10)).isEqualTo("one");
        assertThat(bimap.get(1)).isNull();

    }
}
