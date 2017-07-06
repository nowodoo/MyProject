package pl.tomaszdziurko.guava.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Class to show some features of Splitter class
 */
public class SplitterTest {

    public static String textWithDigitsAsADelimeter = "Java1Scala2Haskell3444Brainfuck452Kotlin";
    public static String textWithDigitsFrom3To5AsADelimeter = "Java3Scala4Haskell0Brainfuck5Kotlin";
    public static String textWithFiveCharactersWords = "HorseHouseGroupDemosScrum";

    public static String textWithSemicolonAsADelimeterWithEmptyElementsAndSpaces = "Java;;  ;Scala;;;Haskell;Brainfuck;Kotlin";


    @Test
    public void shouldSplitOnSemicolons() throws Exception {
        // when
        Iterable<String> iterable = Splitter.on(";").split("Java;Scala;Haskell;Brainfuck;Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(3)).isEqualTo("Brainfuck");
    }

    private List<String> convertToList(Iterator<String> iterator) {
        List<String> list = Lists.newArrayList( );

        while(iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list;
    }

    @Test
    public void shouldSplitOnRegExp() throws Exception {
        //用正则表达式去分割一个字符串。

        // when
        Iterable<String> iterable = Splitter.onPattern("\\d+").split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(2)).isEqualTo("Haskell");
    }



    @Test
    public void shouldSplitUsingCharMatcher() throws Exception {

        //这个是用一个范围去分割一个字符串。 3 4 5这样的也算是一个范围

        // when
        Iterable<String> iterable = Splitter
                .on(CharMatcher.inRange('3', '5')).split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(4);
        assertThat(splittedList.get(2)).isEqualTo("Haskell0Brainfuck");

    }

    @Test
    public void shouldSplitAndOmitEmptyElementsAndWhitespaces() throws Exception {

        //忽略空的字符串进行分割

        // when
        Iterable<String> iterable = Splitter.on(";").omitEmptyStrings()
                .trimResults().split("Java;;  ;Scala;;;Haskell;Brainfuck;Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(1)).isEqualTo("Scala");

    }

    @Test
    public void shouldSplitForEqualLength() throws Exception {

        //这个是按照长度进进行分割。每隔着一定的长度将字符串分开。

     // when
        Iterable<String> iterable = Splitter.fixedLength(5).split("HorseHouseGroupDemosScrum");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(4)).isEqualTo("Scrum");
    }
}
