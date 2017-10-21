package thread.pak1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhixinhua on 17/10/9.
 */
public class ArrayListThread {
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<1000000;i++)
                list.add(i);
        }
    }

    public static void  main(String[] args) throws  Exception{
        //Thread thread1 = new Thread(new AddThread());
        //Thread thread2 = new Thread(new AddThread());
        //thread1.start();
       // thread2.start();
        //thread1.join();
       // thread2.join();
        ArrayList list1 = new ArrayList(10);
        for (int i=0;i<15;i++)
            list1.add(i);

        ArrayList list2 = (ArrayList) list1.clone();
        for (int i=0;i<list2.size();i++)
         System.out.println(list2.get(i));


    }
}
