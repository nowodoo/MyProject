package com.zach.util.range;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

public class FileUtil {

    /**
     * get file encoding(charset)
     * @return
     */
    public static String getFileEncoding(String filePath) {
        InputStreamReader r = null;
        try {
            File in =  new File(filePath);
            r = new InputStreamReader(new FileInputStream(in));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return r.getEncoding();

    }
}
