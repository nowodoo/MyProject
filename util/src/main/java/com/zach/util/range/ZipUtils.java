package com.zach.util.range;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtils {
    public static Logger logger = LoggerFactory.getLogger(ZipUtils.class);

  /**
   * Unpack an archive from a URL
   * 
   * @param url
   * @param targetDir
   * @return the file to the url
   * @throws IOException
   */
  public static File unpackArchive(URL url, File targetDir) throws IOException {
      if (!targetDir.exists()) {
          targetDir.mkdirs();
      }
      InputStream in = new BufferedInputStream(url.openStream(), 1024);
      // make sure we get the actual file
      File zip = File.createTempFile("arc", ".zip", targetDir);
      OutputStream out = new BufferedOutputStream(new FileOutputStream(zip));
      //将文件写到本地
      copyInputStream(in, out);
      out.close();


      //解压文件
      return unpackArchive(zip, targetDir, "GBK");
  }
  /**
   * Unpack a zip file
   * 
   * @param theFile
   * @param targetDir
   * @param charset GBK UTF-8 etc.
   * @return the file
   * @throws IOException
   */
  public static File unpackArchive(File theFile, File targetDir, String charset) throws IOException {
      if (!theFile.exists()) {
          throw new IOException(theFile.getAbsolutePath() + " does not exist");
      }
      if (!buildDirectory(targetDir)) {
          throw new IOException("Could not create directory: " + targetDir);
      }

      //这里文件编码需要注意下，否则会报错的
      ZipFile zipFile = new ZipFile(theFile, Charset.forName(charset));

      //有几个文件解压几个
      for (Enumeration entries = zipFile.entries(); entries.hasMoreElements();) {
          ZipEntry entry = null;
          try {
              entry = (ZipEntry) entries.nextElement();
          } catch (Exception e) {
              logger.error("请检查文件编码，UTF-8 or GBK !", e);
          }
          //重新定义文件名称
          File file = new File(targetDir, File.separator + entry.getName());
          if (!buildDirectory(file.getParentFile())) {
              throw new IOException("Could not create directory: " + file.getParentFile());
          }
          if (!entry.isDirectory()) {
              //创建文件 解压出来的文件
              copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(file)));
          } else {
              if (!buildDirectory(file)) {
                  throw new IOException("Could not create directory: " + file);
              }
          }
      }
      zipFile.close();
      return theFile;
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

  public static boolean buildDirectory(File file) {
      return file.exists() || file.mkdirs();
  }

}