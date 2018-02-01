package com.zach.util.range;

import org.mozilla.universalchardet.UniversalDetector;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class CharsetTest {
    @Test
    public void test(){
        FileInputStream fis = null;
        try {
            String filePath = "/Users/zach/Workspace/code/idea/MyProject/util/target/classes/files/test.csv";
            fis = new FileInputStream(filePath);


            // (1)
            UniversalDetector detector = new UniversalDetector(null);

            // (2)
            int nread;
            byte[] buf = new byte[1024];
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, nread);
            }

            // (3)
            detector.dataEnd();

            // (4)
            String encoding = detector.getDetectedCharset();
            if (encoding != null) {
                System.out.println("Detected encoding = " + encoding);
            } else {
                System.out.println("No encoding detected.");
            }

            // (5)
            detector.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
