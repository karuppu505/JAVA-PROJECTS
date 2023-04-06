package com.zoho.FoodDelivery;
class RegistrationModel
{
	private int userid;
      private int roleid;
      private String name;
      private long phoneno;
      private String mail;
      AddressModel am=null;
      RegistrationModel(int roleid,String name,long phoneno,String mail)
      {
             this.roleid=roleid;
             this.name=name;
             this.phoneno=phoneno;
             this.mail=mail;
      }
      RegistrationModel(int userid,String name,long phoneno,String street,int stateid,int districtid,int cityid,String state,String district,String city)
      {
      	am=new AddressModel(street,stateid,districtid,cityid,state,district,city);
             this.userid=userid;
             this.name=name;
             this.phoneno=phoneno;
      }
      RegistrationModel(int roleid,String name,long phoneno)
      {
             this.userid=userid;
             this.name=name;
             this.phoneno=phoneno;
      }
      public void setRole(int roleid)
      {
         this.roleid=roleid;
      }
      public int getRole()
      {
         return roleid;
      }
      public void setName(String name)
      {
         this.name=name;
      }
      public String getName()
      {
         return name;
      }
      public void setPhoneno(long phoneno)
      {
         this.phoneno=phoneno;
      }
      public long getPhoneno()
      {
         return phoneno;
      }
      public void setMail(String mail)
      {
         this.mail=mail;
      }
      public String getMail()
      {
         return mail;
      }
}
