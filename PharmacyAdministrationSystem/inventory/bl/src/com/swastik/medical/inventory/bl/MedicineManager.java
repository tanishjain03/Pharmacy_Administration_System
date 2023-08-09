package com.swastik.medical.inventory.bl;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.pojo.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import java.util.*;
import java.math.*;
public class MedicineManager
{
private List<MedicineInterface> medicinesList;
private HashMap<String,MedicineInterface> medicineNameWiseMap;
public MedicineManager()
{
populateDataStructures();
}
private void populateDataStructures()
{
this.medicinesList=new LinkedList<>();
this.medicineNameWiseMap=new HashMap<>();
try
{
List<MedicineDTOInterface> dlMedicinesList;
dlMedicinesList=new MedicineDAO().getAll();
MedicineInterface medicine;
for(MedicineDTOInterface dlMedicine:dlMedicinesList)
{
medicine=new Medicine();
medicine.setName(dlMedicine.getName().toUpperCase());
medicine.setCategory(dlMedicine.getCategory().toUpperCase());
medicine.setBuyingCost(dlMedicine.getBuyingCost());
medicine.setMRP(dlMedicine.getMRP());
medicine.setManuMonth(dlMedicine.getManuMonth().toUpperCase());
medicine.setManuYear(dlMedicine.getManuYear());
medicine.setManuMonthNumber(dlMedicine.getManuMonthNumber());
medicine.setExMonth(dlMedicine.getExMonth().toUpperCase());
medicine.setExYear(dlMedicine.getExYear());
medicine.setExMonthNumber(dlMedicine.getExMonthNumber());
medicine.setBillDate(dlMedicine.getBillDate());
medicine.setBillMonth(dlMedicine.getBillMonth().toUpperCase());
medicine.setBillYear(dlMedicine.getBillYear());
medicine.setTraderName(dlMedicine.getTraderName().toUpperCase());
medicine.setBillNumber(dlMedicine.getBillNumber());
medicine.setAmmountOfMedicine(dlMedicine.getAmmountOfMedicine());
medicinesList.add(medicine);
medicineNameWiseMap.put(medicine.getName().toUpperCase(),medicine);
}
Collections.sort(medicinesList,new Comparator<MedicineInterface>(){
public int compare(MedicineInterface left,MedicineInterface right)
{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}
});
}catch(DAOException dao)
{
System.out.println(dao);
}
}



public void add(MedicineInterface medicine)throws ValidationException,ProcessException
{
ValidationException ve;
ve =new ValidationException();
if(medicine==null)
{
ve.add("Medicine","Required");
throw ve;
}

String vName;
vName=medicine.getName();
if(vName==null)
{
ve.add("Name","Required");
}
else
{
vName=vName.trim();
if(vName.length()==0)
{
ve.add("Name","Required");
}
else if(vName.length()>20)
{
ve.add("Name","does not exceed 20 characters");
}
}

String vCategory;
vCategory=medicine.getCategory();
if(vCategory==null)
{
ve.add("Category","Required");
}
else
{
vCategory=vCategory.trim();
if(vCategory.length()==0)
{
ve.add("Category","Required");
}
else if(vCategory.length()>15)
{
ve.add("Category","does not exceed 15 characters");
}
}

BigDecimal vBuyingCost;
vBuyingCost=medicine.getBuyingCost();
if(vBuyingCost==null)
{
ve.add("BuyingCost","Required");
}
else if(vBuyingCost.compareTo(new BigDecimal("0.0"))==0)
{
ve.add("BuyingCost","Required");
}

BigDecimal vMRP;
vMRP=medicine.getMRP();
if(vMRP==null)
{
ve.add("MRP","Required");
}
else if(vMRP.compareTo(new BigDecimal("0.0"))==0)
{
ve.add("MRP","Required");
}

int vAmmountOfMedicine;
vAmmountOfMedicine=medicine.getAmmountOfMedicine();
if(vAmmountOfMedicine==0)
{
ve.add("Ammount","Requied");
}

String vBillNumber;
vBillNumber=medicine.getBillNumber();
if(vBillNumber==null)
{
vBillNumber=" ";
}
else
{
vBillNumber=vBillNumber.trim();
if(vBillNumber.length()>15)
{
ve.add("Bill Number","does not exceed 15 characters");
}
}

String vTraderName;
vTraderName=medicine.getTraderName();
if(vTraderName==null)
{
vTraderName=" ";
}
else
{
vTraderName=vTraderName.trim();
if(vTraderName.length()>30)
{
ve.add("Trader Name","does not exceed 30 characters");
}
}

String vManuMonth;
vManuMonth=medicine.getManuMonth();
if(vManuMonth==null)
{
vManuMonth=" ";
}
else
{
vManuMonth=vManuMonth.trim();
if(vManuMonth.length()>10)
{
ve.add("Manu Month","does not exceed 10 characters");
}
}

String vManuYear;
vManuYear=medicine.getManuYear();
if(vManuYear==null)
{
vManuYear=" ";
}
else
{
vManuYear=vManuYear.trim();
if(vManuYear.length()>4)
{
ve.add("Manu Year","does not exceed 4 characters");
}
}

String vExMonth;
vExMonth=medicine.getExMonth();
if(vExMonth==null)
{
vExMonth=" ";
}
else
{
vExMonth=vExMonth.trim();
if(vExMonth.length()>10)
{
ve.add("EX Month","does not exceed 10 characters");
}
}

String vExYear;
vExYear=medicine.getExYear();
if(vExYear==null)
{
vExYear=" ";
}
else
{
vExYear=vExYear.trim();
if(vExYear.length()>4)
{
ve.add("EX Year","does not exceed 4 characters");
}
}

String vBillDate;
vBillDate=medicine.getBillDate();
if(vBillDate==null)
{
vBillDate=" ";
}
else
{
vBillDate=vBillDate.trim();
if(vBillDate.length()>2)
{
ve.add("Bill Date","does not exceed 2 characters");
}
}

String vBillMonth;
vBillMonth=medicine.getBillMonth();
if(vBillMonth==null)
{
vBillMonth=" ";
}
else
{
vBillMonth=vBillMonth.trim();
if(vBillMonth.length()>10)
{
ve.add("Bill Month","does not exceed 10 characters");
}
}

String vBillYear;
vBillYear=medicine.getBillYear();
if(vBillYear==null)
{
vBillYear=" ";
}
else
{
vBillYear=vBillYear.trim();
if(vBillYear.length()>4)
{
ve.add("Bill Year","does not exceed 4 characters");
}
}
if(medicineNameWiseMap.containsKey(vName.toUpperCase()))
{
ve.add("Medicine"," already exists");
}
if(ve.size()!=0)
{
throw ve;
}
MedicineDAOInterface medicineDAO;
medicineDAO=new MedicineDAO();
MedicineDTOInterface medicineDTO;
medicineDTO=new MedicineDTO();
medicineDTO.setName(medicine.getName().toUpperCase());
medicineDTO.setCategory(medicine.getCategory().toUpperCase());
medicineDTO.setBuyingCost(medicine.getBuyingCost());
medicineDTO.setMRP(medicine.getMRP());
medicineDTO.setTraderName(medicine.getTraderName().toUpperCase());
medicineDTO.setBillNumber(medicine.getBillNumber());
medicineDTO.setManuMonth(medicine.getManuMonth().toUpperCase());
medicineDTO.setManuYear(medicine.getManuYear());
medicineDTO.setExMonth(medicine.getExMonth().toUpperCase());
medicineDTO.setExYear(medicine.getExYear());
medicineDTO.setBillDate(medicine.getBillDate());
medicineDTO.setBillMonth(medicine.getBillMonth().toUpperCase());
medicineDTO.setBillYear(medicine.getBillYear());
medicineDTO.setAmmountOfMedicine(medicine.getAmmountOfMedicine());
try
{
System.out.println("adding");
medicineDAO.add(medicineDTO);
System.out.println("added");
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
MedicineInterface medicine2;
medicine2=new Medicine();
medicine2.setName(medicine.getName().toUpperCase());
medicine2.setCategory(medicine.getCategory().toUpperCase());
medicine2.setBuyingCost(medicine.getBuyingCost());
medicine2.setMRP(medicine.getMRP());
medicine2.setTraderName(medicine.getTraderName().toUpperCase());
medicine2.setBillNumber(medicine.getBillNumber());
medicine2.setManuMonth(medicine.getManuMonth().toUpperCase());
medicine2.setManuYear(medicine.getManuYear());
medicine2.setExMonth(medicine.getExMonth().toUpperCase());
medicine2.setExYear(medicine.getExYear());
medicine2.setBillDate(medicine.getBillDate());
medicine2.setBillMonth(medicine.getBillMonth().toUpperCase());
medicine2.setBillYear(medicine.getBillYear());
medicine2.setAmmountOfMedicine(medicine.getAmmountOfMedicine());
medicineNameWiseMap.put(medicine2.getName().toUpperCase(),medicine2);
medicinesList.add(medicine2);
Collections.sort(medicinesList,new Comparator<MedicineInterface>(){
public int compare(MedicineInterface left,MedicineInterface right)
{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}
});

}



public void delete(String name)throws ValidationException,ProcessException
{
ValidationException ve;
ve=new ValidationException();
if(name==null)
{
ve.add("Name","Required");
}
if(!medicineNameWiseMap.containsKey(name.toUpperCase()))
{
ve.add("Name","doesn't exists");
}
if(ve.size()>0)
{
throw ve;
}
try
{
MedicineDAOInterface medicineDAO=new MedicineDAO();
medicineDAO.delete(name.toUpperCase());
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
medicineNameWiseMap.remove(name.toUpperCase());
int count=0;
for(MedicineInterface m:medicinesList)
{
if(m.getName().toUpperCase().equalsIgnoreCase(name.toUpperCase()))
{
medicinesList.remove(count);
break;
}
count++;
}
Collections.sort(medicinesList,new Comparator<MedicineInterface>(){
public int compare(MedicineInterface left,MedicineInterface right)
{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}
});
}





public MedicineInterface getByName(String name)throws ProcessException
{
MedicineInterface medicineInterface;
medicineInterface=medicineNameWiseMap.get(name.toUpperCase());
return medicineInterface;
}


public List<MedicineInterface> getAll()throws ProcessException
{
List<MedicineInterface> medicineList;
medicineList=new LinkedList<MedicineInterface>();
MedicineInterface medicine;
for(MedicineInterface i:medicinesList )
{
medicine=new Medicine();
medicine.setName(i.getName().toUpperCase());
medicine.setCategory(i.getCategory().toUpperCase());
medicine.setBuyingCost(i.getBuyingCost());
medicine.setMRP(i.getMRP());
medicine.setTraderName(i.getTraderName().toUpperCase());
medicine.setBillNumber(i.getBillNumber());
medicine.setManuMonth(i.getManuMonth().toUpperCase());
medicine.setManuYear(i.getManuYear());
medicine.setExMonth(i.getExMonth().toUpperCase());
medicine.setExYear(i.getExYear());
medicine.setBillDate(i.getBillDate());
medicine.setBillMonth(i.getBillMonth().toUpperCase());
medicine.setBillYear(i.getBillYear());
medicine.setAmmountOfMedicine(i.getAmmountOfMedicine());
medicineList.add(medicine);
}
return medicineList;
}


public void update(MedicineInterface medicine)throws ValidationException,ProcessException
{
ValidationException ve;
ve =new ValidationException();
if(medicine==null)
{
ve.add("Medicine","Required");
throw ve;
}
String vName;
vName=medicine.getName();
if(vName==null)
{
ve.add("Name","Required");
}
else
{
vName=vName.trim();
if(vName.length()==0)
{
ve.add("Name","Required");
}
else if(vName.length()>20)
{
ve.add("Name","does not exceed 20 characters");
}
}

String vCategory;
vCategory=medicine.getCategory();
if(vCategory==null)
{
ve.add("Category","Required");
}
else
{
vCategory=vCategory.trim();
if(vCategory.length()==0)
{
ve.add("Category","Required");
}
else if(vCategory.length()>15)
{
ve.add("Category","does not exceed 15 characters");
}
}

BigDecimal vBuyingCost;
vBuyingCost=medicine.getBuyingCost();
if(vBuyingCost==null)
{
ve.add("BuyingCost","Required");
}
else if(vBuyingCost.compareTo(new BigDecimal("0.0"))==0)
{
ve.add("BuyingCost","Required");
}

BigDecimal vMRP;
vMRP=medicine.getMRP();
if(vMRP==null)
{
ve.add("MRP","Required");
}
else if(vMRP.compareTo(new BigDecimal("0.0"))==0)
{
ve.add("MRP","Required");
}

int vAmmountOfMedicine;
vAmmountOfMedicine=medicine.getAmmountOfMedicine();
if(vAmmountOfMedicine==0)
{
ve.add("Ammount","Requied");
}
String vBillNumber;
vBillNumber=medicine.getBillNumber();
if(vBillNumber==null)
{
// do nothing
}
else
{
vBillNumber=vBillNumber.trim();
if(vBillNumber.length()>15)
{
ve.add("Bill Number","does not exceed 15 characters");
}
}

String vTraderName;
vTraderName=medicine.getTraderName();
if(vTraderName==null)
{
// do nothing
}
else
{
vTraderName=vTraderName.trim();
if(vTraderName.length()>30)
{
ve.add("Trader Name","does not exceed 30 characters");
}
}

String vManuMonth;
vManuMonth=medicine.getManuMonth();
if(vManuMonth==null)
{
// do nothing
}
else
{
vManuMonth=vManuMonth.trim();
if(vManuMonth.length()>10)
{
ve.add("Manu Month","does not exceed 10 characters");
}
}

String vManuYear;
vManuYear=medicine.getManuYear();
if(vManuYear==null)
{
// do nothing
}
else
{
vManuYear=vManuYear.trim();
if(vManuYear.length()>4)
{
ve.add("Manu Year","does not exceed 4 characters");
}
}

String vExMonth;
vExMonth=medicine.getExMonth();
if(vExMonth==null)
{
// do nothing
}
else
{
vExMonth=vExMonth.trim();
if(vExMonth.length()>10)
{
ve.add("EX Month","does not exceed 10 characters");
}
}

String vExYear;
vExYear=medicine.getExYear();
if(vExYear==null)
{
// do nothing
}
else
{
vExYear=vExYear.trim();
if(vExYear.length()>4)
{
ve.add("EX Year","does not exceed 4 characters");
}
}

String vBillDate;
vBillDate=medicine.getBillDate();
if(vBillDate==null)
{
// do nothing
}
else
{
vBillDate=vBillDate.trim();
if(vBillDate.length()>2)
{
ve.add("Bill Date","does not exceed 2 characters");
}
}

String vBillMonth;
vBillMonth=medicine.getBillMonth();
if(vBillMonth==null)
{
// do nothing
}
else
{
vBillMonth=vBillMonth.trim();
if(vBillMonth.length()>10)
{
ve.add("Bill Month","does not exceed 10 characters");
}
}

String vBillYear;
vBillYear=medicine.getBillYear();
if(vBillYear==null)
{
// do nothing
}
else
{
vBillYear=vBillYear.trim();
if(vBillYear.length()>4)
{
ve.add("Bill Year","does not exceed 4 characters");
}
}

if(ve.size()>0)
{
throw ve;
}
MedicineDAOInterface medicineDAO;
medicineDAO=new MedicineDAO();
MedicineDTOInterface medicineDTO;
medicineDTO=new MedicineDTO();
try
{
medicineDTO.setName(medicine.getName().toUpperCase());
medicineDTO.setCategory(medicine.getCategory().toUpperCase());
medicineDTO.setBuyingCost(medicine.getBuyingCost());
medicineDTO.setMRP(medicine.getMRP());
medicineDTO.setTraderName(medicine.getTraderName().toUpperCase());
medicineDTO.setBillNumber(medicine.getBillNumber());
medicineDTO.setManuMonth(medicine.getManuMonth().toUpperCase());
medicineDTO.setManuYear(medicine.getManuYear());
medicineDTO.setExMonth(medicine.getExMonth().toUpperCase());
medicineDTO.setExYear(medicine.getExYear());
medicineDTO.setBillDate(medicine.getBillDate());
medicineDTO.setBillMonth(medicine.getBillMonth().toUpperCase());
medicineDTO.setBillYear(medicine.getBillYear());
medicineDTO.setAmmountOfMedicine(medicine.getAmmountOfMedicine());
System.out.println("updating");
medicineDAO.update(medicineDTO);
System.out.println("updated");
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
MedicineInterface medicine2;
medicine2=medicineNameWiseMap.get(vName.toUpperCase());
medicine2.setName(medicine.getName().toUpperCase());
medicine2.setCategory(medicine.getCategory().toUpperCase());
medicine2.setBuyingCost(medicine.getBuyingCost());
medicine2.setMRP(medicine.getMRP());
medicine2.setTraderName(medicine.getTraderName().toUpperCase());
medicine2.setBillNumber(medicine.getBillNumber());
medicine2.setManuMonth(medicine.getManuMonth().toUpperCase());
medicine2.setManuYear(medicine.getManuYear());
medicine2.setExMonth(medicine.getExMonth().toUpperCase());
medicine2.setExYear(medicine.getExYear());
medicine2.setBillDate(medicine.getBillDate());
medicine2.setBillMonth(medicine.getBillMonth().toUpperCase());
medicine2.setBillYear(medicine.getBillYear());
medicine2.setAmmountOfMedicine(medicine.getAmmountOfMedicine());
int count=0;
for(MedicineInterface m:medicinesList)
{
if(m.getName().toUpperCase().equalsIgnoreCase(vName.toUpperCase()))
{
medicinesList.remove(count);
break;
}
count++;
}
medicinesList.add(medicine2);
Collections.sort(medicinesList,new Comparator<MedicineInterface>(){
public int compare(MedicineInterface left,MedicineInterface right)
{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}
});
}


public List<MedicineInterface> getExpiry() throws ProcessException
{
List<MedicineInterface> medicinesExpiryList=new LinkedList<>();

try
{
List<MedicineDTOInterface> dlMedicinesExpiryList;
dlMedicinesExpiryList=new MedicineDAO().getExpiry();
MedicineInterface medicine;
for(MedicineDTOInterface dlMedicine:dlMedicinesExpiryList)
{
medicine=new Medicine();
medicine.setName(dlMedicine.getName().toUpperCase());
medicine.setCategory(dlMedicine.getCategory().toUpperCase());
medicine.setBuyingCost(dlMedicine.getBuyingCost());
medicine.setMRP(dlMedicine.getMRP());
medicine.setManuMonth(dlMedicine.getManuMonth().toUpperCase());
medicine.setManuYear(dlMedicine.getManuYear());
medicine.setManuMonthNumber(dlMedicine.getManuMonthNumber());
medicine.setExMonth(dlMedicine.getExMonth().toUpperCase());
medicine.setExYear(dlMedicine.getExYear());
medicine.setExMonthNumber(dlMedicine.getExMonthNumber());
medicine.setBillDate(dlMedicine.getBillDate());
medicine.setBillMonth(dlMedicine.getBillMonth().toUpperCase());
medicine.setBillYear(dlMedicine.getBillYear());
medicine.setTraderName(dlMedicine.getTraderName().toUpperCase());
medicine.setBillNumber(dlMedicine.getBillNumber());
medicine.setAmmountOfMedicine(dlMedicine.getAmmountOfMedicine());
medicinesExpiryList.add(medicine);
}
Collections.sort(medicinesExpiryList,new Comparator<MedicineInterface>(){
public int compare(MedicineInterface left,MedicineInterface right)
{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}
});
}catch(DAOException dao)
{
System.out.println(dao);
}
return medicinesExpiryList;
}

  	 	
public boolean sell(String patientName,String medicineName,int ammount)throws ValidationException,ProcessException
{
boolean success;
ValidationException ve;
ve =new ValidationException();
if(patientName==null)
{
ve.add("Patient Name","Required");
}
else
{
if(patientName.length()==0)
{
ve.add("Patient Name","Required");
}
}
if(medicineName==null)
{
ve.add("Medicine Name","Required");
}
else
{
if(medicineName.length()==0)
{
ve.add("Medicine Name","Required");
}
}
if(ammount==0)
{
ve.add("Ammount","Requied");
}
if(ve.size()>0)
{
throw ve;
}
MedicineDAOInterface medicineDAO;
medicineDAO=new MedicineDAO();
try
{
success=medicineDAO.sell(patientName,medicineName,ammount);
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
int count=0;
MedicineInterface medicine2=new Medicine();
for(MedicineInterface m:medicinesList)
{
if(m.getName().toUpperCase().equalsIgnoreCase(medicineName.toUpperCase()))
{
medicine2.setName(m.getName().toUpperCase());
medicine2.setCategory(m.getCategory().toUpperCase());
medicine2.setBuyingCost(m.getBuyingCost());
medicine2.setMRP(m.getMRP());
medicine2.setTraderName(m.getTraderName().toUpperCase());
medicine2.setBillNumber(m.getBillNumber());
medicine2.setManuMonth(m.getManuMonth().toUpperCase());
medicine2.setManuYear(m.getManuYear());
medicine2.setExMonth(m.getExMonth().toUpperCase());
medicine2.setExYear(m.getExYear());
medicine2.setBillDate(m.getBillDate());
medicine2.setBillMonth(m.getBillMonth().toUpperCase());
medicine2.setBillYear(m.getBillYear());
int newAmount=m.getAmmountOfMedicine()-ammount;
medicine2.setAmmountOfMedicine(newAmount);
medicinesList.remove(count);
medicinesList.add(medicine2);
break;
}
count++;
}
Collections.sort(medicinesList,new Comparator<MedicineInterface>(){
public int compare(MedicineInterface left,MedicineInterface right)
{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}
});
medicineNameWiseMap.remove(medicineName.toUpperCase());
medicineNameWiseMap.put(medicineName.toUpperCase(),medicine2);
System.out.println("selled");
return success;
}

public List<SellDetailsInterface> getDayReport(int date,int month,int year) throws ProcessException
{
List<SellDetailsInterface> report=new LinkedList<>();
try
{
List<SellDetailsDTOInterface> dlReport;
dlReport=new MedicineDAO().getDayReport(date,month,year);
SellDetailsInterface sellDetails;
for(SellDetailsDTOInterface sd:dlReport)
{
sellDetails=new SellDetails();
sellDetails.setPatientName(sd.getPatientName().toUpperCase());
sellDetails.setMedicineName(sd.getMedicineName().toUpperCase());
sellDetails.setAmount(sd.getAmount());
sellDetails.setTodayDate(sd.getTodayDate());
sellDetails.setTodayMonth(sd.getTodayMonth());
sellDetails.setTodayYear(sd.getTodayYear());
report.add(sellDetails);
}
}catch(DAOException dao)
{
System.out.println(dao);
}
return report;
}

public List<SellDetailsInterface> getMonthReport(int month,int year) throws ProcessException
{
List<SellDetailsInterface> report=new LinkedList<>();
try
{
List<SellDetailsDTOInterface> dlReport;
dlReport=new MedicineDAO().getMonthReport(month,year);
SellDetailsInterface sellDetails;
for(SellDetailsDTOInterface sd:dlReport)
{
sellDetails=new SellDetails();
sellDetails.setPatientName(sd.getPatientName().toUpperCase());
sellDetails.setMedicineName(sd.getMedicineName().toUpperCase());
sellDetails.setAmount(sd.getAmount());
sellDetails.setTodayDate(sd.getTodayDate());
sellDetails.setTodayMonth(sd.getTodayMonth());
sellDetails.setTodayYear(sd.getTodayYear());
report.add(sellDetails);
}
}catch(DAOException dao)
{
System.out.println(dao);
}
return report;
}

public boolean findName(String name) throws ProcessException
{
boolean success=false;
for(MedicineInterface m:medicinesList)
{
if(m.getName().toUpperCase().equalsIgnoreCase(name.toUpperCase()))
{
success=true;
}
}
return success;
}

}