/**
 * 测试 H2 Tcp Server
 */
package com.yew1eb.h2.server;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 说明：
 *
 * @author <a href="http://www.waylau.com">yew1eb.com</a> 2015年8月21日
 */
public class TcpServer {
	public TcpServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
        ArrayList<String> list = new ArrayList<String>();

        list.add("-tcp");
        list.add("-tcpPort");
        list.add("9092");
        
        // TCP server running at tcp://192.168.11.125:9092 (only local connections)
        org.h2.tools.Server.main(list.toArray(new String[list.size()]));
	}

}
