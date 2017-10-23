package package3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhixinhua on 17/10/12.
 */

/**
 * CountDownLatch:多线程控制工具类，用来控制线程等待，它可以让某一个线程等待知道倒计时结束，再开始执行
 */
public class CountDownLatchDemo {

    //实例化并指定计数个数
    private  static CountDownLatch countDown = new CountDownLatch(3);

    public static Runnable r1 = new Runnable(){
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println("r1 run");
                countDown.countDown();//个数＋1
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

        //等待检查，等待三个线程都执行完成后，主线程才能继续执行
        countDown.await();

        System.out.println("====end=====");

        exec.shutdown();



    }
}
