package thread.pak1;

/**
 * Created by zhixinhua on 17/9/17.
 */
public  class PlusTask  {

    static  volatile int i=0;
    static Object o = new Object();
    public static class PlusTask1   implements Runnable {



        public void run(){
           // synchronized (o){
                for (int k=0;k<10000;k++){

                        i++;


                }
           // }

        }
    }

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i]= new Thread(new PlusTask1());
            threads[i].start();
            //threads[i].join();

        }
        for (int i=0;i<10;i++){

        }
        System.out.println(i);
    }

}

