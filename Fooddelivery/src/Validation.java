package com.zoho.FoodDelivery;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.*;
final class Validation
{
	static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	public static String isCharacter(String s) throws IOException
	{
		System.out.print("\nEnter "+s+"	:");
		String str=reader.readLine();
		while(!Pattern.matches("[a-zA-Z][a-z]*",str))
		{
		System.out.print("\n\tEnter "+s+" in String Format	:");
		str=reader.readLine();
		}
		return str;
	}
	public static String isEmail(String s) throws IOException
	{
		System.out.print("\nEnter "+s+"	:");
		String str=reader.readLine();
		while(!Pattern.matches("[a-zA-Z][a-zA-Z0-9_.]*@gmail.com",str))
		{
		System.out.print("\n\tEnter "+s+" in String Format	:");
		str=reader.readLine();
		}
		return str;
	}
	public static long isMobile(String s) throws IOException
	{
		System.out.print("\nEnter "+s+"	:");
		String str=reader.readLine();
		while(!Pattern.matches("[7-9][0-9]{9}",str))
		{
		System.out.print("\n\tEnter "+s+" in Correct Format	:");
		str=reader.readLine();
		}
		return Long.parseLong(str);
	}
	public static int isOtp(String s) throws IOException
	{
		System.out.print("\nEnter "+s+"	:");
		String str=reader.readLine();
		while(!Pattern.matches("[0-9]{6}",str))
		{
		System.out.print("\n\tEnter "+s+" in Correct Format	:");
		str=reader.readLine();
		}
		return Integer.parseInt(str);
	}
	public static int isRoleid(String s) throws IOException
	{
		System.out.print("\nEnter "+s+"	:");
		String str=reader.readLine();
		while(!Pattern.matches("[1-9]{1}",str))
		{
		System.out.print("\n\tEnter Correct "+s+"	:");
		str=reader.readLine();
		}
		return Integer.parseInt(str);
	}
}
