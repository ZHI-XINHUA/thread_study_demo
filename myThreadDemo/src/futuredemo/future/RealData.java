package futuredemo.future;

import java.util.concurrent.Callable;

/**
 * Created by zhixinhua on 17/10/25.
 */
public class RealData implements Callable<String>{

    private String para;

    public RealData(String para){
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<10;i++){
            sb.append(this.para);
            Thread.sleep(100);
        }
        return sb.toString();
    }
}
