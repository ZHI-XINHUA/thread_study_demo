package thread.pak1;

/**
 * Created by zhixinhua on 17/8/27.
 */
public class MyThread1 implements  Runnable
{
    @Override
    public void run() {
        System.out.println("run="+Thread.currentThread().getName());
    }
}
