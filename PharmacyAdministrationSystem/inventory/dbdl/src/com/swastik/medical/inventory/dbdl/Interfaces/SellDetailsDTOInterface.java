package com.swastik.medical.inventory.dbdl.Interfaces;
import java.math.*;
public interface SellDetailsDTOInterface extends java.io.Serializable,Comparable<SellDetailsDTOInterface>
{
public void setPatientName(String patientName);
public void setMedicineName(String medicineName);
public void setAmount(int amount);
public void setTodayDate(int todayDate);
public void setTodayMonth(int todayMonth);
public void setTodayYear(int todayYear);
public String getPatientName();
public String getMedicineName();
public int getAmount();
public int getTodayDate();
public int getTodayMonth();
public int getTodayYear();
}