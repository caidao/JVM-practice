package paner.jvm.demo;

/**
 * Created by www-data on 16/11/28.
 */
public class BigObj2Old{
        public static void main(String[] args){
            byte[] b;
            b = new byte[1024*1024];//分配一个 1MB 的对象
        }
}
