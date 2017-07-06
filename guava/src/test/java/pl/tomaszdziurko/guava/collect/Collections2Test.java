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

        //�����ǽ�һ�����ϼ��Ͻ���ת����������һ����ʽ�ļ��ϰ��ˡ�

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

        //�����ǽ�һ�����Ͻ��й��ˣ�����������ȡ��Ҫ�����ݡ�����һ�����濴�����ǽ�һ������ת��Ϊ��һ�����ϡ�

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

        //��ʵ����ʵ���˹��˺��ض���Ĺ��ܣ���һ�������ض���Ϊ��һ�����ϣ������������ǳ����ӵ�ʱ����ô���ʱ���������ƾͺ�ͻ���ˡ�

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


        //����ʽʵ�����һ��key
        //ע��ÿ���ط�������������
        Multimap<Map<String, Object>, Map<String, Object>> cityHotelMap = Multimaps.index(hotelList, new Function< Map<String, Object>, Map<String, Object> >() {

            //�������κͳ��ζ��Ƕ�Ӧ������ֵ��һ����ԭ������һ�����Ǿ����仯��
            public Map<String, Object> apply(Map<String, Object> input) {
                input.put("addedKey", "6");
                return input;
            }
        });


        //�����еĽ�����
        System.out.println(hotelList);
        System.out.println(cityHotelMap);



        //�������Դ�룬��hotelת��ΪString����ʽ
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
