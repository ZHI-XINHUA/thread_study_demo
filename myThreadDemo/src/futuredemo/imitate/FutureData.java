package futuredemo.imitate;

/**
 * Created by zhixinhua on 17/10/25.
 * FutureData是Future模式的关键，它实际上是真实数据RealData的代理，封装了获取Realata的等待过程
 */
public class FutureData implements Data {


    private RealData realData;  //FutureData是RealData的包装
    private boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if(this.isReady)
            return;
        this.realData = realData;
        this.isReady = true;
        notifyAll();  //RealData被注入，通知getResult
    }
    public synchronized  String getResult(){
        while (!isReady){
            try{
                wait();//一直等待，直到RealData被注入
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return this.realData.result;  //由RealData实现
    }
}
