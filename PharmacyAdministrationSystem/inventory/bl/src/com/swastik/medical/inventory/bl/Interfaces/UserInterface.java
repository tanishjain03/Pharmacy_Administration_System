package com.swastik.medical.inventory.bl.Interfaces;
import java.math.*;
public interface UserInterface extends java.io.Serializable,Comparable<UserInterface>
{
public void setUserName(String userName);
public void setPassward(String passward);
public void setMasterPassward(String masterPassward);

public String getUserName();
public String getPassward();
public String getMasterPassward();
}