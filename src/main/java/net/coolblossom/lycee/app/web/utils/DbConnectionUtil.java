package net.coolblossom.lycee.app.web.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnectionUtil {

	private static boolean isInitialized = false;

	private DbConnectionUtil() { }

	private static synchronized void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (!isInitialized) {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}
	}


	public static Connection connect() throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		initialize();
		String url = SystemProperties.getOrDefault("mysql.url", "jdbc:mysql://localhost:3306/ars_library?serverTimezone=JST&characterEncoding=UTF-8");
		String user = SystemProperties.getOrDefault("mysql.user", "root");
		String password = SystemProperties.getOrDefault("mysql.password", "password1!");




		return DriverManager.getConnection(url, user, password);
	}



}
