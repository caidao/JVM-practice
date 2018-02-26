package paner.thread.pool;

/**
 * Created by www-data on 17/2/7.
 */
class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+":"+this.name + " is running.");
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}