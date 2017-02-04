package paner.jvm.demo;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.beans.ExceptionListener;

/**
 * Created by www-data on 16/11/28.
 */
public class PutInEden2 {
    public static void main(String[] args) throws InterruptedException {
        byte[] b1,b2,b3;
        b1=new byte[1024*512];//分配 0.5MB 堆空间
        b2=new byte[1024*1024*4];//分配 4MB 堆空间
        b3=new byte[1024*1024*4];
        b3=null; //使 b3 可以被回收
        b3=new byte[1024*1024*4];//分配 4MB 堆空间
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread start......");
                String temp=null;

            }
        };

        t.start();
        System.out.println("thread end......");
//
    }

}
