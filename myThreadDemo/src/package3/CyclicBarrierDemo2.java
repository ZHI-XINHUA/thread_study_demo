package package3;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhixinhua on 17/10/12.
 */

/**
 * CyclicBarrier:和CountDownLatch非常类似，它也可以实现线程间的计数等待，但它的功能比CountDownLatch更加复杂且强大。
 * Cyclic意为循环，也就是说这个计数器可以反复使用。比如，假设我们将计数器设置为10，那么凑齐第一批10个线程后，计数器就会归零，
 * 然后接着凑齐下一批10个线程，这就是循环栅栏内在的含义。（如：跑步，9个人准备好后一抢令下一起起跑；接着下一批开始）
 */
public class CyclicBarrierDemo2 {
    public static class Soldier implements  Runnable{
        private String soldier;
        private final CyclicBarrier barrier;

        public Soldier(String soldier,CyclicBarrier barrier){
            this.soldier = soldier;
            this.barrier = barrier;
        }

        public void  run(){
            try{
                this.barrier.await();//等待所有士兵到齐
                Thread.sleep(1000*(new Random().nextInt(5)));
                System.out.println(this.soldier+" ：任务完成");
                this.barrier.await();//等待所有士兵完成工作

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public static class  BarrierRun implements  Runnable{

        boolean flag;
        int n;
        int count = 0;

        public  BarrierRun(boolean flag,int n){
            this.flag = flag;
            this.n = n;
        }


        @Override
        public void run() {
            count++;
            if(flag){
                System.out.println("司令：第"+this.n+"个，任务完毕");
            }else{
                System.out.println("司令：第"+this.n+"个，集合完毕");
                flag = true;
            }
            System.out.println("count="+count);
        }
    }

    public static void main(String[] args) throws  Exception{
        final int n =10;
        Thread[] allSolier = new Thread[n];
        boolean flag = false;
        CyclicBarrier barrier = new CyclicBarrier(n,new BarrierRun(flag,n));

        System.out.println("集合队伍！！！！");

        for (int i=0;i<n;i++){
            System.out.println("［士兵"+i+"］报道");
            allSolier[i] = new Thread(new Soldier("［士兵"+i+"］",barrier));
            allSolier[i].start();
        }
    }
}
