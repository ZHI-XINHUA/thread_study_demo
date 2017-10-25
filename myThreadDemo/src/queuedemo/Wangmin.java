package queuedemo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhixinhua on 17/10/22.
 * 网民实体类，实现Delayed类
 */
public class Wangmin  implements Delayed{
    private String id;//身份证
    private String name;//名称
    private long endTime;//截止时间

    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public Wangmin(String id,String name,long time){
        this.id = id;
        this.name = name;
        this.endTime = time;
    }

    /**
     * 排序比较
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed delayed) {
        Wangmin wangmin = (Wangmin) delayed;
        return this.getDelay(this.timeUnit)-wangmin.getDelay(wangmin.timeUnit)>0?1:0;
    }

    /**
     * 判断是否到了截止时间 t=0时候马上可以take获取到
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long t = this.endTime - System.currentTimeMillis();
        return t;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getEndTime() {
        return endTime;
    }
}
