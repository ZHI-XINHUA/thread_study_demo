package thread.pak1;

/**
 * Created by zhixinhua on 17/8/27.
 */
public class MyThread3 extends Thread {
    private  int i =10000;

    public MyThread3(String name){
        super();
        this.setName(name);
    }
    @Override
    public void run() {
        super.run();
        for (int i=0;i<50000;i++){
            System.out.println("run-"+i);
        }
    }
}
