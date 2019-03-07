package com.bdqn.zmj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dbutil {

	//获取数据库连接
	public static Connection getConn() {
		try {
			Class.forName(ConfigMapper.get("driver"));
			String url = ConfigMapper.get("url");
			Connection conn = DriverManager.getConnection(url, ConfigMapper.get("username"), ConfigMapper.get("password"));
			
			//从jndi数据库连接池里面获取数据库连接
			//Context ctx = new InitialContext();
			//DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/news");
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭连接
	public static void close(Connection conn,PreparedStatement ppst) {
		try {
			if (conn!=null && !conn.isClosed()) {
				ppst.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement ppst,ResultSet rs) {
		try {
			rs.close();
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
