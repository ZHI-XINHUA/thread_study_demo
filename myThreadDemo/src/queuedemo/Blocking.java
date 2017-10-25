package queuedemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhixinhua on 17/10/19.
 */
public class Blocking {

    public static void main(String[] args) throws  Exception{
        ArrayBlockingQueueDemo();
        //LinkedBlockingQueueDemo();
        //PriorityBlockingQueueDemo();
    }

    /**
     * ArrayBlockingQueue:基于数组的阻塞队列实现，在ArrayBlockingQueue内部为何一个
     * 定长数组，以便缓存队列中的数据对象，其内部实现读写分离，也就意味着生产和消费不能完全并行，
     * 长度是需要定义的，可以指定先进先出或者先进后出，也叫有界队列。
     * @throws Exception
     */
    public  static  void ArrayBlockingQueueDemo() throws Exception{
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(5);

        q.add("a");
        q.put("b");
        q.offer("c");
        q.put("e");
        q.add("f");

        //添加到队列中，2秒后添加不进去返回false     阻塞队列
        boolean isCanAdd = q.offer("g",2, TimeUnit.SECONDS);
        System.out.println(isCanAdd);

        System.out.println(q.poll());//从头部去元素，并删除

        System.out.println("poll()从头部去元素，并删除后的队列==========");
        Iterator i = q.iterator();
        while (i.hasNext()){
            System.out.print(i.next());
        }
    }

    //无界队列

    /**
     * 基于链表的阻塞队列，同ArrayBlockingQueue类似，其内部也维持着一个数据缓冲队列（该队列由一个链表构成），LinkedBlockbingQueue
     * 之所以能够高效的处理并发数据，是因为其内部实现采用分离锁（读写分离两个锁），从而实现生产者和消费者操作的完全并行运行，
     * 是一个无界队列
     * @throws Exception
     */
    public static  void LinkedBlockingQueueDemo() throws Exception{
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
        q.put("a");
        q.add("b");
        q.offer("c");
        q.offer("d",2,TimeUnit.SECONDS);

        for (Iterator i = q.iterator();i.hasNext();){
            System.out.println(i.next());
        }
        System.out.println("===============");
        List<String> list = new ArrayList<String>();
        list.add("begin");
        int lsize =  q.drainTo(list,3);//去q前3个元素放到list中
        System.out.println(lsize);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * PriorityBlockingQueue：基于优先级的阻塞队列（有限级的判断通过构造函数传入的Compator对象来决定，也就是
     * 说传入队列的对象必须实现Comparable接口），在实现PriorityBlockingQueue时，内部控制线程同步的锁采用的是
     * 公平锁，他也是一个无界的队列
     * @throws Exception
     */
    public static  void PriorityBlockingQueueDemo() throws Exception{
        PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();

//        Task t1 = new Task(2,"task2");
//        Task t2 = new Task(5,"task5");
//        Task t3 = new Task(1,"task1");
//        Task t4 = new Task(4,"task4");
//        Task t5 = new Task(3,"task3");
//        q.add(t1);
//        q.add(t2);
//        q.add(t3);
//        q.add(t4);
//        q.add(t5);
        for(int i=0;i<20;i++){
            int r = new Random().nextInt(100);
            Task t = new Task(r,"name"+r);

            q.add(t);
        }

        System.out.println(q);
        Task task = q.take();//获取排序后第一个,take一次排序一次
        System.out.println(task.getId()+"="+task.getName());
        System.out.println(q);
    }
}
