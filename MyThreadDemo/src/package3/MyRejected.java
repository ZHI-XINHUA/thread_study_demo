package package3;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhixinhua on 17/10/17.
 */
public class MyRejected implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理..");
        System.out.println("当前被拒绝任务为：" + r.toString());
    }
}
