package com.wzy.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCMysqlUtil {

	//连接数据库
	public static Connection getConnect() {
		Connection con = null;
		InputStream is = null;
		try {
			//在类加载的时候去获取路径
			is = JDBCMysqlUtil.class.getClassLoader().getResourceAsStream("jdbcMysql.properties");
			Properties p = new Properties();
			p.load(is);
			String Driver = p .getProperty("Driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			Class.forName(Driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
