package com.json_server.generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 * 
 * @author Anusha
 *
 */
public class DataBaseUtilities {

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static Connection connectToDataBase() {
		Connection connection;
//		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/json-server", "root", "root");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * getDataFromDB method to retrieve data from database as key value pairs
	 * 
	 * @param query
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static LinkedHashMap getDataFromDB(String query) {
		Connection con = null;
		LinkedHashMap data = new LinkedHashMap();

		try {
			con = connectToDataBase();

			// executing the query
			ResultSet result = con.createStatement().executeQuery(query);

			ResultSetMetaData resMetaData = result.getMetaData();
			for (int i = 0; i < resMetaData.getColumnCount(); i++) {
				data.put(resMetaData.getColumnName(i), result.getString(i));
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
