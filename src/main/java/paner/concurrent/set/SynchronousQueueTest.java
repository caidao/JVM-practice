package paner.concurrent.set;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by paner on 17/4/20.
 */
public class SynchronousQueueTest {

    private  SynchronousQueue<String> queue = new SynchronousQueue<String>();
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueueTest test = new SynchronousQueueTest();
        test.start();
    }

    public void start(){
        new Thread(new ProduerE()).start();
        new Thread(new ConsumerE()).start();
    }

    public class ProduerE  implements Runnable{

        public void run() {
            try {

                queue.put("aaa");
                System.out.println("producer:aaa");
                //Thread.sleep(10000);

                queue.put("bbb");
                System.out.println("producer:bbb");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class ConsumerE implements Runnable{

        public void run() {
            try {
                Thread.sleep(10000);
                System.out.println("consumer:"+queue.take());
                Thread.sleep(10000);
                System.out.println("consumer:"+queue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
