package in.ineuron.jdbc;

import java.sql.*;

public class CRUDApplication {

	// Database connection details
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/stupid";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root12347";

	// Database table details
	private static final String TABLE_NAME = "Child";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_AGE = "age";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			createTable(connection);

			// Add records
			addRecord(connection, "John Doe", 25);
			addRecord(connection, "Jane Smith", 30);

			// View all records
			viewAllRecords(connection);

			// Update a record
			updateRecord(connection, 1, "John Doe Jr.", 26);

			// View all records again
			viewAllRecords(connection);

			// Delete a record
			deleteRecord(connection, 2);

			// View all records again
			viewAllRecords(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createTable(Connection connection) throws SQLException {
		String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + COLUMN_ID
				+ " INT AUTO_INCREMENT PRIMARY KEY," + COLUMN_NAME + " VARCHAR(100) NOT NULL," + COLUMN_AGE + " INT)";

		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(createTableQuery);
			System.out.println("Table created successfully");
		}
	}

	private static void addRecord(Connection connection, String name, int age) throws SQLException {
		String insertQuery = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_AGE + ") VALUES (?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.executeUpdate();
			System.out.println("Record added successfully");
		}
	}

	private static void viewAllRecords(Connection connection) throws SQLException {
		String selectQuery = "SELECT * FROM " + TABLE_NAME;

		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(selectQuery)) {

			System.out.println("ID\tName\t\tAge");
			while (resultSet.next()) {
				int id = resultSet.getInt(COLUMN_ID);
				String name = resultSet.getString(COLUMN_NAME);
				int age = resultSet.getInt(COLUMN_AGE);
				System.out.println(id + "\t" + name + "\t\t" + age);
			}
		}
	}

	private static void updateRecord(Connection connection, int id, String name, int age) throws SQLException {
		String updateQuery = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + " = ?, " + COLUMN_AGE + " = ? WHERE "
				+ COLUMN_ID + " = ?";

		try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setInt(3, id);
			statement.executeUpdate();
			System.out.println("Record updated successfully");
		}
	}

	private static void deleteRecord(Connection connection, int id) throws SQLException {
		String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";

		try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("Record deleted successfully");
		}
	}
}
