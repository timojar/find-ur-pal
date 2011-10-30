import java.io.*;
import java.sql.*;
import java.util.ArrayList;
public class Actions {
	public Connection conn = null;
	public String url = "jdbc:mysql://localhost:3306/";
	public String dbName = "temp";
	public String driver = "com.mysql.jdbc.Driver";
	public String userName = "root";
	public String password = "saloni";
	ResultSet rs = null;
	public boolean selectConnections(String num1,String num2)
	{
		String query = "select * from connections where personA = " + num1 + " and personB = " + num2;
		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			conn.close();
			System.out.println("Disconnected from database");
			if(rs != null)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<String> selectFollow(String num)
	{
		String query = "select personA from follow where personB = " + num;
		ArrayList<String> s = new ArrayList<String>();
		//String [] numA = null;
		//int i = 0;
		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			System.out.println("Disconnected from database");
			while(rs.next())
			{
				s.add(rs.getString("personA"));
				//numA[i] = rs.getString("personA");
				//i++;
				//System.out.println(rs.getString("personA"));
				//return true;
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	public void updateConnections(String num1,String num2)
	{
		String query = "insert into connections (personA,personB) values (" + num1 + "," + num2 + ")";
		try
		{
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
		//a.updateFollow("1","9868224419");
		//a.updateFollow("2","9868224419");
		//a.updateFollow("3","9868224419");
		//a.updateConnections("9968379126", "9868224419");
		//String [] s = null;
		ArrayList<String> s = a.selectFollow("9868224419");
		for(int i = 0; i < s.size(); i++)
			System.out.println(s.get(i));
	}

}
