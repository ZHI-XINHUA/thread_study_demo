package package2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zhixinhua on 17/10/19.
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
