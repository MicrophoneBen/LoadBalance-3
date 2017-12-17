package com.wp;

import java.util.ArrayList;

/**
 * @author 王萍
 * @date 2017/12/16 0016
 * 随机法
 */
public class Random {

    public static String getServer() {

        ArrayList<String> ipList = new ArrayList<>(IpWeight.ipList);
        int ipNumber = ipList.size();
        java.util.Random random = new java.util.Random();
        //随机选择一个下标值
        int index = random.nextInt(ipNumber);
        return ipList.get(index);
    }
}
