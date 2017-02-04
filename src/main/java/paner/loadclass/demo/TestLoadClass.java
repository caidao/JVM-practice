package paner.loadclass.demo;

import java.lang.reflect.Method;

/**
 * Created by www-data on 16/11/30.
 */
public class TestLoadClass {

    public static void main(String args[]){
        String classDataRootPath = "/Users/pan/IdeaProjects/test/out/production/test/";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "hello.Sample";
        try {
            Class<?> class1 = fscl1.findClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl1.findClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            System.out.println("class1->"+class1.hashCode()+" | class2->"+class2.hashCode());
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
