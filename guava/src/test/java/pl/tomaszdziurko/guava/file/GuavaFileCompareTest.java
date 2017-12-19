package pl.tomaszdziurko.guava.file;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GuavaFileCompareTest {

    /**
     * 文件读取为行
     *
     */
    @Test
    public void readFilesToLines() throws Exception {
        File fileDb = new File("/Users/zach/Workspace/code/idea/MyProject/guava/src/test/resources/dbdata.txt");
        List<String> readLines = Files.readLines(fileDb, Charsets.UTF_8);



        System.out.println(readLines);
    }
}
