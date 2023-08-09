package com.swastik.medical.inventory.dbdl.Interfaces;
import java.math.*;
public interface UserDTOInterface extends java.io.Serializable,Comparable<UserDTOInterface>
{
public void setUserName(String userName);
public void setPassward(String passward);
public void setMasterPassward(String masterPassward);

public String getUserName();
public String getPassward();
public String getMasterPassward();
}