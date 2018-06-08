package com.zach.bytecode.javassit;

import javassist.ClassPool;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.FieldInfo;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        ClassFile cf = ClassPool.getDefault().get("com.zach.bytecode.javassit.pojo.Point").getClassFile();

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        //set access as public, just equals to adding public before method.
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);


        // to verify with java reflection.
        ClassPool classPool = ClassPool.getDefault();
        Field[] fields = classPool.makeClass(cf).toClass().getFields();
        List<String> fieldsList = Stream.of(fields).map(Field::getName).collect(Collectors.toList());
        System.out.println(fieldsList);
    }
}
