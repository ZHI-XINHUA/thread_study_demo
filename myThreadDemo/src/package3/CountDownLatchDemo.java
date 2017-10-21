package package3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhixinhua on 17/10/12.
 */
public class CountDownLatchDemo {

    private  static CountDownLatch countDown = new CountDownLatch(3);

    public static Runnable r1 = new Runnable(){
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println("r1 run");
                countDown.countDown();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    };

   public static Runnable r2 = new Runnable() {
        @Override
        public void run() {
            try{
                Thread.sleep(2000);
                System.out.println("r2 run");
                countDown.countDown();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    public  static Runnable r3 = new Runnable() {
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println("r3 run");
                countDown.countDown();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws  Exception{
        System.out.println("===begin=====");
        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(r1);
        exec.submit(r2);
        exec.submit(r3);

        countDown.await();

        System.out.println("====end=====");

        exec.shutdown();



    }
}
