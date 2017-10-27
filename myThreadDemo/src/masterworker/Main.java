package masterworker;

import java.util.Random;

/**
 * Created by zhixinhua on 17/10/27.
 */
public class Main {
    public static void main(String[] args) {
        //初始化master
        Master master = new Master(new Worker(),20);

        Random r = new Random();
        for(int i=0;i<100;i++){
            Task task = new Task();
            task.setId(i+"");
            task.setPrice(r.nextInt(1000));
            //提交任务
            master.submit(task);
        }

        //执行任务
        master.execute();

        long start = System.currentTimeMillis();

        while(true){
            if(master.isComplete()){//判断是否完成
                long end = System.currentTimeMillis();
                int priceResult = master.getResult();//获取结果
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
                break;
            }
        }


    }
}
