package paner.concurrent.lock;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by www-data on 17/2/17.
 */
public class NoLockIncrement {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);
        AtomicInteger a=new AtomicInteger(0);
        long start = System.currentTimeMillis();
        int auto=0;
        for(int i=0;i<1000000000;i++){
               a.incrementAndGet();
        }

        System.out.println("times: "+(System.currentTimeMillis()-start));
    }
}
