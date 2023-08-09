package com.swastik.medical.inventory.dbdl.pojo;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import java.util.*;
import java.math.*;
public class UserDTO implements UserDTOInterface
{
private String userName;
private String passward;
private String masterPassward;

public UserDTO()
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
public int compareTo(UserDTOInterface other)
{
return this.userName.toUpperCase().compareTo(other.getUserName().toUpperCase());
}
}