package pl.tomaszdziurko.guava.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.fest.assertions.Condition;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Iterables class demonstration
 */
public class IterablesTest {

    @Test
    public void shouldCheckLengthOfAllElements() throws Exception {

        //遍历集合中的每一个元素，看一下是不是符合某一个或者是某一些条件。其实这些用在局部逻辑处理上面是很方便的。可以拿来直接用的。

        // given
        Predicate<String> lengthPredicate = new Predicate<String> () {
            @Override
            public boolean apply(@Nullable String input) {
                if(input == null) {
                    return false;
                }
                return input.length() > 3;
            }
        };

        // then
        assertThat(Iterables.all(Lists.newArrayList("Java", "Scala", "Haskell", "Groovy", "Java", "Lisp"),
                lengthPredicate)).isTrue();
    }

    @Test
    public void shouldCheckIfAtLeastOneElementIsEmptyOrNull() throws Exception {

        //这里只是用来判断是不是符合一个元素。

        // given
        Predicate<String> emptyOrNullPredicate = new Predicate<String> () {

            @Override
            public boolean apply(@Nullable String input) {
                return Strings.isNullOrEmpty(input);
            }
        };

        // then
        assertThat(Iterables.any(Lists.newArrayList("Java", "Scala",
                "Haskell", "Groovy", "Java", "Lisp"), emptyOrNullPredicate)).isFalse();
    }

    @Test
    public void shouldConcat() throws Exception {

        // when
        Iterable<String> concatenatedIterable = Iterables.concat(
                Lists.newArrayList("Java", "Scala", "Haskell", "Groovy", "Java", "Lisp"),
                Lists.newArrayList("Spring", "Hibernate", "JSF", "Wicket", "CDI", "Wicket"));


        // then
        assertThat(concatenatedIterable).hasSize(12);
    }

    @Test
    public void shouldCycleOverIterable() throws Exception {

        Iterable<String> cycleIterables = Iterables.cycle("Right", "Left");

        // then
        Iterator<String> iterator = cycleIterables.iterator();
        
        for(int i = 0; i < 100; i++) {
            iterator.next();
        }
        
        assertThat(iterator.next()).is(new Condition<String>() {
            @Override
            public boolean matches(String value) {
                return "Left".equals(value) || "Right".equals(value);
            }
        });
    }

    @Test
    public void shouldFilterOnlyLongs() throws Exception {

        // given
        List<Number> numbersList = Lists.newArrayList();

        numbersList.add(1L);
        numbersList.add(2);
        numbersList.add(3L);
        numbersList.add(4);
        
        // when
        Iterable<Long> filteredList = Iterables.filter(numbersList, Long.class);

        // then
        assertThat(filteredList).hasSize(2).contains(1L, 3L);
    }

    @Test
    public void shouldFilterOutSomeNumbers() throws Exception {

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

        // when
        Iterable<Integer> filteredList = Iterables.filter(numbersList, new Predicate<Integer>() {
            @Override
            public boolean apply(@Nullable Integer input) {
                if (input == null) {
                    return false;
                }
                return input < 0;
            }
        });


        // then
        assertThat(filteredList).hasSize(2).contains(-12, -1024);
    }

    @Test
    public void shouldCountElementsInIterable() throws Exception {

        //遍历一个集合中某一个元素出现的顺序

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -2, 2, 430, 2);

        int frequency = Iterables.frequency(numbersList, 2);


        // then
        assertThat(frequency).isEqualTo(3);
    }

    @Test
    public void shouldReturnSelectedElementWithDefValue() throws Exception {

        //获取一个集合的数值，当这个数值不存在的时候就设置一个默认值。

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

        // when


        // then
        assertThat(Iterables.get(numbersList, 100, -999)).isEqualTo(-999);
    }

    @Test
    public void shouldGetFirstAndLast() throws Exception {

        //获取第一个和最后一个数值，要是没有的话就设置一个默认值

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

        // when
        Integer first = Iterables.getFirst(numbersList, null);
        Integer last = Iterables.getLast(numbersList);

        // then
        assertThat(first).isEqualTo(1);
        assertThat(last).isEqualTo(-1024);
    }

    @Test
    public void shouldPartition() throws Exception {

        //将一个数组按照固定的长度进行分割，分割为多个数组

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

        // when
        Iterable<List<Integer>> partitionedLists = Iterables.partition(numbersList, 5);

        // then
        assertThat(Iterables.size(partitionedLists)).isEqualTo(2);
        Iterator<List<Integer>> iterator = partitionedLists.iterator();
        assertThat(iterator.next().size()).isEqualTo(5);
        assertThat(iterator.next().size()).isEqualTo(3);
        
    }

    @Test
    public void shouldConvertToArray() throws Exception {

        //将一个包含数字的集合元素转换为包含数字的数组。

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

        // when
        Number[] numbers = Iterables.toArray(numbersList, Number.class);
        Number[] numbersWithTraditionalWay = numbersList.toArray(new Number[] {});


        // then
        assertThat(numbers).contains(1, 2, 3, 0, -12, 22, 430, -1024);
    }

    @Test
    public void shouldRemoveNegativeNumbers() throws Exception {

        //将集合中的元素按照规则进行移除。

        // given
        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

        // when
        Iterables.removeIf(numbersList, new Predicate<Integer>() {
            @Override
            public boolean apply(@Nullable Integer input) {
                return input < 0;
            }
        });

        // then
        assertThat(numbersList).excludes(-12, -1024);
    }


}
