package com.zach.bytecode.javassit;

import javassist.ClassPool;
import javassist.bytecode.*;

import java.util.LinkedList;
import java.util.List;

public class AppAddConstructor {
    public static void main(String[] args) throws Exception {
        ClassFile cf = ClassPool.getDefault().get("com.zach.bytecode.javassit.pojo.Point").getClassFile();

        // add a constructor of the class
        Bytecode code = new Bytecode(cf.getConstPool());
        code.addAload(0);
        code.addInvokespecial("java/lang/Object", MethodInfo.nameClinit, "()V");
        code.addReturn(null);
        MethodInfo minfo = new MethodInfo(cf.getConstPool(), MethodInfo.nameClinit, "()V");
        minfo.setCodeAttribute(code.toCodeAttribute());
        cf.addMethod(minfo);


        //check the existence with iterate the byte code
        CodeIterator ci = code.toCodeAttribute().iterator();
        List<String> operations = new LinkedList<>();
        while (ci.hasNext()) {
            int index = ci.next();
            int op = ci.byteAt(index);
            operations.add(Mnemonic.OPCODE[op]);
        }
        System.out.println(operations);

    }
}
