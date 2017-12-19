package pl.tomaszdziurko.guava.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.zach.util.range.Xml2JsonUtil;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuavaFileCompareTest {

    /**
     * 文件读取为行
     *
     */
    @Test
    public void readFilesToLines() throws Exception {
        Map<String, String> dbMap = new HashMap<String, String>();

        ArrayList<String> dbList = new ArrayList<>();
        ArrayList<String> logList = new ArrayList<>();

        File fileDb = new File("/Users/zach/Workspace/code/idea/MyProject/guava/src/test/resources/dbdata.txt");
        File fileLog = new File("/Users/zach/Workspace/code/idea/MyProject/guava/src/test/resources/logs.txt");
        List<String> dbReadLines = Files.readLines(fileDb, Charsets.UTF_8);
        List<String> logReadLines = Files.readLines(fileLog, Charsets.UTF_8);

        String fileDbPatternStr  = "data-info=\".*?\"";
        Pattern fileDbPattern = Pattern.compile(fileDbPatternStr);

        String fileLogPatternStr  = "\"MSG\":\\[\".*?\"";
        Pattern fileLogPattern = Pattern.compile(fileLogPatternStr);


        if (null != dbReadLines && 0 != dbReadLines.size()) {
            for (int i = 0; i < dbReadLines.size(); i++) {
                String originString = dbReadLines.get(i);
                Matcher fileDbMatcher = fileDbPattern.matcher(originString);

                //每一行所有匹配的
                while (fileDbMatcher.find()) {
                    String matchedStr = fileDbMatcher.group();
                    matchedStr = matchedStr.replaceAll("data-info=\"","");
                    matchedStr = matchedStr.replaceAll("\"","");
                    dbList.add(matchedStr);
                }
            }
        }

        if (null != logReadLines && 0 != logReadLines.size()) {
            for (int i = 0; i < logReadLines.size(); i++) {
                String originString = logReadLines.get(i);
                Matcher fileLogMatcher = fileLogPattern.matcher(originString);

                //每一行所有匹配的
                while (fileLogMatcher.find()) {
                    String matchedStr = fileLogMatcher.group();
                    matchedStr = matchedStr.replaceAll("\"MSG\":\\[\"","");
                    matchedStr = matchedStr.replaceAll("\"","");
                    String xml = new String(Base64.getDecoder().decode(matchedStr));
                    String s = Xml2JsonUtil.xml2JSON(xml);
                    JSONObject jsonObject = JSON.parseObject(s);
                    String orderNo = ((JSONObject) ((JSONObject) ((JSONObject) ((JSONObject) jsonObject).get("MSG")).get("Message")).get("TrxResponse")).get("OrderNo").toString();

                    dbMap.put(orderNo, "");
                    logList.add(orderNo);
                }
            }
        }


        //判断不同的地方
        System.out.println("db size:" + dbList.size());
        System.out.println("log size:" + logList.size());

        ArrayList<Object> all = new ArrayList<>();
        all.addAll(dbList);
        all.addAll(logList);

        System.out.println("all the data: " + all.size());

        HashSet<String> dbSet = new HashSet<>(dbList);
        HashSet<String> logSet = new HashSet<>(logList);

        System.out.println("deduplicate db: " + dbSet.size());
        System.out.println("deduplicate log: " + logSet.size());
        System.out.println("deduplicate log: " + logSet.size());
        System.out.println("deduplicate log: " + logSet.size());


        ArrayList<String> similar = new ArrayList<>(dbList);
        similar.retainAll(logList);
        System.out.println("retain db & log: "+similar.size());

        dbList.removeAll(similar);
        logList.removeAll(similar);
        System.out.println("db special ones which is log not contained: " + JSON.toJSONString(dbList));
        System.out.println("log special ones which is db not contained: " + JSON.toJSONString(logList));


    }
}
