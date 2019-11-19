package com.zach.download;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author wanqin
 * 时间: 2019/11/19.
 * 相关业务:
 */
public class DownLoadUtil {
    private static final int HTTP_CONNECTION_TIMEOUT = 3000;
    private static final int HTTP_READ_TIMEOUT = 3000;


    public static void downloadFile(String downloadUrl, String saveFilePath) throws Exception {
        InputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            URL url = new URL(downloadUrl);
            URLConnection conn = url.openConnection();
            inStream = conn.getInputStream();
            outStream = new FileOutputStream(saveFilePath);
            byte[] buffer = new byte[12040];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } finally {
            IOUtils.closeQuietly(outStream, inStream);
        }

    }

    public static String getRequestResult(String getUrl) throws Exception {

        InputStream in = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(getUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(HTTP_CONNECTION_TIMEOUT);
            conn.setReadTimeout(HTTP_READ_TIMEOUT);
            conn.connect();
            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.length() > 0) {
                    sb.append(currentLine);
                }
            }
            return sb.toString();
        } finally {
            IOUtils.closeQuietly(reader, in);
        }
    }
}
