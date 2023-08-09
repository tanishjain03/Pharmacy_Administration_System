package com.swastik.medical.inventory.bl.pojo;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import java.util.*;
import java.math.*;
public class User implements UserInterface
{
private String userName;
private String passward;
private String masterPassward;

public User()
{
this.userName="";
this.passward="";
this.masterPassward="sapanjain";
}

public void setUserName(String userName)
{
this.userName=userName;
}
public void setPassward(String passward)
{
this.passward=passward;
}
public void setMasterPassward(String masterPassward)
{
this.masterPassward=masterPassward;
}
public String getUserName()
{
return this.userName;
}
public String getPassward()
{
return this.passward;
}
public String getMasterPassward()
{
return this.masterPassward;
}
public int compareTo(UserInterface other)
{
return this.userName.toUpperCase().compareTo(other.getUserName().toUpperCase());
}
}