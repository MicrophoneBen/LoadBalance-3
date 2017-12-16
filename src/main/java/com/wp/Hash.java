package com.wp;

import java.util.ArrayList;

/**
 * @author 王萍
 * @date 2017/12/16 0016
 */
public class Hash {

    public static String getServer() {
        ArrayList<String> ipList = new ArrayList<>(IpWeight.ipList);
        int ipNumber = ipList.size();

        // 真实场景通过HttpServlet的getRemoteIp方法获取
        String remoteIp = "127.0.0.1";
        //这里只是简单的使用字符串的hashCode，真实情况下需要通过散列效果更好的哈希函数求hash。
        int hashCode = remoteIp.hashCode();
        int index = hashCode % ipNumber;

        return ipList.get(index);
    }
}
