package in.ineuron.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc : mysql :///supid";
		String userName = "root";
		String password = "Root12347";
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("connection eshtablished::" + connection.getClass().getName());
		Statement statement = connection.createStatement();
		String sqlSelectQuery = "select id , firstname , lastname , salary from Person";

		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		System.out.println("ID\t SNAME\t SCITY\t ");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstname = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			int salary = resultSet.getInt("salary");
			System.out.println(id + "\t" + firstname + "\t" + lastname + "\t" + salary);
		}
		resultSet.close();
		statement.close();
		connection.close();
		System.out.println("Closing the resources...");
	}
}
