import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.bl.pojo.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.Exceptions.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.swing.table.*;
public class ViewReportModel extends AbstractTableModel
{
private java.util.List<SellDetailsInterface> report;
private MedicineManager medicineManager;
private String [] title={"Patient Name","Medicine Name","Quantity","Date","Month","Year"};
public ViewReportModel()
{
medicineManager=new MedicineManager();
}

public void getDateReport(int date,int month,int year)
{
try
{
report=medicineManager.getDayReport(date,month,year);
}catch(Exception e)
{
System.out.println(e);
}
}

public void getMonthReport(int month,int year)
{
try
{
report=medicineManager.getMonthReport(month,year);
}catch(Exception e)
{
System.out.println(e);
}
}

public int getRowCount()
{
return report.size();
}

public int getColumnCount()
{
return 6;
}

public String getColumnName(int ci)
{
return title[ci];
}

public boolean isCellEditable(int ri,int ci)
{
return false;
}

public Object getValueAt(int ri,int ci)
{
if(ci==0)
{
return report.get(ri).getPatientName();
}
if(ci==1)
{
return report.get(ri).getMedicineName();
}
if(ci==2)
{
return report.get(ri).getAmount();
}
if(ci==3)
{
return report.get(ri).getTodayDate();
}
if(ci==4)
{
return report.get(ri).getTodayMonth();
}
if(ci==5)
{
return report.get(ri).getTodayYear();
}
return null;
}

public Class getColumnClass(int c)
{
try
{
Class b=null;
if(c==0) b=Class.forName("java.lang.String");
if(c==1) b=Class.forName("java.lang.String");
if(c==2) b=Class.forName("java.lang.Integer");
if(c==3) b=Class.forName("java.lang.Integer");
if(c==4) b=Class.forName("java.lang.Integer");
if(c==5) b=Class.forName("java.lang.Integer");
return b;
}
catch(ClassNotFoundException cnfe)
{
return null;
}
}

public SellDetailsInterface getDetailsAt(int index)
{
return report.get(index);
}
}