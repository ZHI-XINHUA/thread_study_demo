package package3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhixinhua on 17/10/23.
 */

/**
 * 读读(非阻塞)、读写(阻塞)、写写(阻塞)
 *
 * 以下demo，不用读写锁，要花费20秒。 使用读写锁，远小于花费20秒
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public int handleRead(Lock lock){
        try{
            lock.lock();//模拟读操作
            Thread.sleep(1000);//模拟耗时
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
        return this.value;
    }

    public void handleWrite(Lock lock,int index){
        try{
            lock.lock();
            Thread.sleep(1000);
            this.value = index;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

        //读线程
        Runnable readRunable = new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.handleRead(readLock);
               // readWriteLockDemo.handleRead(lock);
            }
        };

        //写线程
        Runnable writeRunable = new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.handleWrite(writeLock,new Random().nextInt(1000));
                //readWriteLockDemo.handleWrite(lock,new Random().nextInt(1000));
            }
        };

        for (int i=0;i<18;i++){
            new Thread(readRunable).start();
        }

        for (int i=18;i<20;i++){
            new Thread(writeRunable).start();
        }
    }
}
