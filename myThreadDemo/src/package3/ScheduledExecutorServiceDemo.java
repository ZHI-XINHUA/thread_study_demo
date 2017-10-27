package package3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhixinhua on 17/10/15.
 */
public class ScheduledExecutorServiceDemo {

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
