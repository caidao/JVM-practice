package paner.lambda.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www-data on 17/2/21.
 */
public class Java8Tester {

    public static void main(String args[]){
        Java8Tester tester = new Java8Tester();

        List<String> list = new ArrayList<>();
        list.stream();



//        // 类型声明
        final int[] a = {3};
        final  int m=2;
        MathOperation addition = (int b) -> {
            a[0]=m+a[0];
            a[0]++;
            return  a[0] + b;
        };
//
//        // 不用类型声明
   //       MathOperation subtraction = (a, b) -> a - b;
//
//        // 大括号中的返回语句
//        MathOperation multiplication = (int a, int b) -> { return a * b; };
//
//        // 没有大括号及返回语句
//        MathOperation division = (int a, int b) -> a / b;
//
        System.out.println("10 + 5 = " + addition.operation(4));
        System.out.println("10 + 5 = " + addition.operation(4));
//        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
//        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
//        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        MathOperations runnable = () -> System.out.println("args = [" + args + "]");
         runnable.operation();
//
//        // 不用括号
//        GreetingService greetService1 = message ->
//                System.out.println("Hello " + message);
//
//        // 用括号
//        GreetingService greetService2 = (message) ->
//                System.out.println("Hello " + message);
//
//        greetService1.sayMessage("Runoob");
//        greetService2.sayMessage("Google");
    }
//
    @FunctionalInterface
    interface MathOperation {
        int operation(int b);
    }


    @FunctionalInterface
    interface MathOperations {
        void operation();
    }


//
//    @FunctionalInterface
//    interface GreetingService {
//        void sayMessage(String message);
//    }
//
//    private int operate(int a, int b, MathOperation mathOperation){
//        return mathOperation.operation(a, b);
    }


