package pl.tomaszdziurko.guava.file;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GuavaFileTest {
    private static Logger logger = LoggerFactory.getLogger(GuavaFileTest.class);

    /**
     * 文件复制
     *
     * @throws Exception
     */
    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void fileCopy() throws Exception {
        try {
            File original = new File("path/to/original");
            File copy = new File("path/to/copy");
            Files.copy(original, copy);
        } catch (Exception e) {
            logger.error("cann't find file!", e);
        }
    }

    /**
     * ﻿文件移动/重命名
     *
     * @throws Exception
     */
    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void fileMoveAndRename() throws Exception {
        File original = new File("src/main/resources/copy.txt");
        File newFile = new File("src/main/resources/newFile.txt");
        try {
            Files.move(original, newFile); //移动或重命名文件，类似Unix中的mv
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件读取为行
     *
     * @throws Exception
     */
    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void readFilesToLines() throws Exception {
        try {
            File file = new File("src/main/resources/copy.txt");
            List<String> readLines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            logger.error("cann't find file!", e);
        }
    }

    /**
     * 文件生成hash值
     *
     * @throws Exception
     */
    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void readFilesToHash() throws Exception {
        File file = new File("src/main/resources/copy.txt");
//        HashCode hashCode = Files.hash(file, Hashing.md5());
    }

    /**
     * 写或追加文件
     *
     * @throws Exception
     */
    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void writeFileOrAppendFile() throws Exception {
        File file = new File("quote1.txt");
        String hamletQuoteStart = "To be, or not to be";
        Files.write(hamletQuoteStart, file, Charsets.UTF_8);//写文件

        String hamletQuoteEnd = ",that is the question";
        Files.append(hamletQuoteEnd, file, Charsets.UTF_8); //追加文件

        String overwrite = "Overwriting the file";
        Files.write(overwrite, file, Charsets.UTF_8); //重写文
    }

    /**
     * 删除文件
     *
     * @throws Exception
     */
    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void deleteFile() throws Exception {
        File file = new File("quote1.txt");
        if(file.exists() && !file.isDirectory()) {
            file.delete(); //delete it
        }
    }
}
