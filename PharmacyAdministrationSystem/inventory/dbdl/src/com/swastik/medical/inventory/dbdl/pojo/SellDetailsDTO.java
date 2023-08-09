package com.swastik.medical.inventory.dbdl.pojo;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import java.util.*;
import java.math.*;
public class SellDetailsDTO implements SellDetailsDTOInterface
{
private String patientName;
private String medicineName;
private int amount;
private int todayDate;
private int todayMonth;
private int todayYear;

public SellDetailsDTO()
{
this.patientName="";
this.medicineName="";
this.amount=0;
this.todayDate=-1;
this.todayMonth=-1;
this.todayYear=-1;
}
public void setPatientName(String patientName)
{
this.patientName=patientName;
}
public void setMedicineName(String medicineName)
{
this.medicineName=medicineName;
}
public void setAmount(int amount)
{
this.amount=amount;
}
public void setTodayDate(int todayDate)
{
this.todayDate=todayDate;
}
public void setTodayMonth(int todayMonth)
{
this.todayMonth=todayMonth;
}
public void setTodayYear(int todayYear)
{
this.todayYear=todayYear;
}
public String getPatientName()
{
return this.patientName;
}
public String getMedicineName()
{
return this.medicineName;
}
public int getAmount()
{
return this.amount;
}
public int getTodayDate()
{
return this.todayDate;
}
public int getTodayMonth()
{
return this.todayMonth;
}
public int getTodayYear()
{
return this.todayYear;
}
public int compareTo(SellDetailsDTOInterface other)
{
return this.patientName.toUpperCase().compareTo(other.getPatientName().toUpperCase());
}
}