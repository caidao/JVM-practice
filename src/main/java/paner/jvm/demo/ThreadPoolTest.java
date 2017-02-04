package paner.jvm.demo;

import java.util.concurrent.*;

/**
 * Created by www-data on 16/12/16.
 */
public class ThreadPoolTest {

    private static int threadNo=0;
    public static void main(String[] args){
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectedExecutionHandler =
                new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                workingQueue, rejectedExecutionHandler);


        for (int i = 0; i < 100; i++) {
               threadNo=i;
            threadPool.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {
                    System.out.println("thread " + String.valueOf(threadNo) + " is called");
                    Thread.sleep(10000);
                    System.out.println("thread " + String.valueOf(threadNo) + " is awake");
                    throw new Exception();
                }

            });
        }

        System.out.println("end");
    }
}
