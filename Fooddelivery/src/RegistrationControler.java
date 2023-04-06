package com.zoho.FoodDelivery;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.regex.*;
class RegistrationControler
{
	static Connection con=Database.getConnection();
	static Statement state=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static
	{
		try
		{
		state=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static LinkedHashMap<Integer,String> getRole() 
	{
		LinkedHashMap<Integer,String> hm=new LinkedHashMap<>();
		try
		{
			rs=state.executeQuery("SELECT id,rolename FROM userrole;");
			while(rs.next())
			{
				hm.put(rs.getInt(1),rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return hm;
		
	}
	public static int insertCustomerData(RegistrationModel rm)
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO userdetail(role,name,phoneno,mail)VALUES(?,?,?,?) RETURNING id");
			ps.setInt(1,rm.getRole());
			ps.setString(2,rm.getName());
			ps.setLong(3,rm.getPhoneno());
			ps.setString(4,rm.getMail());
			rs=ps.executeQuery();
			if(rs.next())
			return rs.getInt("id"); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
		
	}
	public static RegistrationModel isUser(String str)
	{
		String query="";
		RegistrationModel rm=null;
		if(Pattern.matches("[0-9]{10}",str))
			{
				long phoneno=Long.parseLong(str);
				query="phoneno="+phoneno+";";
			}
			else
			{
				query="mail='"+str+"';";
			}
		try
		{
			
			rs=state.executeQuery("SELECT ud.id,ud.name,ud.mail,ud.phoneno,ad.street,ad.state,ad.district,ad.city,s.state_name,d.district_name,c.city_name FROM userdetail ud JOIN address ad ON ud.id=ad.userid JOIN states s ON ad.state=s.id JOIN districts d ON ad.district=d.id JOIN cities c ON ad.city=c.id WHERE "+query);
			while(rs.next())
			{
				rm=new RegistrationModel(rs.getInt(1),rs.getString(2),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return rm;
	
	}
}
