package package3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhixinhua on 17/10/27.
 */
public class ThreadPoolDemo {

    /**
     *  方法返回一个固定数量的线程池，该线程池中的线程数量始终不变。当又一个新的任务提交时，线程池中如有空闲线程，则立即执行。
     若没有，则新的任务会被暂存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务。
     */
    public static void testNewFixedThreadPool(){
       ExecutorService executorService =  Executors.newFixedThreadPool(5);
       for(int i=0;i<10;i++){
           Task task = new Task("task"+i);
           executorService.submit(task);
       }
    }

    /**
     * 该方法返回只有一个线程的线程池，若多于一个任务被提交到该线程池，任务会被保存在一个任务队列中，待线程空闲，
     * 按先入先出的顺序执行队列中的任务
     */
    public static  void testNewSingleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            Task task = new Task("task"+i);
            executorService.submit(task);
        }
    }

    /**
     * 该方法返回一个可根据实际情况调整线程数量的线程池。线程池的数量不确定，但若有空闲线程可以复用，则会优先使用可复用的线程。
     * 若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。所有线程在当前任务执行完毕后，将返回线程池进行复用。
     */
    public static void testNewCacheThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            Task task = new Task("task"+i);
            executorService.submit(task);
        }
    }

    /**
     * 该方法返回一个ScheduledExecutorService对象，线程池大小为1.ScheduledExecutorService接口在ExecutorService接口上
     * 扩展了在给定时间执行某任务的功能，如在某个固定的延时之后执行，或者周期性执行某个任务。
     */
    public static void testNewSingleThreadScheduleExecutor(){
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(new Task("task1"),1,1, TimeUnit.SECONDS);
    }

    /**
     * 该方法也返回一个ScheduledExecutorService对象，但该线程池可以指定线程数量
     */
    public static  void testNewScheduleExecutor(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
        for(int i=0;i<10;i++){
            Task task = new Task("task"+i);
            ses.scheduleWithFixedDelay(new Task("task1"),1,1, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) {
        //testNewFixedThreadPool();
        //testNewSingleThreadExecutor();
        //testNewCacheThreadPool();
        //testNewSingleThreadScheduleExecutor();
        testNewScheduleExecutor();
    }
}
