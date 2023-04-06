package com.zoho.FoodDelivery;
import java.sql.Connection;
import java.sql.Statement;
final class FoodyTables
{
	static Connection con=null;
	static Statement state=null;
	public static void createFoodyTables()
	{
		if((con=Database.getConnection())!=null)
		{
		try
		{
			state=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
			createUserRole();
			createUserDetail();
			createAddress();
			createLogin();
			createMenutype();
			createRestaurent();
			createMenuDetail();
			createOrderMaster();
			createOrderDetail();
			createStatesDetail();
			createDistrictsDetail();
			createCitiesDetail();
		}
	}
	public static void createUserRole()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS userrole(id SERIAL PRIMARY KEY,rolename varchar(20) NOT NULL,status boolean DEFAULT true);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createUserDetail()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS userdetail(id SERIAL PRIMARY KEY,role int NOT NULL,name varchar(30) NOT NULL,phoneno bigint NOT NULL,mail varchar(50) NOT NULL,status boolean DEFAULT true,CONSTRAINT fk_role FOREIGN KEY(role) REFERENCES userrole(id) ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createAddress()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS address(id SERIAL PRIMARY KEY,userid bigint NOT NULL,street varchar(30) NOT NULL,city int NOT NULL,district int NOT NULL,state int NOT NULL,CONSTRAINT fk_userid FOREIGN KEY(userid) REFERENCES userdetail(id),CONSTRAINT fk_district FOREIGN KEY(district) REFERENCES districts(id),CONSTRAINT fk_city FOREIGN KEY(city) REFERENCES cities(id),CONSTRAINT fk_state FOREIGN KEY(state) REFERENCES states(id) ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createLogin()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS login(id SERIAL PRIMARY KEY,userid int NOT NULL,password varchar(20) NOT NULL,CONSTRAINT fk_userid FOREIGN KEY(userid) REFERENCES userdetail(id) ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createMenutype()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS menutype(id SERIAL PRIMARY KEY,foodname varchar(20) NOT NULL,menutype varchar(30) NOT NULL,description  varchar(100));");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createRestaurent()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS restaurent(id SERIAL PRIMARY KEY,owner int NOT NULL,restaurent_name varchar(30),restaurent_type varchar(15),description varchar(100),status boolean DEFAULT false,CONSTRAINT fk_owner FOREIGN KEY(owner) REFERENCES userdetail(id) ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createMenuDetail()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS menudetail(id SERIAL PRIMARY KEY,restaurent_id int NOT NULL,menu_id int NOT NULL,price decimal NOT NULL,status boolean DEFAULT true,CONSTRAINT fk_resid FOREIGN KEY(restaurent_id) REFERENCES restaurent(id),CONSTRAINT fk_menuid FOREIGN KEY(menu_id) REFERENCES menutype(id) ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createOrderMaster()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS ordermaster(id SERIAL PRIMARY KEY,cutomerid bigint NOT NULL,restaurent_id int NOT null,amount decimal NOT NULL,driverid int NULL,paymenttype varchar(30),status boolean DEFAULT true,CONSTRAINT fk_resid FOREIGN KEY(restaurent_id) REFERENCES restaurent(id),CONSTRAINT fk_customer FOREIGN KEY(cutomerid) REFERENCES userdetail(id) ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createOrderDetail()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS orderdetail(id SERIAL PRIMARY KEY,orderid int NOT NULL,food_id int NOT NULL,count int NOT NULL,price decimal NOT NULL,status boolean DEFAULT true,CONSTRAINT fk_orderid FOREIGN KEY(orderid) REFERENCES ordermaster(id),CONSTRAINT fk_food_id FOREIGN KEY(food_id) REFERENCES menudetail(id)ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createStatesDetail()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS states(id SERIAL PRIMARY KEY,state_name varchar(30) NOT NULL);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createDistrictsDetail()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS districts(id SERIAL PRIMARY KEY,district_name varchar(30) NOT NULL,state_id int NOT NULL,CONSTRAINT fk_stateid FOREIGN KEY(state_id) REFERENCES states(id)ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void createCitiesDetail()
	{
		try
		{
		state.executeUpdate("CREATE TABLE IF NOT EXISTS cities(id SERIAL PRIMARY KEY,city_name varchar(30) NOT NULL,district_id int NOT NULL,CONSTRAINT fk_districtid FOREIGN KEY(district_id) REFERENCES districts(id)ON DELETE CASCADE);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
