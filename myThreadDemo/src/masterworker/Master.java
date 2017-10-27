package masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zhixinhua on 17/10/27.
 */
public class Master {
    //1、存放任务队列容器
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
    //2、存放worker任务集合
    private HashMap<String,Thread> workers = new HashMap<String,Thread>();
    //3、存放每个worker执行任务的结果集合
    private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<String,Object>();

    //4、构造方法，设置worker的任务队列和结果集合
    public Master(Worker worker,int workerCount){
        worker.setWorkQueue(this.workQueue);//指向master的任务队列容器
        worker.setResultMap(this.resultMap);;//指向master的结果集合

        //worker添加到map中
        for(int i=0;i<workerCount;i++){
            this.workers.put(Integer.toString(i),new Thread(worker));
        }

    }

    /**
     * 5、提交任务的方法
     * @param task
     */
    public void submit(Task task){
        this.workQueue.add(task);
    }

    /**
     * 6、执行方法：启动所有的worker方法执行任务
     */
    public void execute(){
        for(Map.Entry<String,Thread> worker : workers.entrySet()){
            worker.getValue().start();//启动任务
        }
    }

    /********* 做归纳和总结 *********/
    /**
     * 7、判断是否运行完成结果的方法
     * @return
     */
    public boolean isComplete(){
        for(Map.Entry<String,Thread> worker : workers.entrySet()){
            if(worker.getValue().getState()!= Thread.State.TERMINATED){
                return false;
            }

        }
        return true;
    }

    /**
     * 8、计算结果
     * @return
     */
    public int getResult(){
        int priceResult = 0;
        for(Map.Entry<String,Object> result : this.resultMap.entrySet()){
            priceResult += (Integer) result.getValue();
        }
        return priceResult;
    }
}
