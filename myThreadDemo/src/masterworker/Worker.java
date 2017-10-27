package masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zhixinhua on 17/10/27.
 */
public class Worker implements  Runnable {
    //存放任务队列
    private ConcurrentLinkedQueue<Task> workQueue;
    //存放处理结果
    private ConcurrentHashMap<String,Object> resultMap;

    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true){
            Task input = this.workQueue.poll();//任务队列中获取任务
            if(input==null) break;
            Object output = handle(input);
            this.resultMap.put(input.getId(),output);
        }
    }

    //任务业务处理
    private Object handle(Task input){
        Object output = null;
        try{
            Thread.sleep(500);//模拟耗时
            output = input.getPrice();
        }catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }


}
