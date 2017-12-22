package pl.tomaszdziurko.guava.base;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.internal.Nullable;
import org.testng.annotations.Test;
import pl.tomaszdziurko.guava.geo.Country;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Class to show how Functions in Guava works
 */

public class FunctionsTest {

    @Test
    public void shouldPrintCountryWithCapitalCityUpperCase() throws Exception {

        // given
        Function<Country, String> capitalCityFunction = new Function<Country, String>() {
            public String apply(@Nullable Country country) {
                if (country == null) {
                    return "";
                }
                return country.getCapitalCity();
            }
        };

        // when
        Collection<String> capitalCities = Collections2.transform(Country.getSomeCountries(), capitalCityFunction);

        // then
        assertThat(capitalCities).contains("Warsaw", "Madrid");
    }

    @Test
    public void shouldComposeTwoFunctions() throws Exception {
        //表示经过两个函数的变换，一个是结构的变换，另一个是内容的变换。

        Function<Country, String> upperCaseFunction = new Function<Country, String>() {
            public String apply(@Nullable Country country) {
                if (country == null) {
                    return "";
                }
                return country.getCapitalCity().toUpperCase();
            }
        };

        Function<String, String> reverseFunction = new Function<String, String>() {
            public String apply(String string) {
                if(string == null) {
                    return null;
                }
                return new StringBuilder(string).reverse().toString();
            }
        };
        Function<Country, String> composedFunction = Functions.compose(reverseFunction, upperCaseFunction);

        // when
        Collection<String> reversedCapitalCities = Collections2.transform(Country.getSomeCountries(), composedFunction);

        // then
        assertThat(reversedCapitalCities).contains("WASRAW", "DIRDAM");
    }

    @Test
    public void shouldUseForMapFunction() throws Exception {
        //就是根据一堆键，获取一堆值

        // given
        Map<String, String> map = Maps.newHashMap();
        map.put(Country.POLAND.getName(), Country.POLAND.getCapitalCity());
        map.put(Country.BELGIUM.getName(), Country.BELGIUM.getCapitalCity());
        map.put(Country.SPAIN.getName(), Country.SPAIN.getCapitalCity());
        map.put(Country.ENGLAND.getName(), Country.ENGLAND.getCapitalCity());

        // when
        Function<String, String> capitalCityFromCountryName = Functions.forMap(map);

        List<String> countries = Lists.newArrayList();
        countries.add(Country.POLAND.getName());
        countries.add(Country.BELGIUM.getName());

        // then
        Collection<String> capitalCities = Collections2.transform(countries, capitalCityFromCountryName);

        assertThat(capitalCities).containsOnly(Country.POLAND.getCapitalCity(), Country.BELGIUM.getCapitalCity());
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Key 'Belgium' not present in map")
    public void shouldUseForMapFunctionWithNonExistingKey() throws Exception {

        //就是为了抛出异常，要是在一个没有相关key的集合里面获取想要的数值是不可以的。

        // given
        Map<String, String> map = Maps.newHashMap();
        map.put(Country.POLAND.getName(), Country.POLAND.getCapitalCity());

        // we omit this one intentionally
        // map.put(Country.BELGIUM.getName(), Country.BELGIUM.getCapitalCity());
        map.put(Country.SPAIN.getName(), Country.SPAIN.getCapitalCity());
        map.put(Country.ENGLAND.getName(), Country.ENGLAND.getCapitalCity());

        // when
        Function<String, String> capitalCityFromCountryName = Functions.forMap(map);

        List<String> countries = Lists.newArrayList();
        countries.add(Country.POLAND.getName());
        countries.add(Country.BELGIUM.getName());

        // then
        Collection<String> capitalCities = Collections2.transform(countries, capitalCityFromCountryName);

        assertThat(capitalCities).containsOnly(Country.POLAND.getCapitalCity(), Country.BELGIUM.getCapitalCity());
    }

    @Test
    public void shouldUseForMapFunctionWithDefaultValue() throws Exception {

        //表示对没有的值可以做一个默认值，就是这个文key没有值了就设置一个默认值。

        // given
        Map<String, String> map = Maps.newHashMap();
        map.put(Country.POLAND.getName(), Country.POLAND.getCapitalCity());

        // we omit this one intentionally
        // map.put(Country.BELGIUM.getName(), Country.BELGIUM.getCapitalCity());
        map.put(Country.SPAIN.getName(), Country.SPAIN.getCapitalCity());
        map.put(Country.ENGLAND.getName(), Country.ENGLAND.getCapitalCity());

        // when
        Function<String, String> capitalCityFromCountryName = Functions.forMap(map, "Unknown");

        List<String> countries = Lists.newArrayList();
        countries.add(Country.POLAND.getName());
        countries.add(Country.BELGIUM.getName());

        // then
        Collection<String> capitalCities = Collections2.transform(countries, capitalCityFromCountryName);

        assertThat(capitalCities).containsOnly(Country.POLAND.getCapitalCity(), "Unknown");
    }
}