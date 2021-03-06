package com.zach.util.range;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class CsvUtil {
    //CSV文件分隔符
    private final static String NEW_LINE_SEPARATOR="\n";
    //初始化csvformat
    CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);


    /**读取csv文件
     * @param filePath 文件路径
     * @param headers csv列头
     * @return CSVRecord 列表
     * @throws IOException **/
    public static List<CSVRecord> readCSV(String filePath, String[] headers, String charset) throws IOException {

        //创建CSVFormat
        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);

        InputStream inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName(charset));  //读取文件的时候将流设置为 自定义


        //创建CSVParser对象
        CSVParser parser=new CSVParser(inputStreamReader,formator);

        List<CSVRecord> records=parser.getRecords();

        parser.close();
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(inputStreamReader);

        return records;
    }


    /**写入csv文件
     * @param headers 列头
     * @param data 数据内容
     * @param filePath 创建的csv文件路径
     * @throws IOException **/
    public static void writeCsv(String[] headers, List<String[]> data, String filePath) throws IOException{
        FileWriter fileWriter = null;
        try {
            //初始化csvformat
            CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

            //创建FileWriter对象
            fileWriter = new FileWriter(filePath);

            //创建CSVPrinter对象
            CSVPrinter printer=new CSVPrinter(fileWriter,formator);

            //写入列头数据
            printer.printRecord(headers);

            if(null!=data){
                //循环写入数据
                for(String[] lineData:data){

                    printer.printRecord(lineData);

                }
            }

            System.out.println("CSV文件创建成功,文件路径:"+filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
        }

    }

}
