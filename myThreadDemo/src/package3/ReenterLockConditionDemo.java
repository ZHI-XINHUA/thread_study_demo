package package3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhixinhua on 17/10/23.
 */

/**
 * Condition:它和wait()和notify()方法的作用大致相同，但是wait()和notify()是和synchronized关键字合作使用，
 * 而Condition是与重入锁相关联的。
 * await():方法会使当前线程等待，同时释放当前锁，当其他线程使用signal()或signalAll()方法时，线程会重现获取锁并继续执行。
 * 或者当前线程被中断时，也就能跳出等待。者和Object.wait()很相似
 * awaitUninterruptibly():与await()基本相同，但是它并不会在等待过程中响应中断
 * signal():唤醒一个在等待中的线程，这和Object.notify()很类似
 * signalAll():唤醒所有在等待中的线程
 */
public class ReenterLockConditionDemo implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try{
           lock.lock();
           condition.await();//使当前线程等待
           Thread.sleep(2000);
            System.out.println("thread is going on");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws  Exception{
        ReenterLockConditionDemo reenterLockCondition = new ReenterLockConditionDemo();
        Thread t = new Thread(reenterLockCondition);
        t.start();

        //通知线程t继续执行
        lock.lock();
        condition.signal(); //唤醒一个在等待中的线程
        lock.unlock();


    }
}
