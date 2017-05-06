package paner.lambda.demo;

import java.util.Arrays;
import java.util.List;

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
}
