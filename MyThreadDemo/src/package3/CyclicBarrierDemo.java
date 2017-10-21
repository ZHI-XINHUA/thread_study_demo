package package3;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhixinhua on 17/10/12.
 */
public class CyclicBarrierDemo implements  Runnable{

    private CyclicBarrier barrier;
    private String name;

    public CyclicBarrierDemo(CyclicBarrier barrier, String name){
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * ( new Random().nextInt(5)));
            System.out.println(this.name+" readly?");
            this.barrier.await();

            System.out.println(this.name+" go.....");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(new CyclicBarrierDemo(barrier,"zhangshan"));
        exec.submit(new CyclicBarrierDemo(barrier,"lisi"));
        exec.submit(new CyclicBarrierDemo(barrier,"wangwu"));

        exec.shutdown();
    }
}
