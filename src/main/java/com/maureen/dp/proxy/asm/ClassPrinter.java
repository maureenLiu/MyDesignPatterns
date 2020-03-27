package com.maureen.dp.proxy.asm;

import org.objectweb.asm.*;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;

//通过程序来反编译，读取字节码，典型的visitor模式的应用
public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(ASM4);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }


    public void visitSource(String source, String debug) {
    }

    public void visitOuterClass(String owner, String name, String desc) {
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    public void visitAttribute(Attribute attr) {
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        //System.out.println("    " + desc + " " + name);
        System.out.println(" " + name);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        //System.out.println("    " + name + desc);
        System.out.println(" " + name + "()");
        return null;
    }

    public void visitEnd() {
        System.out.println("}");
    }

    public static void main(String[] args) {
        ClassPrinter cp = new ClassPrinter();
        //       ClassReader cr = null;
//        try {
//            cr = new ClassReader("java/lang/Runnable");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ClassReader cr = null;
        try {
            cr = new ClassReader(
                    ClassPrinter.class.getClassLoader().getResourceAsStream("com/maureen/dp/proxy/asm/T1.class"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cr.accept(cp, 0);
    }

}


