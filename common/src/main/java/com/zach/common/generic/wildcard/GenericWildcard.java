package com.zach.common.generic.wildcard;

import com.sun.tools.javac.util.List;

/**
 * 泛型通配符的例子，泛型通配符只是对泛型的范围做一个限制。
 * 就是表明泛型的范围
 * 关于通配符的方法请看下面连接：http://mp.weixin.qq.com/s/te9K3alu8P8jRUUU2AkO3g
 * Created by zach on 17/6/10.
 */
public class GenericWildcard {

    //将list中的元素进行位置互换
    private void swap(List<?> list, int i, int j) {
        Object o = list.get(i);
//        list.set(j,o); //在这里使用object会报错的

        //为了解决上面的报错，直接调用下面的方法
        swapInternal(list, i, j);
    }


    //下面是解决方案（泛型方法总是在返回值前面添加泛型）
    private <E> void swapInternal(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
