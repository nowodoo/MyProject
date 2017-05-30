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

        // when   �������������� һ�������飬��һ�����ж��������ж����������ÿһ���ǲ��Ƿ���һ��������
        boolean allCountriesSpecifyCapitalCity = Iterables.all(
                Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.FINLAND_WITHOUT_CAPITAL_CITY),
                    capitalCityProvidedPredicate);

        // then
        assertFalse(allCountriesSpecifyCapitalCity);
    }

    @Test
    public void shouldComposeTwoPredicates() throws Exception {

        //��ʵ�ܼ򵥾��Ǹ�������������Ȼ��������������ȥ����������ϣ�Ȼ������ȫ��ȡ�����ͺ��ˡ��ܼ򵥵ġ�
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

        //������ʽ��ʹ�ã���һ������Ĺ�����ȥ�ж�һ���ַ����ǲ��Ƿ�������ַ�����

        // given
        Predicate<CharSequence> twoDigitsPredicate = Predicates.containsPattern("\\d\\d");

        // then
        assertThat(twoDigitsPredicate.apply("Hello world 40")).isTrue();
    }

    @Test
    public void shouldFindObjectInCollection() throws Exception {

        //�ж�һ��ֵ�ǲ�����һ�������С��ж������ܼ򵥡�

        // given
        Predicate elevenInCollectionPredicate = Predicates.in(Arrays.asList(11L, 22L, 33L, 44L));

        // then
        assertThat(elevenInCollectionPredicate.apply(11L)).isTrue();
    }

    
}
