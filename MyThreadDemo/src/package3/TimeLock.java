package package3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**610/10.
 */
public class TimeLock implements  Runnable {
    public  static ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try{
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else{
                System.out.println(Thread.currentThread().getName()+" get lock failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLock t1 = new TimeLock();
        TimeLock t2 = new TimeLock();

        Thread th1 = new Thread(t1,"t1");
        Thread th2 = new Thread(t2,"t2");

        th1.start();
        th2.start();
    }
}
