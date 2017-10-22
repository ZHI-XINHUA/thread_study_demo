package package2;

import java.util.concurrent.DelayQueue;

/**
 * Created by zhixinhua on 17/10/21.
 * 网吧
 */
public class WangBa  implements Runnable {

    //DelayQueue队列
    /**
     * DelayQueue:带有延迟时间的Queue，其中的元素只有当其指定的延迟时间到了，才能
     * 够从队列中获取得到该元素。DelayQueue中的元素必须实现Delayed接口，DelayQueue是
     * 一个没有大小限制的队列。
     * 应用场景很多，比如对缓存超时的数据进行移除、任务超时处理、空闲连接的关闭等等
     */
    private DelayQueue<Wangmin> queue = new DelayQueue<Wangmin>();

    public boolean yinye = true;//营业

    /**
     * 上机
     * @param name
     * @param id
     * @param money
     */
    public  void  shangji(String id,String name,int money){
        Wangmin wangmin = new Wangmin(id,name,1000*money+System.currentTimeMillis());
        System.out.println("网名"+wangmin.getName()+" 身份证"+wangmin.getId()+"交钱"+money+"块,开始上机...");
        this.queue.add(wangmin);//添加队列
    }

    /**
     * 下机
     * @param wangmin
     */
    public void xiaji(Wangmin wangmin){
        System.out.println("网名"+wangmin.getName()+" 身份证"+wangmin.getId()+"时间到下机...");
    }

    @Override
    public void run() {
        while(yinye){
            try{
                Wangmin man = queue.take();//从队列中获取元素，只要元素中的延迟时间已到马上可以获取得到
                xiaji(man);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
