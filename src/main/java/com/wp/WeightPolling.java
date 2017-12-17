package com.wp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王萍
 * @date 2017/12/17 0017
 */
public class WeightPolling {
    private static AtomicInteger count = new AtomicInteger(0);

    public static String getServer() {
        HashMap<String, Integer> ipWeightMap = new HashMap<>(IpWeight.ipWeightMap);
        ArrayList<String> ipList = new ArrayList<>();
        //这里每次都遍历map获取weight效率很低，可以做一个ipList的缓存，监听服务器注册列表的变化。
        for (String ip : ipWeightMap.keySet()) {
            Integer weight = ipWeightMap.get(ip);
            for (int i = 0; i < weight; i++) {
                ipList.add(ip);
            }
        }
        int ipNumber = ipList.size();
        return ipList.get(count.getAndIncrement() % ipNumber);
    }
}
