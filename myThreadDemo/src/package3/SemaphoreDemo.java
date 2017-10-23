package package3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zhixinhua on 17/10/15.
 */

/**
 * 信号量指定多个线程，同时访问某一个资源
 */
public class SemaphoreDemo implements  Runnable {
    final Semaphore sema = new Semaphore(5);


    @Override
    public void run() {
        try{
           // System.out.println("in "+this.threadName+" .....");
            sema.acquire();//申请信号
            System.out.println("run "+Thread.currentThread().getName()+" .....");
            Thread.sleep(2000);//模拟耗时

            sema.release();//释放信号量
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        ExecutorService exec = Executors.newFixedThreadPool(20);
        SemaphoreDemo demo = new SemaphoreDemo();
        for (int i=0;i<20;i++){
            exec.submit(demo);
        }
        exec.shutdown();


    }
}
