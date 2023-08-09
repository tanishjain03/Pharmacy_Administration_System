package com.swastik.medical.inventory.dbdl;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.net.*;
import java.sql.*;
public class MedicineDAO implements MedicineDAOInterface
{

public void add(MedicineDTOInterface medicineDTO) throws DAOException

{
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select name from medicines where upper(name)=?");
ps.setString(1,medicineDTO.getName().toUpperCase());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
String name=rs.getString("name");
rs.close();
ps.close();
c.close();
throw new DAOException("Item already exist with name "+medicineDTO.getName());
}
ps=c.prepareStatement("insert into medicines(name,category,buyingCost,MRP,billNumber,traderName,manuMonth,manuMonthNumber,manuYear,exMonth,exMonthNumber,exYear,billDate,billMonth,billYear,ammountOfMedicine) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

String vName=medicineDTO.getName();
String vCategory=medicineDTO.getCategory();
BigDecimal vBuyingCost=medicineDTO.getBuyingCost();
BigDecimal vMRP=medicineDTO.getMRP();
String vBillNumber=medicineDTO.getBillNumber();
if(vBillNumber==null) vBillNumber=" ";
String vTraderName=medicineDTO.getTraderName();
if(vTraderName==null) vTraderName=" ";
String vManuMonth=medicineDTO.getManuMonth();
if(vManuMonth==null) vManuMonth=" ";
int vManuMonthNumber=medicineDTO.getManuMonthNumber();
String vManuYear=medicineDTO.getManuYear();
if(vManuYear==null) vManuYear=" ";
String vExMonth=medicineDTO.getExMonth();
if(vExMonth==null) vExMonth=" ";
int vExMonthNumber=medicineDTO.getExMonthNumber();
String vExYear=medicineDTO.getExYear();
if(vExYear==null) vExYear=" ";
String vBillDate=medicineDTO.getBillDate();
if(vBillDate==null) vBillDate=" ";
String vBillMonth=medicineDTO.getBillMonth();
if(vBillMonth==null) vBillMonth=" ";
String vBillYear=medicineDTO.getBillYear();
if(vBillYear==null) vBillYear=" ";
int vAmmountOfMedicine=medicineDTO.getAmmountOfMedicine();

ps.setString(1,vName);
ps.setString(2,vCategory);
ps.setBigDecimal(3,vBuyingCost);
ps.setBigDecimal(4,vMRP);
ps.setString(5,vBillNumber);
ps.setString(6,vTraderName);
ps.setString(7,vManuMonth);
ps.setInt(8,vManuMonthNumber);
ps.setString(9,vManuYear);
ps.setString(10,vExMonth);
ps.setInt(11,vExMonthNumber);
ps.setString(12,vExYear);
ps.setString(13,vBillDate);
ps.setString(14,vBillMonth);
ps.setString(15,vBillYear);
ps.setInt(16,vAmmountOfMedicine);
ps.executeUpdate();
rs.close();
ps.close();
c.close();
}catch(Exception e)
{
e.printStackTrace();
throw new DAOException(e.getMessage());
}
}


public void delete(String name) throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select name from medicines where name=?");
ps.setString(1,name.toUpperCase());
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("Name doesnot exists");
}
r.close();
ps.close();
ps=c.prepareStatement("delete from medicines where name=?");
ps.setString(1,name.toUpperCase());
ps.executeUpdate();
ps.close();
c.close();
}catch(SQLException sqlException)
{
throw new DAOException("Unable to remove");
}
}



public void update(MedicineDTOInterface medicineDTO) throws DAOException
{
String vName=medicineDTO.getName();
String vCategory=medicineDTO.getCategory();
BigDecimal vBuyingCost=medicineDTO.getBuyingCost();
BigDecimal vMRP=medicineDTO.getMRP();
String vBillNumber=medicineDTO.getBillNumber();
if(vBillNumber==null) vBillNumber=" ";
String vTraderName=medicineDTO.getTraderName();
if(vTraderName==null) vTraderName=" ";
String vManuMonth=medicineDTO.getManuMonth();
if(vManuMonth==null) vManuMonth=" ";
int vManuMonthNumber=medicineDTO.getManuMonthNumber();
String vManuYear=medicineDTO.getManuYear();
if(vManuYear==null) vManuYear=" ";
String vExMonth=medicineDTO.getExMonth();
if(vExMonth==null) vExMonth=" ";
int vExMonthNumber=medicineDTO.getExMonthNumber();
String vExYear=medicineDTO.getExYear();
if(vExYear==null) vExYear=" ";
String vBillDate=medicineDTO.getBillDate();
if(vBillDate==null) vBillDate=" ";
String vBillMonth=medicineDTO.getBillMonth();
if(vBillMonth==null) vBillMonth=" ";
String vBillYear=medicineDTO.getBillYear();
if(vBillYear==null) vBillYear=" ";
int vAmmountOfMedicine=medicineDTO.getAmmountOfMedicine();
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps;
ps=c.prepareStatement("select name from medicines where name=?");
ps.setString(1,vName);
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("Invalid medicine name");
}
r.close();
ps.close();
ps=c.prepareStatement("update medicines set name=?,category=?,buyingCost=?,MRP=?,billNumber=?,traderName=?,manuMonth=?,manuMonthNumber=?,manuYear=?,exMonth=?,exMonthNumber=?,exYear=?,billDate=?,billMonth=?,billyear=?,ammountOfMedicine=? where name=?");
ps.setString(1,vName);
ps.setString(2,vCategory);
ps.setBigDecimal(3,vBuyingCost);
ps.setBigDecimal(4,vMRP);
ps.setString(5,vBillNumber);
ps.setString(6,vTraderName);
ps.setString(7,vManuMonth);
ps.setInt(8,vManuMonthNumber);
ps.setString(9,vManuYear);
ps.setString(10,vExMonth);
ps.setInt(11,vExMonthNumber);
ps.setString(12,vExYear);
ps.setString(13,vBillDate);
ps.setString(14,vBillMonth);
ps.setString(15,vBillYear);
ps.setInt(16,vAmmountOfMedicine);
ps.setString(17,vName);
ps.executeUpdate();
ps.close();
c.close();
}catch(SQLException sqlException)
{
throw new DAOException("Unable to update");
}
}




public MedicineDTOInterface getByName(String name) throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select * from medicines where name=?");
ps.setString(1,name.toUpperCase());
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("Name doesnot exists");
}
MedicineDTOInterface medicineDTO;
medicineDTO=new MedicineDTO();
String vName;
String vCategory;
BigDecimal vBuyingCost;
BigDecimal vMRP;
String vBillNumber;
String vTraderName;
String vManuMonth;
int vManuMonthNumber;
String vManuYear;
String vExMonth;
int vExMonthNumber;
String vExYear;
String vBillDate;
String vBillMonth;
String vBillYear;
int vAmmountOfMedicine;


vName=r.getString("name").trim();
medicineDTO.setName(vName);
vCategory=r.getString("category").trim();
medicineDTO.setCategory(vCategory);
vBuyingCost=r.getBigDecimal("buyingCost");
medicineDTO.setBuyingCost(vBuyingCost);
vMRP=r.getBigDecimal("MRP");
medicineDTO.setMRP(vMRP);
vBillNumber=r.getString("billNumber").trim();
medicineDTO.setBillNumber(vBillNumber);
vTraderName=r.getString("traderName").trim();
medicineDTO.setTraderName(vTraderName);
vManuMonth=r.getString("manuMonth").trim();
medicineDTO.setManuMonth(vManuMonth);
vManuMonthNumber=r.getInt("manuMonthNumber");
medicineDTO.setManuMonthNumber(vManuMonthNumber);
vManuYear=r.getString("manuYear").trim();
medicineDTO.setManuYear(vManuYear);
vExMonth=r.getString("exMonth").trim();
medicineDTO.setExMonth(vExMonth);
vExMonthNumber=r.getInt("exMonthNumber");
medicineDTO.setExMonthNumber(vExMonthNumber);
vExYear=r.getString("exYear").trim();
medicineDTO.setExYear(vExYear);
vBillDate=r.getString("billDate").trim();
medicineDTO.setBillDate(vBillDate);
vBillMonth=r.getString("billMonth").trim();
medicineDTO.setBillMonth(vBillMonth);
vBillYear=r.getString("billYear").trim();
medicineDTO.setBillYear(vBillYear);
vAmmountOfMedicine=r.getInt("ammountOfMedicine");
medicineDTO.setAmmountOfMedicine(vAmmountOfMedicine);
r.close();
ps.close();
c.close();
return medicineDTO;
}catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch item");
}
}



public List<MedicineDTOInterface> getAll() throws DAOException
{
try
{
List<MedicineDTOInterface> medicines;
medicines=new LinkedList<>();
String name;
String category;
BigDecimal buyingCost;
BigDecimal MRP;
String billNumber;
String traderName;
String manuMonth;
int manuMonthNumber;
String manuYear;
String exMonth;
int exMonthNumber;
String exYear;
String billDate;
String billMonth;
String billYear;
int ammountOfMedicine;
MedicineDTOInterface medicineDTO;

Connection c=DAOConnection.getConnection();
Statement s=c.createStatement();
ResultSet r;
r=s.executeQuery("select * from medicines order by name");
while(r.next())
{
medicineDTO=new MedicineDTO();
name=r.getString("name").trim();
medicineDTO.setName(name);
category=r.getString("category").trim();
medicineDTO.setCategory(category);
buyingCost=r.getBigDecimal("buyingCost");
medicineDTO.setBuyingCost(buyingCost);
MRP=r.getBigDecimal("MRP");
medicineDTO.setMRP(MRP);
billNumber=r.getString("billNumber").trim();
medicineDTO.setBillNumber(billNumber);
traderName=r.getString("traderName").trim();
medicineDTO.setTraderName(traderName);
manuMonth=r.getString("manuMonth").trim();
medicineDTO.setManuMonth(manuMonth);
manuMonthNumber=r.getInt("manuMonthNumber");
medicineDTO.setManuMonthNumber(manuMonthNumber);
manuYear=r.getString("manuYear").trim();
medicineDTO.setManuYear(manuYear);
exMonth=r.getString("exMonth").trim();
medicineDTO.setExMonth(exMonth);
exMonthNumber=r.getInt("exMonthNumber");
medicineDTO.setExMonthNumber(exMonthNumber);
exYear=r.getString("exYear").trim();
medicineDTO.setExYear(exYear);
billDate=r.getString("billDate").trim();
medicineDTO.setBillDate(billDate);
billMonth=r.getString("billMonth").trim();
medicineDTO.setBillMonth(billMonth);
billYear=r.getString("billYear").trim();
medicineDTO.setBillYear(billYear);
ammountOfMedicine=r.getInt("ammountOfMedicine");
medicineDTO.setAmmountOfMedicine(ammountOfMedicine);
medicines.add(medicineDTO);
}
r.close();
s.close();
c.close();
return medicines;
}catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch item");
}
}



public int getCount() throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
Statement s=c.createStatement();
ResultSet r;
r=s.executeQuery("select count(*) as cnt from medicines");
r.next();
int count=r.getInt("cnt");
r.close();
s.close();
c.close();
return count;
}catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch item count");
}
}


public List<MedicineDTOInterface> getExpiry() throws DAOException
{
try
{
List<MedicineDTOInterface> medicines;
medicines=new LinkedList<>();
String name;
String category;
BigDecimal buyingCost;
BigDecimal MRP;
String billNumber;
String traderName;
String manuMonth;
int manuMonthNumber;
String manuYear;
String exMonth;
int exMonthNumber;
String exYear;
String billDate;
String billMonth;
String billYear;
int ammountOfMedicine;
int todayMonth;
int todayYear;
MedicineDTOInterface medicineDTO;
Calendar cal=Calendar.getInstance();
todayMonth=cal.get(Calendar.MONTH);
todayYear=cal.get(Calendar.YEAR);
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select * from medicines where exYear<=? and exMonthNumber<?");
ps.setInt(1,todayYear);
ps.setInt(2,todayMonth);
ResultSet r=ps.executeQuery();
while(r.next())
{
medicineDTO=new MedicineDTO();
name=r.getString("name").trim();
medicineDTO.setName(name);
category=r.getString("category").trim();
medicineDTO.setCategory(category);
buyingCost=r.getBigDecimal("buyingCost");
medicineDTO.setBuyingCost(buyingCost);
MRP=r.getBigDecimal("MRP");
medicineDTO.setMRP(MRP);
billNumber=r.getString("billNumber").trim();
medicineDTO.setBillNumber(billNumber);
traderName=r.getString("traderName").trim();
medicineDTO.setTraderName(traderName);
manuMonth=r.getString("manuMonth").trim();
medicineDTO.setManuMonth(manuMonth);
manuMonthNumber=r.getInt("manuMonthNumber");
medicineDTO.setManuMonthNumber(manuMonthNumber);
manuYear=r.getString("manuYear").trim();
medicineDTO.setManuYear(manuYear);
exMonth=r.getString("exMonth").trim();
medicineDTO.setExMonth(exMonth);
exMonthNumber=r.getInt("exMonthNumber");
medicineDTO.setExMonthNumber(exMonthNumber);
exYear=r.getString("exYear").trim();
medicineDTO.setExYear(exYear);
billDate=r.getString("billDate").trim();
medicineDTO.setBillDate(billDate);
billMonth=r.getString("billMonth").trim();
medicineDTO.setBillMonth(billMonth);
billYear=r.getString("billYear").trim();
medicineDTO.setBillYear(billYear);
ammountOfMedicine=r.getInt("ammountOfMedicine");
medicineDTO.setAmmountOfMedicine(ammountOfMedicine);
medicines.add(medicineDTO);
}
r.close();
ps.close();
c.close();
return medicines;
}catch(SQLException sqlException)
{
throw new DAOException("exception in getExpiry");
}
}

public boolean sell(String patientName,String medicineName,int ammount) throws DAOException
{
int a=ammount;
try
{
Calendar cal=Calendar.getInstance();
int todayDate=cal.get(Calendar.DATE);
int todayMonth=cal.get(Calendar.MONTH)+1;
int todayYear=cal.get(Calendar.YEAR);
Connection c=DAOConnection.getConnection();
PreparedStatement ps;
ps=c.prepareStatement("select ammountOfMedicine from medicines where name=?");
ps.setString(1,medicineName.toUpperCase());
ResultSet r;
r=ps.executeQuery();
int ammountOfMedicine=0;
if(r.next()==false)
{
r.close();
ps.close();
c.close();
return false;
//throw new DAOException("Medicine not in Stock");
}
else
{
ammountOfMedicine=r.getInt("ammountOfMedicine");
r.close();
ps.close();
ammount=ammountOfMedicine-ammount;
if(ammount<=0) 
{
c.close();
return false;
//throw new DAOException("Ammount of Medicine not in Stock");
}
else
{
ps=c.prepareStatement("update medicines set ammountOfMedicine=? where name=?");
ps.setInt(1,ammount);
ps.setString(2,medicineName.toUpperCase());
ps.executeUpdate();
ps.close();
System.out.println("cut hua");
ps=c.prepareStatement("insert into details(buyer,medicineName,amount,buyingDate,buyingMonth,buyingYear) values (?,?,?,?,?,?)");
System.out.println("ps bana");
ps.setString(1,patientName.toUpperCase());
ps.setString(2,medicineName.toUpperCase());
ps.setInt(3,a);
ps.setInt(4,todayDate);
ps.setInt(5,todayMonth);
ps.setInt(6,todayYear);
System.out.println("ex ke pehle");
ps.executeUpdate();
System.out.println("add hua");
ps.close();
c.close();
return true;
}
}
}catch(SQLException sqlException)
{
System.out.println("exception");
return false;
//throw new DAOException("Unable to update");
}
}


public List<SellDetailsDTOInterface> getDayReport(int date,int month,int year) throws DAOException
{
try
{
List<SellDetailsDTOInterface> report;
report=new LinkedList<>();
String patientName;
String medicineName;
int amount;
int buyingDate;
int buyingMonth;
int buyingYear;
SellDetailsDTOInterface sellDetailsDTO;
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select * from details where buyingDate=? and buyingMonth=? and buyingYear=?");
ps.setInt(1,date);
ps.setInt(2,month);
ps.setInt(3,year);
ResultSet r=ps.executeQuery();
while(r.next())
{
sellDetailsDTO=new SellDetailsDTO();
patientName=r.getString("buyer").trim();
sellDetailsDTO.setPatientName(patientName);
medicineName=r.getString("medicineName").trim();
sellDetailsDTO.setMedicineName(medicineName);
amount=r.getInt("amount");
sellDetailsDTO.setAmount(amount);
buyingDate=r.getInt("buyingDate");
sellDetailsDTO.setTodayDate(buyingDate);
buyingMonth=r.getInt("buyingMonth");
sellDetailsDTO.setTodayMonth(buyingMonth);
buyingYear=r.getInt("buyingYear");
sellDetailsDTO.setTodayYear(buyingYear);
report.add(sellDetailsDTO);
}
r.close();
ps.close();
c.close();
return report;
}catch(SQLException sqlException)
{
throw new DAOException("exception in getExpiry");
}
}

public List<SellDetailsDTOInterface> getMonthReport(int month,int year) throws DAOException
{
try
{
List<SellDetailsDTOInterface> report;
report=new LinkedList<>();
String patientName;
String medicineName;
int amount;
int buyingDate;
int buyingMonth;
int buyingYear;
SellDetailsDTOInterface sellDetailsDTO;
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select * from details where buyingMonth=? and buyingYear=?");
ps.setInt(1,month);
ps.setInt(2,year);
ResultSet r=ps.executeQuery();
while(r.next())
{
sellDetailsDTO=new SellDetailsDTO();
patientName=r.getString("buyer").trim();
System.out.println(patientName);
sellDetailsDTO.setPatientName(patientName);
medicineName=r.getString("medicineName").trim();
sellDetailsDTO.setMedicineName(medicineName);
amount=r.getInt("amount");
sellDetailsDTO.setAmount(amount);
buyingDate=r.getInt("buyingDate");
sellDetailsDTO.setTodayDate(buyingDate);
buyingMonth=r.getInt("buyingMonth");
sellDetailsDTO.setTodayMonth(buyingMonth);
buyingYear=r.getInt("buyingYear");
sellDetailsDTO.setTodayYear(buyingYear);
report.add(sellDetailsDTO);
}

r.close();
ps.close();
c.close();
return report;
}catch(SQLException sqlException)
{
throw new DAOException("exception in getExpiry");
}
}

}