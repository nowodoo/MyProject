package pl.tomaszdziurko.guava.byyourself;

import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.fest.assertions.Assertions.assertThat;

/**
 * CaseFormat features
 */
public class FileTest {

    @Test
    public void shouldConvertToUpperUnderscore() throws Exception {

        String testFilePath = "/Users/zach/Desktop/code.txt";
        File testFile = new File(testFilePath);
        CounterLine counter = new CounterLine();
//        Files.readLines(testFile, Charsets.UTF_8, counter);

        List<String> strings = Files.readLines(testFile, Charsets.UTF_8);
        System.out.println(strings);
        System.out.println(counter.getResult());


        List<String> result = new ArrayList<String>();
        Pattern pattern = Pattern.compile("<OrderNo>.*</OrderNo>?");
        //将结果按按照正则表达式取出来
        for (int i = 0; i < strings.size(); i++) {
            String line = strings.get(i);
            Matcher m = pattern.matcher(line);

            while (m.find()) {
                String group = m.group();
                group = group.replace("<OrderNo>", "");
                group = group.replace("</OrderNo>", "");
                result.add(group);
            }
        }

        System.out.println(result);
    }

    static class CounterLine implements LineProcessor<Integer> {
        private int rowNum = 0;

        public boolean processLine(String line) throws IOException {
            rowNum++;
            String[] segments = line.split("\t");
            String lineRe = segments[0];
            if (lineRe.length() > 2000) {
                System.out.print(lineRe.substring(0, 2000));
                System.out.print("\r\n");
                System.out.print(lineRe.substring(2000, lineRe.length()));
                System.out.print("\r\n");
            }
//            System.out.println(segments[0]);
            return true;
        }

        public Integer getResult() {
            return rowNum;
        }
    }

}
