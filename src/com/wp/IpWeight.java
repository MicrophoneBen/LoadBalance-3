package com.wp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 王萍
 * @date 2017/12/16 0016
 */

public class IpWeight {

    /**
     * Key代表Ip，Value代表该Ip的权重
     */
    public static HashMap<String, Integer> ipWeightMap = new HashMap<>();
    public static ArrayList ipList = new ArrayList<String>();

    static {
        ipWeightMap.put("192.168.44.1", 1);
        ipWeightMap.put("192.168.44.2", 1);
        ipWeightMap.put("192.168.44.3", 4);
        ipWeightMap.put("192.168.44.4", 1);
        ipWeightMap.put("192.168.44.5", 1);
        ipWeightMap.put("192.168.44.6", 3);
        ipWeightMap.put("192.168.44.7", 1);
        ipWeightMap.put("192.168.44.8", 2);
        ipWeightMap.put("192.168.44.9", 1);
        ipWeightMap.put("192.168.44.10", 1);
        
        ipList.add("192.168.44.1");
        ipList.add("192.168.44.2");
        ipList.add("192.168.44.3");
        ipList.add("192.168.44.4");
        ipList.add("192.168.44.5");
        ipList.add("192.168.44.6");
        ipList.add("192.168.44.7");
        ipList.add("192.168.44.8");
        ipList.add("192.168.44.9");
        ipList.add("192.168.44.10");
    }
}
