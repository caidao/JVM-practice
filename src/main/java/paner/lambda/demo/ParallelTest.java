package paner.lambda.demo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @User: paner
 * @Date: 18/2/23 下午3:34
 */
public class ParallelTest {

    private static final  int N = 100;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    private Set<String> threadSet = new HashSet<>();

    @Test
    public void parallelDiceRolls(){
        double fraction =1.0/ N;
        IntStream.range(0,N).parallel()
                .mapToObj(a->twoDiceThrows())
                .collect(Collectors.groupingBy(side->side,
                        Collectors.summingDouble(n->fraction)))
        .entrySet().forEach(System.out::println);
        System.out.println("thread size:"+threadSet.size());



    }

    public int twoDiceThrows(){
        int firstThrow = random.nextInt(1, 7);
        int secondThrow = random.nextInt(1, 7);
        threadSet.add(Thread.currentThread().getName());
        return firstThrow + secondThrow;
    }

}
