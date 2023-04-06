package com.zoho.FoodDelivery;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.io.FileReader;
import java.util.Properties;
final class Database
{
	private static FileReader fr=null;
	private static Properties p=new Properties();
	private static Connection con=null;
	private static String url=null;
	private static String user=null;
	private static String pass=null;
	static
	{
		try
		{
			fr=new FileReader("db_detail.properties");
		}
		catch(Exception e)
		{
			System.out.println("********File Not Found");
		}
		try
		{
			p.load(fr);
		}
		catch(Exception e)
		{
			System.out.println("********Property File Not Found");
		}
		url=p.getProperty("url");
		user=p.getProperty("user");
		pass=p.getProperty("pass");
		try
		{
		con=DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			System.out.println("********Database Not Found");
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
	/*public static void closeConnection() throws SQLException
	{
		if(con!=null)
			con.close();
	}*/
}
