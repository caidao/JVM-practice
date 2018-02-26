package paner.lambda.demo;

import org.junit.Test;
import sun.jvm.hotspot.utilities.StreamMonitor;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by www-data on 17/2/21.
 */
public class Test1Main {

    public static void main(String args[]){

        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        // 使用lambda表达式
        //List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

    }


    @Test
    public void  test22(){
        //summaryStattics
        IntSummaryStatistics summaryStatistics = Stream.of(1,23,4,5).mapToInt(i->i+2).summaryStatistics();
        System.out.println("max = [" + summaryStatistics.getMax() + "]");
    }

    @Test
    public void partition(){
        Map<Boolean,List<Integer>> map = Stream.of(23,42,54,1,4,56,45).collect(partitioningBy(item->item>50));
        System.out.println("partition:"+map);
    }

    @Test
    public void stringJoin(){
       String buid= Stream.of(23,42,54,1,4,56,45).map(item->item+"A")
               .collect(joining(",","{","}"));
        System.out.println("join:"+buid);
    }


    @Test
    //自定义收集器
    public void stringCollector(){
        String buid= Stream.of(23,42,54,1,4,56,45).map(item->item+"A")
                .collect(new StringCollector(",","{","}"));
        System.out.println("join:"+buid);
    }

    @Test
    //拆分执行
    public  void stepExecute(){
      Stream stream= Stream.of(23,42,54,1,4,56,45).parallel();
      Stream<String> streams= stream.map(item->item+"A");
      String buid = streams.collect(new StringCollector(",","{","}"));
      System.out.println("join:"+buid);
    }
}
