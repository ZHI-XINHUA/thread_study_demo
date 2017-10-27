package package3;

/**
 * Created by zhixinhua on 17/10/27.
 */
public class Task implements Runnable {

    private String taskName;
    public Task(String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("taskName="+taskName  +"    当前线程名称:"+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
