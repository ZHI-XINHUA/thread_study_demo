package package3;

import java.util.concurrent.*;

/**
 * Created by zhixinhua on 17/10/17.
 */
public class UseThreadPoolExecutor1 {

    public static void main(String[] args) throws Exception{
        //arrayBlockingQueue();
        linkedBlockingQueue();

//        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
//        ExecutorService executor  = new ThreadPoolExecutor(
//                5,
//                10,
//                120L,
//                TimeUnit.SECONDS,
//                queue,new MyRejected());
//
//        for(int i = 0 ; i < 22; i++){
//            executor.execute(new MyTask(i,"name"+i));
//        }
//        Thread.sleep(1000);
//        System.out.println("queue size:" + queue.size());		//10
//        Thread.sleep(2000);
    }


    //有界任务队列
    public static void arrayBlockingQueue(){
        /**
         * 在使用有界队列时，若有新的任务需要执行，如果线程池实际线程数小于corePoolSize，则优先创建线程，
         * 若大于corePoolSize，则会将任务加入队列，
         * 若队列已满，则在总线程数不大于maximumPoolSize的前提下，创建新的线程，
         * 若线程数大于maximumPoolSize，则执行拒绝策略。或其他自定义方式。
         *
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),//有序队列，被提交但未被执行的任务
                new MyRejected()//拒绝策略。当任务太多来不及处理，如何拒绝任务
        );

        MyTask m1 = new MyTask(1,"任务1");
        MyTask m2 = new MyTask(2,"任务2");
        MyTask m3 = new MyTask(3,"任务3");
        MyTask m4 = new MyTask(4,"任务4");
        MyTask m5 = new MyTask(5,"任务5");
        MyTask m6 = new MyTask(6,"任务6");

        pool.execute(m1);
        pool.execute(m2);
        pool.execute(m3);
        pool.execute(m4);
        pool.execute(m5);
        pool.execute(m6);

        pool.shutdown();
    }

    //无界任务队列
    public static void linkedBlockingQueue(){
        BlockingDeque queue = new LinkedBlockingDeque();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                2,
                60,
                TimeUnit.SECONDS,
                queue
        );
        MyTask m1 = new MyTask(1,"任务1");
        MyTask m2 = new MyTask(2,"任务2");
        MyTask m3 = new MyTask(3,"任务3");
        MyTask m4 = new MyTask(4,"任务4");
        MyTask m5 = new MyTask(5,"任务5");
        MyTask m6 = new MyTask(6,"任务6");

        pool.execute(m1);
        pool.execute(m2);
        pool.execute(m3);
        pool.execute(m4);
        pool.execute(m5);
        pool.execute(m6);

        pool.shutdown();
    }

   
}
