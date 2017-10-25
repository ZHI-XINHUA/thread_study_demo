package futuredemo.imitate;

/**
 * Created by zhixinhua on 17/10/25.
 *
 * RealData是最终需要获取使用的数据模型
 */
public class RealData implements Data {
    protected String result;

    public RealData(String param){
        //RealData的构造很慢，模拟获取真实数据耗时操作，让用户等待好久
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<10;i++){
            sb.append(param);
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        this.result = sb.toString();
    }

    public String getResult(){
        return this.result;
    }
}
