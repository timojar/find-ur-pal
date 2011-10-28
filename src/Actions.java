import java.io.*;
import java.sql.*;
public class Actions {
	public Connection conn = null;
	public String url = "jdbc:mysql://localhost:3306/";
	public String dbName = "temp";
	public String driver = "com.mysql.jdbc.Driver";
	public String userName = "root";
	public String password = "saloni";
	public void updateConnections(String num1,String num2)
	{
		//jdbcConnect();
		System.out.println("inside action1");
		String query = "insert into connections (personA,personB) values (" + num1 + "," + num2 + ")";
		try
		{
			System.out.println("inside try");
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
			System.out.println("Disconnected from database");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updateFollow(String num1, String num2)
	{
		System.out.println("inside action2");
		String query = "insert into follow (personA,personB) values (" + num1 + "," + num2 + ")";
		try
		{
			System.out.println("inside try");
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
			System.out.println("Disconnected from database");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updateLocation(String num,String place)
	{
		System.out.println("inside action2");
		String query = "insert into location (person,place) values (" + num + "," + place + ")";
		try
		{
			System.out.println("inside try");
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
			System.out.println("Disconnected from database");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		Actions a = new Actions();
		a.updateConnections("9968379126", "9868224419");
	}

}
