package com.wp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王萍
 * @date 2017/12/16 0016
 */

/**
 * 轮询算法
 */
public class Polling {

    /**
     * 保证多线程下变量++操作的原子性
     */
    private static AtomicInteger count = new AtomicInteger(0);
    //下面写法会出现线程安全问题
    //private static int count = 0;

    public static String getServer() {

        //装到list中可以按下标获取元素
        ArrayList<String> ipList = new ArrayList<>(IpWeight.ipList);
        int ipNumber = ipList.size();

        return ipList.get(count.getAndIncrement() % ipNumber);
    }

    public static int getCount() {
        return count.get();
    }
}
