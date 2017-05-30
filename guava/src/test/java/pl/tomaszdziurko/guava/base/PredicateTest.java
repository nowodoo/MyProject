package pl.tomaszdziurko.guava.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.tomaszdziurko.guava.geo.Continent;
import pl.tomaszdziurko.guava.geo.Country;

import javax.annotation.Nullable;
import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.assertFalse;


/**
 * Features of Predicates class
 */
public class PredicateTest {

    @Test
    public void shouldUseCustomPredicate() throws Exception {

        // given
        Predicate<Country> capitalCityProvidedPredicate = new Predicate<Country>() {

            @Override
            public boolean apply(@Nullable Country country) {
                return !Strings.isNullOrEmpty(country.getCapitalCity());
            }
        };

        // when   下面是两个参数 一个是数组，另一个是判断条件。判断数组里面的每一个是不是符合一定的条件
        boolean allCountriesSpecifyCapitalCity = Iterables.all(
                Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.FINLAND_WITHOUT_CAPITAL_CITY),
                    capitalCityProvidedPredicate);

        // then
        assertFalse(allCountriesSpecifyCapitalCity);
    }

    @Test
    public void shouldComposeTwoPredicates() throws Exception {

        //其实很简单就是给定两个条件，然后用这两个条件去过滤这个集合，然后将数据全部取出来就好了。很简单的。
        // given
        Predicate<Country> fromEuropePredicate = new Predicate<Country>() {

            @Override
            public boolean apply(@Nullable Country country) {
                return Continent.EUROPE.equals(country.getContinent());
            }
        };

        Predicate<Country> populationPredicate = new Predicate<Country>() {

            @Override
            public boolean apply(@Nullable Country country) {
                return country.getPopulation() < 20;
            }
        };

        Predicate<Country> composedPredicate = Predicates.and(fromEuropePredicate, populationPredicate);

        // when
        Iterable<Country> filteredCountries = Iterables.filter(Country.getSomeCountries(), composedPredicate);

        // then
        assertThat(filteredCountries).contains(Country.BELGIUM, Country.ICELAND);
    }

    @Test
    public void shouldCheckPattern() throws Exception {

        //正则表达式的使用，用一个正则的工具类去判断一个字符串是不是符合这个字符串。

        // given
        Predicate<CharSequence> twoDigitsPredicate = Predicates.containsPattern("\\d\\d");

        // then
        assertThat(twoDigitsPredicate.apply("Hello world 40")).isTrue();
    }

    @Test
    public void shouldFindObjectInCollection() throws Exception {

        //判断一个值是不是在一个集合中。判断条件很简单。

        // given
        Predicate elevenInCollectionPredicate = Predicates.in(Arrays.asList(11L, 22L, 33L, 44L));

        // then
        assertThat(elevenInCollectionPredicate.apply(11L)).isTrue();
    }

    
}
