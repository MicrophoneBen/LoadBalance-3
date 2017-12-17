package com.wp;

import java.util.*;
import java.util.Random;

/**
 * @author 王萍
 * @date 2017/12/17 0017
 * 加权随机
 */
public class WeightRandom {

    //先根据权值得到列表，然后随机获取下标。
    public static String getServer() {

        HashMap<String, Integer> ipWeightMap = new HashMap<>(IpWeight.ipWeightMap);
        ArrayList<String> ipList = new ArrayList<>();

        for (String ip : ipWeightMap.keySet()) {
            Integer weight = ipWeightMap.get(ip);
            for (int i = 0; i < weight; i++) {
                ipList.add(ip);
            }
        }
        int ipNumber = ipList.size();
        Random random = new Random();
        return ipList.get(random.nextInt(ipNumber));
    }
}
