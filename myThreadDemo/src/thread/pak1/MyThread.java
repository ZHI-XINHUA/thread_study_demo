package thread.pak1;

/**
 * Created by zhixinhua on 17/8/27.
 */
public class MyThread  extends Thread{


    @Override
    public void run() {

       for(int i=0;i<5000;i++){
           if(this.isInterrupted()){
               System.out.println("退出线程－－－－");
               break;
           }
           System.out.println("run--"+i);
       }


    }
}
