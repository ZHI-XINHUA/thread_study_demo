package package3;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhixinhua on 17/10/10.
 */
public class ReenterLock  implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    public  static  int i =0;

    @Override
    public void run() {
        for (int j=0;j<1000000;j++){
           // lock.lock();
            i++;
            //lock.unlock();
        }
    }

    public static void main(String[] args)  throws Exception{
        ReenterLock t = new ReenterLock();

        Thread th1 = new Thread(t);
        Thread th2 = new Thread(t);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(i);

    }
}
