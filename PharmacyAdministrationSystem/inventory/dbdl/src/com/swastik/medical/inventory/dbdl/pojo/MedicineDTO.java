package com.swastik.medical.inventory.dbdl.pojo;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import java.util.*;
import java.math.*;
public class MedicineDTO implements MedicineDTOInterface
{
private String name;
private String category;
private BigDecimal buyingCost;
private BigDecimal MRP;
private String manuMonth;
private int manuMonthNumber;
private String manuYear;
private String exMonth;
private int exMonthNumber;
private String exYear;
private String billDate;
private String billMonth;
private String billYear;
private String billNumber;
private String traderName;
private int ammountOfMedicine;

public MedicineDTO()
{
this.name="";
this.category="";
this.buyingCost=new BigDecimal("0.00");
this.MRP=new BigDecimal("0.00");
this.manuMonth="";
this.manuMonthNumber=0;
this.manuYear="";
this.exMonth="";
this.exMonthNumber=100;
this.exYear="";
this.billDate="";
this.billMonth="";
this.billYear="";
this.billNumber="";
this.traderName="";
this.ammountOfMedicine=0;
}


public void setName(String name)
{
this.name=name.toUpperCase();
}
public void setCategory(String category)
{
this.category=category.toUpperCase();
}
public void setBuyingCost(BigDecimal buyingCost)
{
this.buyingCost=buyingCost;
}
public void setMRP(BigDecimal MRP)
{
this.MRP=MRP;
}
public void setManuMonth(String manuMonth)
{
this.manuMonth=manuMonth.toUpperCase();
if(manuMonth.equalsIgnoreCase("january")) this.manuMonthNumber=1;
if(manuMonth.equalsIgnoreCase("february")) this.manuMonthNumber=2;
if(manuMonth.equalsIgnoreCase("march")) this.manuMonthNumber=3;
if(manuMonth.equalsIgnoreCase("april")) this.manuMonthNumber=4;
if(manuMonth.equalsIgnoreCase("may")) this.manuMonthNumber=5;
if(manuMonth.equalsIgnoreCase("june")) this.manuMonthNumber=6;
if(manuMonth.equalsIgnoreCase("july")) this.manuMonthNumber=7;
if(manuMonth.equalsIgnoreCase("august")) this.manuMonthNumber=8;
if(manuMonth.equalsIgnoreCase("september")) this.manuMonthNumber=9;
if(manuMonth.equalsIgnoreCase("october")) this.manuMonthNumber=10;
if(manuMonth.equalsIgnoreCase("november")) this.manuMonthNumber=11;
if(manuMonth.equalsIgnoreCase("december")) this.manuMonthNumber=12;
}
public void setManuMonthNumber(int manuMonthNumber)
{
this.manuMonthNumber=manuMonthNumber;
}
public void setManuYear(String manuYear)
{
this.manuYear=manuYear;
}
public void setExMonth(String exMonth)
{
this.exMonth=exMonth.toUpperCase();
if(exMonth.equalsIgnoreCase("january")) this.exMonthNumber=1;
if(exMonth.equalsIgnoreCase("february")) this.exMonthNumber=2;
if(exMonth.equalsIgnoreCase("march")) this.exMonthNumber=3;
if(exMonth.equalsIgnoreCase("april")) this.exMonthNumber=4;
if(exMonth.equalsIgnoreCase("may")) this.exMonthNumber=5;
if(exMonth.equalsIgnoreCase("june")) this.exMonthNumber=6;
if(exMonth.equalsIgnoreCase("july")) this.exMonthNumber=7;
if(exMonth.equalsIgnoreCase("august")) this.exMonthNumber=8;
if(exMonth.equalsIgnoreCase("september")) this.exMonthNumber=9;
if(exMonth.equalsIgnoreCase("october")) this.exMonthNumber=10;
if(exMonth.equalsIgnoreCase("november")) this.exMonthNumber=11;
if(exMonth.equalsIgnoreCase("december")) this.exMonthNumber=12;
}
public void setExMonthNumber(int exMonthNumber)
{
this.exMonthNumber=exMonthNumber;
}
public void setExYear(String exYear)
{
this.exYear=exYear;
}
public void setBillDate(String billDate)
{
this.billDate=billDate;
}
public void setBillMonth(String billMonth)
{
this.billMonth=billMonth.toUpperCase();
}
public void setBillYear(String billYear)
{
this.billYear=billYear;
}
public void setBillNumber(String billNumber)
{
this.billNumber=billNumber;
}
public void setTraderName(String traderName)
{
this.traderName=traderName.toUpperCase();
}
public void setAmmountOfMedicine(int ammountOfMedicine)
{
this.ammountOfMedicine=ammountOfMedicine;
}
    


public String getName()
{
return this.name;
}
public String getCategory()
{
return this.category;
}
public BigDecimal getBuyingCost()
{
return this.buyingCost;
}
public BigDecimal getMRP()
{
return this.MRP;
}
public String getManufacturingFullDate()
{
String DATE=this.manuMonth+"/"+this.manuYear;
return DATE;
}
public String getExpiryFullDate()
{
String DATE=this.exMonth+"/"+this.exYear;
return DATE;
}
public String getBillFullDate()
{
String DATE=this.billDate+"/"+this.billMonth+"/"+this.billYear;
return DATE;
}
public String getManuMonth()
{
return this.manuMonth;
}
public int getManuMonthNumber()
{
return this.manuMonthNumber;
}
public String getManuYear()
{
return this.manuYear;
}
public String getExMonth()
{
return this.exMonth;
}
public int getExMonthNumber()
{
return this.exMonthNumber;
}
public String getExYear()
{
return this.exYear;
}
public String getBillDate()
{
return this.billDate;
}
public String getBillMonth()
{
return this.billMonth;
}
public String getBillYear()
{
return this.billYear;
}
public String getBillNumber()
{
return this.billNumber;
}
public String getTraderName()
{
return this.traderName;
}
public int getAmmountOfMedicine()
{
return this.ammountOfMedicine;
}


public boolean equals(Object object)
{
if(!(object instanceof MedicineDTOInterface))
{
return false;
}            
MedicineDTOInterface otherMedicineDTO;
otherMedicineDTO=(MedicineDTOInterface)object;
return this.name.toUpperCase()==otherMedicineDTO.getName().toUpperCase();
}
public int compareTo(MedicineDTOInterface other)
{
return this.name.toUpperCase().compareTo(other.getName().toUpperCase());
}

}