package com.zoho.FoodDelivery;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
final class DefaultValues
{
	static Connection con=null;
	static Statement state=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static void getDefaultValues()
	{
		if((con=Database.getConnection())!=null)
		{
		        FoodyTables.createFoodyTables();
			if(isTableExists("userrole")==0)
				setJobrole();
			if(isTableExists("userdetail")==0)
				setUserDetail();
			if(isTableExists("address")==0)
				setAddress();
			if(isTableExists("login")==0)
				setLogin();
			if(isTableExists("states")==0)
				setStates();
			if(isTableExists("districts")==0)
				setDistricts();
			if(isTableExists("cities")==0)
				setCities();
		}
	}
	public static int isTableExists(String table)
	{	
		int id=0;
		try
		{
			ps=con.prepareStatement("SELECT count(id) FROM "+table+";");
                 	rs=ps.executeQuery();
                 	rs.next();
                 	id=rs.getInt("count");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return id;
	}

	public static void setJobrole()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO userrole(rolename)VALUES('admin'),('foodie'),('food_shipper'),('hotelian');");
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setUserDetail()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO userdetail(role,name,phoneno,mail)VALUES(1,'karuppu',8987678978,'karuppu@gmail.com');");	
			ps.executeUpdate();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setAddress()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO address(userid,street,city,district,state)VALUES(1,'east',19,13,1);");	
			ps.executeUpdate();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setLogin()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO login(userid,password)VALUES(1,'foody@123');");
			ps.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setStates()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO states(state_name)VALUES('tamilnadu');");
			ps.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setDistricts()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO districts(district_name,state_id) VALUES ('Chennai', 1),('Coimbatore', 1),('Madurai', 1),('Tiruchirapalli', 1),('Salem', 1),('Tirunelveli', 1),('Vellore', 1),('Thoothukudi', 1),('Thanjavur', 1),('Kancheepuram', 1),('Tiruvallur', 1),('Dindigul', 1),('Virudhunagar', 1),('Krishnagiri', 1),('Kanyakumari', 1),('Thiruvannamalai', 1),('Namakkal', 1),('Pudukkottai', 1),('Nagapattinam', 1),('Dharmapuri', 1),('Ramanathapuram', 1),('Cuddalore', 1),('Karur', 1),('Perambalur', 1),('Nilgiris', 1),('Ariyalur', 1),('Tiruppur', 1);");		
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setCities()
	{
		try
		{
			ps=con.prepareStatement("INSERT INTO cities(city_name,district_id) VALUES ('Mylapore', 1),('Peelamedu', 2),('Anna Nagar', 1),('Thillai Nagar', 4),('Hasthampatti', 5),('Palayamkottai', 6),('Gandhinagar', 7),('Thoothukudi', 8),('Kumbakonam', 9),('Chengalpattu', 10),('Avadi', 11),('Oddanchatram', 12),('Sattur', 13),('Hosur', 14),('Nagercoil', 15),('Arni', 16),('Rasipuram', 17),('Karaikkudi', 18),('Srivilliputtur',13),('Sivakasi',13),('Rajapalayam',13),('Sirkali', 19),('Harur', 20),('Rameswaram', 21),('Chidambaram', 22),('Kulithalai', 23),('Perambalur', 24),('Coonoor', 25),('Jayankondam', 26),('Tiruppur', 27);");
			ps.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
