package package3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhixinhua on 17/10/15.
 */
public class ScheduledExecutorServiceDemo {

    public  static void  setscheduleAtFixedRate(ScheduledExecutorService ses){
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

    public static  void setscheduleWithFixedDelay(ScheduledExecutorService ses){
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
        ScheduledExecutorService es = Executors.newScheduledThreadPool(10);
        System.out.println(System.currentTimeMillis()/1000);
        //ScheduledExecutorServiceDemo.setscheduleAtFixedRate(es);
        ScheduledExecutorServiceDemo.setscheduleWithFixedDelay(es);
    }
}
