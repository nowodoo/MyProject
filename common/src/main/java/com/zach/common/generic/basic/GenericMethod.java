package com.zach.common.generic.basic;

/**
 * Created by zach on 17/6/11.
 */
public class GenericMethod {
    /**
     * 使用泛型方法首先需要在返回值前面声明泛型类型。
     * @param b
     * @param first
     * @param second
     * @param <T>
     * @returnS
     */
    public <T, R, S> R ifThenElse(boolean b, T first, R second, S third) {
        return second;
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
}
