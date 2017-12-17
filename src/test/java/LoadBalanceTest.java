import com.wp.Hash;
import com.wp.Polling;
import com.wp.WeightPolling;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
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

        //测试Polling中直接使用int与使用AtomicInteger的对比。
        //System.out.println(Polling.getCount());
    }

    @Test
    public void testWeightPolling() {
        for (int i = 0; i < 32; i++) {
            System.out.println(WeightPolling.getServer());
        }
    }

    @Test
    public void testWithGroboutils() {
        //使用junit多线程测试工具groboutils。
        int threadCount = 300;
        try {
            //Runner数组，相当于并发多少个
            TestRunnable[] trs = new TestRunnable[threadCount];
            for (int i = 0; i < threadCount; i++) {
                trs[i] = new TestRunnable() {
                    @Override
                    public void runTest() throws Throwable {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Polling.getServer());
                        }
                    }
                };
            }
            // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
            MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
            // 开发并发执行数组里定义的内容
            mttr.runTestRunnables();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHash() {
        int threadCount = 300;
        try {
            TestRunnable[] trs = new TestRunnable[threadCount];
            for (int i = 0; i < threadCount; i++) {
                trs[i] = new TestRunnable() {
                    @Override
                    public void runTest() throws Throwable {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Hash.getServer());
                        }
                    }
                };
            }
            MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
            mttr.runTestRunnables();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
