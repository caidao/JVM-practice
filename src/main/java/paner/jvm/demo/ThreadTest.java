package paner.jvm.demo;

/**
 * Created by www-data on 16/11/29.
 */
public class ThreadTest {
    public static void main(String args[]){

        for(int i =0 ; i< 10 ;i++){

            if(i%3== 0){
                thread(("a"+i));
            }else{
                thread((""+i));
            }
        }

    }

    public static void thread(String str){
        final String a =str;
        new Thread(
                new Runnable(){
                    public void run(){
                        method(a);
                        System.out.println(a+"这里执行！");
                    }
                }
        ).start();
    }

    public static void method(String a){
        Integer.parseInt(a);
    }
}
