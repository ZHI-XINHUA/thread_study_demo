package futuredemo.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by zhixinhua on 17/10/25.
 */
public class FutureMain {
    public static void main(String[] args) throws  Exception {
        //构造FutureTask
        FutureTask<String> future = new FutureTask<String>(new RealData("test"));

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);

        System.out.println("请求完毕");
        System.out.println("这是一个耗时的请求");
        System.out.println("继续执行其它任务");

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("请求返回真实数据＝" + future.get());


        executor.shutdown();

    }
}
