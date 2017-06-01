package com.zach.annotation.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        //取得Injection的类描述类  
        Class<Injection> clazz = Injection.class;  //clazz是injection
        //取得所有的字段描述对象  
        Field[] fields = clazz.getDeclaredFields();  //这里的fields是person等属性。 这里方法什么的是不算的，只算属性
        System.out.println(fields.length);
        for (Field field : fields) {

            //取得每个字段上面的注解对象  
            Annotation[] annotations = field.getDeclaredAnnotations();  //获取字段上的所有的注解

            System.out.println(annotations.length);

            //遍历每一个注解
            for (Annotation annotation : annotations) {
                //判断注解对象是不是SelfAnnotation类型的
                if (annotation.annotationType() == SelfAnnotation.class) {
                    System.out.println("yes");

                    //就是获取注解的一个属性值
                    String beanName = ((SelfAnnotation) annotation).name();

                    //生成一个Peron的类描述类  
                    Class<?> cc = Class.forName("com.zach.annotation.reflection." + beanName);
                    //生成一个Person对象
                    Object ob = cc.newInstance();
                    System.out.println(field.getName());  //person


                    /**
                     * 这里就是核心方法，将Injection类的字段进行赋值就好了。
                     * 总之是用反射将数值注入就是了
                     * 其实数据可以放在一个结构里面，然后利用方法(就是反射里面的方法)将数据设置到对应的对象里面就好了。
                     */
                    //通过此方法将新建的实例对象赋值给 static Peron person  
                    //如果是非static，那么set的第一个参数必须指定实例对象，也就是哪个Injection对象
                    //因为这是static所以就不用指明了。
                    field.set(null, ob);




                    //获取名字为show的方法  
                    Method method = clazz.getDeclaredMethod("show");
                    //调用该方法  
                    method.invoke(clazz.newInstance());



                    //基本和上面的一样
                    //生成Person对象时，反射调用了带参数的构造
                    Class<?> c2 = Class.forName("com.zach.annotation.reflection." + beanName);
                    Class<?>[] ptype = new Class[]{String.class, Integer.class};
                    Constructor<?> ctor = c2.getConstructor(ptype);
                    Object[] obj = new Object[]{new String("lxq"), new Integer(25)};
                    Object object = ctor.newInstance(obj);
                    field.set(null, object);
                    Method method2 = clazz.getDeclaredMethod("show");
                    method2.invoke(clazz.newInstance());

                }
            }
        }
        //因为 static Peron person，所以新建的Injectin对象的Peron对象都是通过反射最后赋值过得  
        Injection injection = new Injection();
        System.out.println(injection.person.getName() + "," + injection.person.getAge());

    }
}  