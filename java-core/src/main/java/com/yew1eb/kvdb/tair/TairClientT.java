package com.yew1eb.kvdb.tair;

import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.ResultCode;
import com.taobao.tair.impl.DefaultTairManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhai
 * @createTime 16/6/25
 * @description
 */
public class TairClientT {
    private static final String SERVER_IP = "192.168.2.100";
    private static final String PORT = "5198";

    public static void main(String[] args) {

        // 创建config server列表
        List<String> configServers = new ArrayList<String>();
        configServers.add(SERVER_IP + ":" + PORT);

        // 创建客户端实例
        DefaultTairManager tairManager = new DefaultTairManager();
        tairManager.setConfigServerList(configServers);

        // 设置组名
        tairManager.setGroupName("group_1");
        // 初始化客户端
        tairManager.init();

        // put 10 items
        for (int i = 0; i < 10; i++) {
            // 第一个参数是namespace，第二个是key，第三是value，第四个是版本，第五个是有效时间
            ResultCode result = tairManager.put(0, "k" + i, "v" + i, 0, 10);
            System.out.println("put k" + i + ":" + result.isSuccess());
            if (!result.isSuccess())
                break;
        }

        // get one
        // 第一个参数是namespce，第二个是key
        Result<DataEntry> result = tairManager.get(0, "a");
        System.out.println(result);
        System.out.println("get:" + result.isSuccess());
        if (result.isSuccess()) {
            DataEntry entry = result.getValue();
            if (entry != null) {
                // 数据存在
                System.out.println("value is " + entry.getValue().toString());
            } else {
                // 数据不存在
                System.out.println("this key doesn't exist.");
            }
        } else {
            // 异常处理
            System.out.println(result.getRc().getMessage());
        }

    }
}
