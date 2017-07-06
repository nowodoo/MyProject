package pl.tomaszdziurko.guava.collect;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.testng.annotations.Test;
import pl.tomaszdziurko.guava.geo.Continent;
import pl.tomaszdziurko.guava.geo.Country;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Collections2 showcase
 */
public class Collections2Test {

    @Test
    public void shouldTransformCollection() throws Exception {

        //这里是将一个集合集合进行转换，返回另一个形式的集合罢了。

        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.ENGLAND);

        // when
        Collection<String> capitalCities = Collections2.transform(countries,
                new Function<Country, String>() {

                    @Override
                    public String apply(@Nullable Country country) {
                        return country.getCapitalCity();
                    }
                });

        // then
        assertThat(capitalCities).containsOnly("Warsaw", "Brussels", "London");
    }

    @Test
    public void shouldFilterCountriesOnlyFromAfrica() throws Exception {

        //这里是将一个集合进行过滤，按照条件获取需要的数据。从另一个方面看，就是将一个集合转化为另一个集合。

        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.SOUTH_AFRICA);

        // when
        Collection<Country> countriesFromAfrica = Collections2.filter(countries, new Predicate<Country>() {

            @Override
            public boolean apply(@Nullable Country country) {
                return Continent.AFRICA.equals(country.getContinent());
            }
        });

        // then
        assertThat(countriesFromAfrica).containsOnly(Country.SOUTH_AFRICA);
    }

    @Test
    public void shouldShowThatResultIsOnlyAView() throws Exception {

        //其实就是实现了过滤和重定向的功能，将一个集合重定向为另一个集合，当过滤条件非常复杂的时候，那么这个时候，他的优势就很突出了。

        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.ENGLAND);

        // when
        Collection<String> capitalCities = Collections2.transform(countries,
                new Function<Country, String>() {
                    public String apply(@Nullable Country country) {
                        return country.getCapitalCity();
                    }
                });

        // then
        assertThat(capitalCities).containsOnly("Warsaw", "Brussels", "London");
        assertThat(capitalCities).excludes("Pretoria");

        countries.add(Country.SOUTH_AFRICA);

        assertThat(capitalCities).contains("Pretoria");
    }

    @Test
    public void changeListToMultiMap() {
        List<Map<String, Object>> hotelList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("key1", "1");
            map.put("key2", "2");
            map.put("key3", "3");
            map.put("key4", "4");
            map.put("key5", "5");

            hotelList.add(map);
        }


        //函数式实现添加一个key
        //注意每个地方都是两个参数
        Multimap<Map<String, Object>, Map<String, Object>> cityHotelMap = Multimaps.index(hotelList, new Function< Map<String, Object>, Map<String, Object> >() {

            //这里的入参和出参都是对应着两个值，一个是原生，另一个就是经过变化的
            public Map<String, Object> apply(Map<String, Object> input) {
                input.put("addedKey", "6");
                return input;
            }
        });


        //将所有的结果输出
        System.out.println(hotelList);
        System.out.println(cityHotelMap);



        //下面才是源码，将hotel转换为String的样式
//        List<Hotel> hotelList = new ArrayList<>();
//
//        MultiMap<String,Hotel> cityHotelMap = MultiMaps.index(hotelList,new Function(){
//            @Override
//            public String apply(Hotel input) {
//                return input.getCityCode();
//            }
//        })

    }
}
