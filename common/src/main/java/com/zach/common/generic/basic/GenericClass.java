package com.zach.common.generic.basic;

/**
 * Created by zach on 17/6/10.
 * 这个泛型类，直接将符号作用在上面，在类中就都可以直接使用了。
 * 最常用的就是容器类。
 */
public class GenericClass<T> {
    private T mContent;

    public GenericClass(T mContent) {
        this.mContent = mContent;
    }

    /**
     * 需要注意这里的泛型返回值
     * @return
     */
    public T getmContent() {
        return mContent;
    }

    public void setmContent(T mContent) {
        this.mContent = mContent;
    }
}
