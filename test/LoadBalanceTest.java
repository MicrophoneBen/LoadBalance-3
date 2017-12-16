import com.wp.Hash;
import com.wp.Polling;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 王萍
 * @date 2017/12/16 0016
 */
public class LoadBalanceTest {

    @Test
    public void testPolling() throws InterruptedException {

        //单线程环境
//        for (int i = 0; i < 30; i++) {
//            System.out.println(Polling.getServer());
//        }

        //多线程环境
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 300; i++) {
            executor.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
//                        System.out.println(Polling.getServer());
                        System.out.println(Hash.getServer());
                    }
                }
            }));
        }
        Thread.sleep(10000);
        System.out.println(Polling.getCount());
    }
}
