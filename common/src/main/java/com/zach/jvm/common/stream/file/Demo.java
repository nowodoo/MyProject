package com.zach.jvm.common.stream.file;


import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) throws Exception {

        //源目录的 和 目标目录
        Path sourcePath = Paths.get("/Users/zach/Workspace/code/idea/dwd/coupon-service_master/coupon-server");
        Path desPath = Paths.get("/Users/zach/Workspace/code/idea/dwd/coupon-service-multi-recovery/coupon-gw-server");
        String pathNeedToReplace = "/Users/zach/Workspace/code/idea/dwd/coupon-service_master/coupon-server";//路径中需要替换的
        String pathNeedToReplaceAs = "/Users/zach/Workspace/code/idea/dwd/coupon-service-multi-recovery/coupon-gw-server";//路径中替换成什么样的
        String packagePathNeedToReplace = "com/dianwoba/optimus/coupon";//包路径中需要替换的
        String packagePathNeedToReplaceAs = "com/dianwoba/optimus/coupon/gw";//包路径中替换成什么样的
        String needReplace = "com.dianwoba.optimus.coupon.";
        String needReplaceTo = "com.dianwoba.optimus.coupon.gw.1.";
        String tempStr = "jojotemp";  //这里进行替换之后会形成临时文件,临时文件的结尾是  .javajojo
        String fileExtendName = ".java";  //只处理以此文件结尾的文件
        String fileExtendNameNeedToDelete = ".java" + tempStr;  //需要删除的临时文件的格式
        String lineContains = "import";  //针对每一行里面有import的字段的才处理

        Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                String originAbsPath = file.toString();

                if (originAbsPath.endsWith(fileExtendName)) {
                    //获取每一个文件
                    System.out.println("开始处理文件:" + originAbsPath);

                    //遍历文件的每一行
                    Stream<String> lines = Files.lines(file);

                    //判断是否需要创建新文件
                    String newFileName = null;
                    newFileName = originAbsPath + tempStr;
                    System.out.println("开始创建新文件:" + newFileName);

                    final String finalNewFileName = newFileName;
                    lines.forEach(line -> {
                        //将旧的文件创建为一个新的文件,将每一行添加进去
                        try {
                            if (null != finalNewFileName) {
                                //判断每行是不是存在要替换的字符
                                if (line.indexOf(needReplace) != -1 && line.indexOf(needReplaceTo) == -1 && line.indexOf(lineContains) != -1) {
                                    line = line.replaceFirst(needReplace, needReplaceTo);
                                    System.out.println("发现需要替换的行,替换之后的结果为:" + line);
                                }
                                Files.write(Paths.get(finalNewFileName), line.concat("\n").getBytes("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });



                    //复制文件时候,需要直接将目标路径中的文件覆盖掉
                    //获取目标文件夹
                    String newAbsPath = originAbsPath.replace(pathNeedToReplace, pathNeedToReplaceAs);  //新路径的处理逻辑
                    newAbsPath = newAbsPath.replace(packagePathNeedToReplace, packagePathNeedToReplaceAs);
                    Path newFilePath = Paths.get(newAbsPath);
                    //判断文件是不是存在,文件不存在就创建一个
                    if (!Files.exists(newFilePath, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS})) {
                        Files.createFile(newFilePath);
                        System.out.println("文件不存在创建成功,新文件为:" + newAbsPath);
                    }
                    //复制文件
                    Files.copy(file, newFilePath, StandardCopyOption.REPLACE_EXISTING);  //新的文件处理掉
                    System.out.println("已经复制文件到:" + newAbsPath);




                    System.out.println("结束处理文件:" + originAbsPath);
                    System.out.println("");
                    System.out.println("");
                }


                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });




        //然后将原文件中的临时文件删掉
        Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if (file.toString().endsWith(fileExtendNameNeedToDelete)) {
                    Files.delete(file);
                    System.out.println("临时文件已经删除" + file.toString());
                }
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });

    }
}
