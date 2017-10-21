package thread.pak1;

/**
 * Created by zhixinhua on 17/9/17.
 */
public class JoinMain {
    public volatile static int i=0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for ( i=0;i<100;i++){

            }
        }
    }

    public static class AddThread2 extends Thread{
        int a = 0;
        @Override
        public void run() {
            for ( a=0;a<1000000;a++){

            }
            System.out.println("a="+a);
        }
    }

    public static class AddThread1 extends Thread{
        @Override
        public void run() {
            Thread.yield();
            AddThread at = new AddThread();
            at.start();
            try{
                at.join();
            }catch (Exception e){

            }

            System.out.println("AddThread1");
            System.out.println(i);
        }
    }



    public static void main(String[] args) throws  Exception{
        AddThread2 at2 = new AddThread2();
        at2.start();
        AddThread1 at = new AddThread1();
        at.start();
        at.join();
        //at.join();
        //System.out.println(i);
        System.out.println("main");
    }
}
