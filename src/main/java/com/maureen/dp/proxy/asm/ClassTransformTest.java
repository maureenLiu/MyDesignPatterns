package com.maureen.dp.proxy.asm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

//ASM如何实现动态代理的
public class ClassTransformTest {
    public static void main(String[] args) {
        ClassReader cr = null;
        try {
            cr = new ClassReader(
                    ClassPrinter.class.getClassLoader().getResourceAsStream("com/maureen/dp/proxy/asm/Tank.class"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                                             String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "TimeProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0); //如果写成cr.accept(cw,0)就是把原来Tank.class复制了一份
        byte[] b2 = cw.toByteArray();

        String path = (String) System.getProperties().get("user.dir");
        File f = new File(path + "/com/maureen/ASM/");
        f.mkdirs();

        FileOutputStream fos;
        try {
            //在项目的com/maureen/ASM下生成Tank_0.class
            fos = new FileOutputStream(new File(path + "/com/maureen/ASM/Tank_0.class"));
            fos.write(b2);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

