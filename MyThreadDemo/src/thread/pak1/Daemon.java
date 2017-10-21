package thread.pak1;

/**
 * Created by zhixinhua on 17/9/17.
 */
public class Daemon {
    public static class DaemonT extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("i am alive");
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }

    public static void main(String[] args)  throws  Exception{
        Thread t = new DaemonT();
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }
}
