package pl.tomaszdziurko.guava.collect;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test class for Multimap
 */

@Test
public class MultimapTest {

    @Test
    public void shouldTestHowMultimapWorks() throws Exception {

        //其实这个就是一个多key的map

        // given
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // when
        multimap.put("Poland", "Warsaw");
        multimap.put("Poland", "Cracow");
        multimap.put("Poland", "Plock");
        multimap.put("Poland", "Gdansk");

        multimap.put("Germany", "Berlin");
        multimap.put("Germany", "Bremen");
        multimap.put("Germany", "Dortmund");
        multimap.put("Germany", "Koln");

        multimap.put("Portugal", "Lisbone");
        multimap.put("Portugal", "Porto");
        multimap.put("Portugal", "Leira");
        multimap.put("Portugal", "Funchal");
        multimap.put("Portugal", "Funchal");


        // then
        assertThat(multimap.get("Poland").size()).isEqualTo(4);
        assertThat(multimap.get("Portugal").size()).isEqualTo(5); // duplicate values are fine
        assertThat(multimap.get("Poland")).contains("Warsaw", "Plock");
        assertThat(multimap.keys().size()).isEqualTo(13); // keys can have duplicates

    }

    @Test
    public void partitionTest() throws Exception {

        //按照type进行分组，最后得出的 partitionedMap 是用type的value作为key的一个map.

        List<Map<String, String>> listOfMaps = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            Map<String, String> tMap = new HashMap<String, String>();
            tMap.put("1", i + "");
            tMap.put("2", i + "");
            tMap.put("3", i + "");
            tMap.put("4", i + "");
            tMap.put("type", (new Random()).nextInt(10) +"");
            listOfMaps.add(tMap);
        }


        Multimap<String, Map<String, String>> partitionedMap = Multimaps.index(listOfMaps,
                new Function<Map<String, String>, String>() {
                    public String apply(final Map<String, String> from) {
                        return from.get("type");
                    }
                });


        //自己输出一下结果就知道了
        System.out.println(partitionedMap);
    }

    @Test
    public void multiKeyTest() throws Exception {
    }




}
