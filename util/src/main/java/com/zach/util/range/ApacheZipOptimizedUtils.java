package com.zach.util.range;

import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;


public class ApacheZipOptimizedUtils {

    /**
     *
     * @param url the url where to downlaod the zip,  i.e. alipay or wechat download url
     * @param targetDir it's the directory where to store the zip file
     * @param charset GBK or UTF-8
     * @param zipFile the memory file loaded from zip file in disk
     * @param zip the file which is in dish
     * @throws Exception
     */
    public static void unpackArchive(URL url, File targetDir, String charset, ZipFile zipFile, File zip, Map<String, File> fileMap) throws Exception {
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }


        //this is the stream from internet and then to write the internetInputStream to out stream here.
        InputStream in = new BufferedInputStream(url.openStream(), 1024);
        // make sure we get the actual file
        OutputStream out = new BufferedOutputStream(new FileOutputStream(zip));
        //write the input stream from web to out stream which is the local stream.
        copyInputStream(in, out);
        out.close();

        //this file is not stored in disk, but in memory.
        zipFile = new ZipFile(zip.getAbsolutePath(), charset);

        //establish zip file and unzip each single file.
        unZip(zip.getAbsolutePath(), targetDir.getPath(), charset, zipFile, fileMap);
    }
    /**
     * 解析附件zip包 
     * @param unZipFileName 解压的zip文件 
     * @param outputDirectory 输出目录 
     * @throws Exception
     */
    public static void unZip(String unZipFileName, String outputDirectory, String charset, ZipFile zipFile, Map<String, File> fileMap) throws Exception {
        FileOutputStream fileOut = null;
        InputStream inputStream = null;
        int readedBytes;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        //get file converter
//        StreamDecoder streamDecoder = new StreamDecoder();
//
        try{

            //创建输出目录  
            File outputDirFile = new File(outputDirectory);
            if(!outputDirFile.exists()){
                outputDirFile.mkdir();
            }

            //the original way of change the charset of the file
//            if(System.getProperty("os.name").toLowerCase().indexOf("windows") >= 0){
//                zipFile = new ZipFile(unZipFileName,"GBK");
//            }else if(System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0){
//                zipFile = new ZipFile(unZipFileName,"UTF-8");
//            }


            //get every single file and unzip it.
            int i = 0;
            for (Enumeration entries = zipFile.getEntries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();

                //read the file
                File singleFile = new File(outputDirectory + File.separator + entry.getName());
                fileMap.put(String.valueOf(i), singleFile);
                singleFile.createNewFile();
                inputStream = zipFile.getInputStream(entry);

                //write the file to outputstream
                fileOut = new FileOutputStream(singleFile);
                byte[] buf = new byte[1024];
                while ((readedBytes = inputStream.read(buf)) > 0) {
                    fileOut.write(buf, 0, readedBytes);
                }

                //use another way to write file (reader & writer not stream)
//                inputStreamReader = new InputStreamReader(inputStream, Charset.forName("GBK"));
//                outputStreamWriter = new OutputStreamWriter(fileOut, Charset.forName("GBK"));
//                int data = -1;
//                while (-1 != (data =inputStreamReader.read())) {
//                    char theChar = (char) data;
//                    outputStreamWriter.append(theChar);
//                }
//                outputStreamWriter.flush();
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("解析附件失败，请检查压缩包是否损坏！");
        }finally {
            IOUtils.closeQuietly(fileOut);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(outputStreamWriter);
        }
    }


    public static void copyInputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        while (len >= 0) {
            out.write(buffer, 0, len);
            len = in.read(buffer);
        }
        in.close();
        out.close();
    }
}