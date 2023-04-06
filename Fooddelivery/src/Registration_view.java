package com.zoho.FoodDelivery;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.LinkedHashMap;
import java.util.Map;
class Registration_view
{
	static String check="";
	static String otp="";
	static LinkedHashMap<Integer,String> role=null;
	static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	public static void registration() throws IOException
	{
			String name=Validation.isCharacter("Name");
			String email=Validation.isEmail("Email");
			long mobileno=Validation.isMobile("Mobile No");
			role=RegistrationControler.getRole();
			for(Map.Entry<Integer,String> entry:role.entrySet())
			{
				System.out.println("\t\t"+entry.getKey()+"."+entry.getValue());
			}
			int roleid=Validation.isRoleid("Role id");
			while(!role.containsKey(roleid))
			{	
					roleid=Validation.isRoleid("Role id");
			}
			System.out.print("\n\tCHECK YOUR DETAIL AND PRESS Y TO CONTINUE OTHERWISW N	:");
			check=reader.readLine();
			while(!check.equalsIgnoreCase("y")&&!check.equalsIgnoreCase("n"))
			{
				 check=reader.readLine();
			}
			if(check.equalsIgnoreCase("y"))
			{	
				otp=generateOtp();
				System.out.println("\n\tYour One Time Password is	"+otp);
				int userotp=Validation.isOtp("OTP");
				while(userotp!=Integer.valueOf(otp))
				{
					userotp=Validation.isOtp("CORRECT OTP");
				}
				RegistrationModel rm=new RegistrationModel(roleid,name,mobileno,email);
				int id=RegistrationControler.insertCustomerData(rm);
				if(id!=0)
				{
					System.out.println("Register ID	:"+id);
					addAddress(id);
				}
			}
			else
			{
				System.out.print("\n\t***CANCELLED");	
			}
	}
	public static String generateOtp()
	{
		Random random=new Random();
		StringBuffer otp=new StringBuffer();
		for(int i=0;i<6;i++)
		{
			otp.append(random.nextInt(10));
		}
		return String.valueOf(otp);
	}
	public static void addAddress(int id) 
	{
		
	}
	public static void login() throws IOException
	{
		System.out.println("\n\t\t\tLOGIN");
		System.out.print("\nENTER EMAIL OR PHONE NUMBER	:");
		String str=reader.readLine();
		RegistrationModel userdetail=RegistrationControler.isUser(str);
		while(userdetail==null)
		{
			System.out.print("\n\t\t***INVALID USER");
			System.out.print("\n\tDo You Want To Continue press Y Otherwise N	:");
			check=reader.readLine();
			while(!check.equalsIgnoreCase("y")&&!check.equalsIgnoreCase("n"))
			{
				 check=reader.readLine();
			}
			if(check.equalsIgnoreCase("n"))
				break;
			System.out.print("\n\nENTER EMAIL OR PHONE NUMBER	:");
			str=reader.readLine();
			userdetail=RegistrationControler.isUser(str);
		}
		otp=generateOtp();
		System.out.println("\n\tYour One Time Password is	"+otp);
		int userotp=Validation.isOtp("OTP");
		while(userotp!=Integer.valueOf(otp))
		{
			userotp=Validation.isOtp("CORRECT OTP");
		}
		if(userdetail!=null)
		{
			System.out.println(userdetail.getRole()+""+userdetail.am.getState()+" "+userdetail.am.getDistrict()+" "+userdetail.am.getCity());
		}
	}
	public static void main(String[] args) throws IOException
	{
		DefaultValues.getDefaultValues();
		//registration();
		login();
	}
	
}
