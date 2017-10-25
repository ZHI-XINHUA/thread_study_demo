package queuedemo;

/**
 * Created by zhixinhua on 17/10/22.
 */


public class DelayQueueDemo {
    public static void main(String[] args) {
        try{
            System.out.println("网吧开始营业");
            WangBa siyu = new WangBa();
            Thread shangwang = new Thread(siyu);
            shangwang.start();

            siyu.shangji("路人甲", "123", 1);
            siyu.shangji("路人乙", "234", 10);
            siyu.shangji("路人丙", "345", 5);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
