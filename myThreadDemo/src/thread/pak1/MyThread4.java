package thread.pak1;

/**
 * Created by zhixinhua on 17/9/4.
 */
public class MyThread4  extends Thread{
    @Override
    public void run() {

            System.out.println("Priority="+this.getPriority());

    }
}
