package paner.lambda.demo;


import java.util.*;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.stream.Collectors.toList;

/**
 * @User: paner
 * @Date: 18/1/9 下午8:08
 */
public class StreamTest {

    public static void main(String[] args) {



        //fliter
        List<String> beginningWithNumbers
                = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());
        System.out.println("filter:"+beginningWithNumbers);

        //flatMap
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> {
                    System.out.println("numbers = [" + numbers + "]");
                    return  numbers.stream().filter(value->value%2>0);
                })
                .collect(toList());
        System.out.println("flatMap:"+together);

        //max & min
        Integer minV= asList(13,24,3,56,9).stream().min(Comparator.comparing(value->value)).get();
        System.out.println("min = [" + minV + "]");
        Integer maxV = asList(13,24,3,56,9).stream().max(Comparator.comparing(value->value)).get();
        System.out.println("min = [" + maxV + "]");

        //reduce
        int count = Stream.of(1, 2, 3)
                .reduce(1, (acc, element) -> acc + element);
        System.out.println("reduce = [" + count + "]");

        //summaryStattics
        IntSummaryStatistics summaryStatistics = Stream.of(1,23,4,5).mapToInt(i->i).summaryStatistics();
        System.out.println("max = [" + summaryStatistics.getMax() + "]");
    }


    private static List<Integer> asList(int... values){

       // System.out.println("values = [" + Stream.of(values).collect(toList())+ "]");

        List<Integer> list = new ArrayList<>();
        for (int i:values){
            list.add(i);
        }
        return list;
    }

}

