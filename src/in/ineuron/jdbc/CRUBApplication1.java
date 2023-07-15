package in.ineuron.jdbc;

import java.sql.*;
import java.util.Scanner;

public class CRUBApplication1 {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/stupid";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "Root12347";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			System.out.println("Select an operation:");
			System.out.println("1. Add record");
			System.out.println("2. View records");
			System.out.println("3. Update record");
			System.out.println("4. Delete record");
			Scanner sc = new Scanner(System.in);
			int operation = sc.nextInt();
			switch (operation) {
			case 1:
				addRecord(conn);
				break;
			case 2:
				viewRecords(conn);
				break;
			case 3:
				updateRecord(conn);
				break;
			case 4:
				deleteRecord(conn);
				break;
			default:
				System.out.println("Invalid operation selected.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addRecord(Connection conn) throws SQLException {

		System.out.println("Enter record details:");
		System.out.print("Name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		String sql = "INSERT INTO mytable (name, email) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setString(2, email);

			int rowsAffected = stmt.executeUpdate();
			System.out.println(rowsAffected + " record(s) added.");
		}
	}

	private static void viewRecords(Connection conn) throws SQLException {

		String sql = "SELECT * FROM mytable";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Email: " + email);
				System.out.println();
			}
		}
	}

	private static void updateRecord(Connection conn) throws SQLException {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("Enter the record ID to update: ");
		int id = scan1.nextInt();

		System.out.println("Enter new record details:");
		System.out.print("Name: ");
		String name = scan1.nextLine();
		System.out.print("Email: ");
		String email = scan1.nextLine();

		String sql = "UPDATE mytable SET name = ?, email = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setInt(3, id);

			int rowsAffected = stmt.executeUpdate();
			System.out.println(rowsAffected + " record(s) updated.");
		}
	}

	private static void deleteRecord(Connection conn) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the record ID to delete: ");
		int id = scan.nextInt();

		String sql = "DELETE FROM mytable WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);

			int rowsAffected = stmt.executeUpdate();
			System.out.println(rowsAffected + " record(s) deleted.");
		}
	}
}
