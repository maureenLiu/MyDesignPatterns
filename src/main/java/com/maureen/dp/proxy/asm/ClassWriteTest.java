package com.maureen.dp.proxy.asm;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;


/**
 * 目标是用如下代码生成这个接口的字节码：
 * package pkg;
 * public interface Comparable extends Mesurable {
 * int LESS = -1;
 * int EQUAL = 0;
 * int GREATER = 1;
 * int compareTo(Object o);
 * }
 * <p>
 * ASM可以动态生成字节码
 *
 * @author Administrator
 */
//示例代码来源于ASM官方文档-UserGuide
public class ClassWriteTest {
    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(0); //0表示一个空文件，可以往里写
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "pkg/Comparable", null, "java/lang/Object",
                null/*new String[] { "pkg/Mesurable" }*/);//指定版本号，修饰符，名字，父类，
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();//写入字段
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray(); //生成的class文件在内存里，并没有用File往硬盘上写

        MyClassLoader myClassLoader = new MyClassLoader();
        Class c = myClassLoader.defineClass("pkg.Comparable", b);
        System.out.println(c.getMethods()[0].getName()); //拿到生成的字节码的方法的名称
    }
}

