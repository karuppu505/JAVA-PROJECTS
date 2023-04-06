package com.zoho.FoodDelivery;
class RoleModel
{
      private int roleid;
      private String name;
      RoleModel(int roleid,String name)
      {
             this.roleid=roleid;
             this.name=name;
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
}
