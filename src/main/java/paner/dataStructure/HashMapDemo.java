package paner.dataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;

/**
 * Created by paner on 17/5/6.
 */
public class HashMapDemo {

    private  HashMap<Integer,String> map;
    @Before
    public void before(){

    }

    @Test
    public void test1(){
        HashMap<String,String> map= new HashMap();
        map.put("test","test");
        System.out.println("size:"+map.size());
    }

    @Test
    public void  hashTest(){
        int val = (int)pow(2.0,17.0);
        int i = val ^ (val>>>16);
        System.out.println("code:"+i);
    }

    @Test
    /**
     * 多线程下出现死循环，需要单步调试
     */
    public void hashMapInfinitLoop(){
        map= new HashMap<Integer,String>(2,0.75f);
        map.put(5, "C");
        new Thread("Thread1"){
            public void run(){
                map.put(7,"B");
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2"){
            public void run(){
                map.put(3,"A");
                System.out.println(map);
            }
        }.start();

        //key=3这个值回丢失
        System.out.println("value:"+map.get(3));
    }
}
