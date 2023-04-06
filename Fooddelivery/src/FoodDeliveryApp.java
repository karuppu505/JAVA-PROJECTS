package com.zoho.FoodDelivery;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
class FoodDeliveryApp
{
      static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      public static void main(String args[])throws IOException
      {
           DefaultValues.getDefaultValues();
           boolean flag=true;
           while(flag)
           {
           	System.out.println("\t\t\t\t  SPEED FOOD DELIVERY");
           	System.out.println("\t\t\t\t\t1.Login\n\t\t\t\t\t2.SignUp\n\t\t\t\t\t3.Exit");
           	byte choice=Byte.parseByte(reader.readLine());
           	while(choice!=1 && choice!=2&& choice!=3)
           	{
               	System.out.println("Enter Valid Input!!!!!!!!!!!!!");
         	    	System.out.println("\t\t\t\t\t1.Login\n\t\t\t\t\t2.SignUp\n\t\t\t\t\t3.Exit");
         	      	choice=Byte.parseByte(reader.readLine());
         	  }
         	  if(choice ==1)
         	  {
         	  	Registration_view.login();
         	  }
         	  else if(choice ==2)
         	  {
         	  	Registration_view.registration();
         	  }
         	  else
         	  {
         	  	flag=false;
         	  }
        }
        
      }
}
