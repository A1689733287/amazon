package com.gpg.amazon.util;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
	private static DataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	public static Connection getConnection() {
		Connection conn = THREAD_LOCAL.get();
		try {
			if (conn == null) {
				conn = dataSource.getConnection();
				THREAD_LOCAL.set(conn);
			}
		} catch (Exception e) {
		}
		return null;

	}

	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}

}
