package paner.dataStructure;

import org.junit.Test;

import java.util.HashMap;

import static java.lang.Math.pow;

/**
 * Created by paner on 17/5/6.
 */
public class HashMapDemo {

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
}
