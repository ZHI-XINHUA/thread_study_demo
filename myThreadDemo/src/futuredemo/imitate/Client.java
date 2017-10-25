package futuredemo.imitate;

/**
 * Created by zhixinhua on 17/10/25.
 *
 * 客户端
 */
public class Client {
    //客户端请求数据
    public Data request(final String param){
        final FutureData futureData =  new FutureData();
        new Thread(){
            @Override
            public void run() {
                //RealData构造很耗时，故用线程进行
                RealData realData = new RealData(param);
                futureData.setRealData(realData);
            }
        }.start();
        return futureData;
    }


    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("test");
        System.out.println("请求完成");
        System.out.println("这是一个很耗时的请求操作");
        try{
            System.out.println("继续处理其它任务！");
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("返回真实数据："+data.getResult());
    }
}
