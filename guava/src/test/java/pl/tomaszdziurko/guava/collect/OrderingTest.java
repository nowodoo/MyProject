package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.testng.annotations.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.fail;

/**
 * BiMap showcase
 */
public class OrderingTest {

    @Test
    public void testOrdering(){



        //获取最大值和最小值
        List<String> stringList = Lists.newArrayList("b","a","h","z","d","e","3","1","k","a","9","m","k");
        System.out.println(Ordering.natural().max(stringList)); // z
        System.out.println(Ordering.natural().min(stringList)); // 1
        System.out.println("====================================================");



        //自然排序
        List<String> stringList1 = Lists.newArrayList("b","a","h","z","d","e","3","1",null,"k","a","9","m","k");
        System.out.println(stringList1);
        List<String> stringList2 = Ordering.natural().nullsFirst().sortedCopy(stringList1);
        System.out.println("自然排序：" + stringList2);



        //只是进行字符串排序
        List<String> stringList3 = Ordering.usingToString().nullsFirst().sortedCopy(stringList1);
        System.out.println("字符串排序：" + stringList3);
        System.out.println("====================================================");



        //自定义排序
        List<String> stringList4 = Lists.newArrayList("ba","addd","hdd","z","d2243","e5","3325235","1262",null,"k3","a1","9","m3","k333");
        System.out.println(stringList4);
        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                //自定义两个元素的排序规则
                return Ints.compare(left.length(),right.length());
            }
        };
        List<String> stringList5 = ordering.nullsFirst().reverse().sortedCopy(stringList4);
        System.out.println("自定义排序：" + stringList5);
        //判断是不是有序的
        System.out.println("是否是有序的？：" + ordering.nullsFirst().reverse().isOrdered(stringList5));



        // 取出最大和最小的的3个
        List<String> stringList6 = ordering.nullsFirst().reverse().greatestOf(stringList4, 3);
        List<String> stringList7 = ordering.nullsFirst().reverse().leastOf(stringList4, 3);
        System.out.println(stringList6);
        System.out.println(stringList7);
    }
}
