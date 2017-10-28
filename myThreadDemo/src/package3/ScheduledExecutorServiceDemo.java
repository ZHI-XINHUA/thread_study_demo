package package3;

import java.util.concurrent.*;

/**
 * Created by zhixinhua on 17/10/15.
 */
public class ScheduledExecutorServiceDemo {

    /**
     * 任务调度的频率是一定的，它是以上一个任务开始执行时间为七点，之后的period时间，调度下一次任务。 注：如果任务时间
     * 比period长，则任务结束后马上执行。

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,   //任务
                                                  long initialDelay, //第一次任务执行的延时时间
                                                  long period,  //周期时间
                                                  TimeUnit unit); //时间单位
     */
    public  static void  testscheduleAtFixedRate(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis()/1000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        },5,2, TimeUnit.SECONDS);
    }

    /**
     * 在上一个任务结束后，再经过delay时间进行调度。
     * public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, //任务
                                                     long initialDelay,//第一次任务执行的延时时间
                                                     long delay, //延时时间：上一次执行完成到下一次执行开始的时间间隔
                                                     TimeUnit unit); //时间单位
     */
    public static  void testscheduleWithFixedDelay(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },5,2,TimeUnit.SECONDS);

    }



    public static void main(String[] args) {
        //ScheduledExecutorServiceDemo.testscheduleAtFixedRate();
        ScheduledExecutorServiceDemo.testscheduleWithFixedDelay();
    }
}
