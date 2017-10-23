package package3;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhixinhua on 17/10/10.
 */

/**
 * ReentrantLock：重入锁可以完全替换synchronized关键字，重入锁的性能远远好于synchronized。
 *  lock()：获得锁，如果锁已经被占用，则等待
 *  lockInterruptibly()：获得锁，但优先响应中断
 *  tryLock()：尝试获得锁，如果成功，返回true，失败返回false。该方法不等待，立即返回
 *  tryLock(long time,TimeUnit unit)：在给定时间内尝试获得锁
 *  unlock()：释放锁
 */
public class ReenterLockDemo implements Runnable{
    //public static ReentrantLock lock = new ReentrantLock(true); 公平锁
    public static ReentrantLock lock = new ReentrantLock();

    public  static  int i =0;

    @Override
    public void run() {
        for (int j=0;j<1000000;j++){
           lock.lock();
            i++;
            lock.unlock();
        }
    }

    public static void main(String[] args)  throws Exception{
        ReenterLockDemo t = new ReenterLockDemo();

        Thread th1 = new Thread(t);
        Thread th2 = new Thread(t);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(i);

    }
}
