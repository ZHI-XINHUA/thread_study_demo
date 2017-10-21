package package3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhixinhua on 17/10/10.
 */
public class DeathLock implements Runnable {

    public  static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;
    public DeathLock( int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if(this.lock==1){
                lock1.lockInterruptibly();
                try{
                    Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
                System.out.println("exec lock=1");
            }else {
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
                System.out.println("exec lock=2");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
            if(lock1.isHeldByCurrentThread()){
                System.out.println("lock1");
               lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                System.out.println("lock2");
                lock2.unlock();
            }


            System.out.println(Thread.currentThread().getId()+":线程退出");
        }
    }

    public static void main(String[] args)  throws  Exception{
        DeathLock d1 = new DeathLock(1);
        DeathLock d2 = new DeathLock(2);

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();


        Thread.sleep(1000);



        t2.interrupt();

        //System.out.println();
    }
}
