package com.gy.Jvm;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws IOException {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.findClass(name);
        }

        

        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            MyClassLoader classLoader = new MyClassLoader("/Users/victorli/Documents/element/test");
            Class clazz = classLoader.loadClass("com.tuling.jvm.User1");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("sout", null);
            method.invoke(obj, null);
            System.out.println(clazz.getClassLoader().getClass().getName());
        }




    }
}
