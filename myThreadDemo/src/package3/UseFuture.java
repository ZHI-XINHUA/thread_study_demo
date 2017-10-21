package package3;

import java.util.concurrent.*;

/**
 * Created by zhixinhua on 17/10/14.
 */
public class UseFuture implements Callable<String >{
    private String name;

    public UseFuture(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("处理中.....");
        Thread.sleep(5000);
        return this.name+"处理完成！";
    }

    public static void main(String[] args) throws  Exception{
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<String> futureTask = new FutureTask<String>(new UseFuture("zhangshang"));

        Future f = executor.submit(futureTask);
        System.out.println(f.get());
        System.out.println(futureTask.get());

        executor.shutdown();
    }
}
