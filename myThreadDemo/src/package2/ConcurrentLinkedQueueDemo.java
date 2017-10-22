package package2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zhixinhua on 17/10/19.
 */

/**
 * ConcurrentLinkedQueue：是一个使用鱼高并发场景下的队列，通过无锁的方式，实现来高并发状态下的高性能，
 * 通常ConcurrentLinkedQueue性能好于BlockingQueue。它是一个基于链接节点的无界线程安全队列。该队列
 * 的元素遵循先进先出的原则，该队列不允许null元素
 *
 *  add()和offer()都是加入元素的方法（在ConcurrentLinkedQueue中没有任务区别）
 *  pool()和peek()都是取头节点，区别在于前者会删除元素，后者不会
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        //高性能无阻塞无解队列(先进先出)
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.offer("d");//添加元素
        q.add("f");//添加元素

        System.out.println(q.size());
        System.out.println(q.poll());//从头部去元素，并删除
        System.out.println(q.size());
        System.out.println(q.peek());//从头部去元素，不删除
        System.out.println(q.size());

        System.out.println( q.contains("b"));

        Iterator<String > iterator = q.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
