package com.swastik.medical.inventory.dbdl.Interfaces;
import java.math.*;
public interface MedicineDTOInterface extends java.io.Serializable,Comparable<MedicineDTOInterface>
{
    public void setName(String name);
    public void setCategory(String category);
    public void setBuyingCost(BigDecimal buyingCost);
    public void setMRP(BigDecimal MRP);
    public void setBillNumber(String billNumber);
    public void setTraderName(String traderName);
    public void setManuMonth(String manuMonth);
    public void setManuMonthNumber(int manuMonthNumber);
    public void setManuYear(String manuYear);
    public void setExMonth(String exMonth);
    public void setExMonthNumber(int exMonthNumber);
    public void setExYear(String exYear); 
    public void setBillDate(String billDate);
    public void setBillMonth(String billMonth);
    public void setBillYear(String billYear);       
    public void setAmmountOfMedicine(int ammountOfMedicine);

    public String getName();
    public String getCategory();
    public BigDecimal getBuyingCost();
    public BigDecimal getMRP();
    public String getManufacturingFullDate();
    public String getExpiryFullDate();
    public String getManuMonth();
    public int getManuMonthNumber();
    public String getManuYear();
    public String getExMonth();
    public int getExMonthNumber();
    public String getExYear(); 
    public String getBillDate();
    public String getBillMonth();
    public String getBillYear();       
    public String getBillNumber();
    public String getBillFullDate();
    public String getTraderName();
    public int getAmmountOfMedicine();
}
