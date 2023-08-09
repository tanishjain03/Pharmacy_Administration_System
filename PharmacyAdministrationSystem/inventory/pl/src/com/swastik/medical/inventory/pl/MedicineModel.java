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
public class MedicineModel extends AbstractTableModel
{
private java.util.List<MedicineInterface> medicines;
private MedicineManager medicineManager;
private String [] title={"Name","MRP","Stock"};

public MedicineModel()
{
medicineManager=new MedicineManager();
try
{
medicines=medicineManager.getAll();
}catch(Exception e)
{
System.out.println(e);
}
}

public int getRowCount()
{
return medicines.size();
}

public int getColumnCount()
{
return 3;
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
return medicines.get(ri).getName();
}
if(ci==1)
{
return medicines.get(ri).getMRP();
}
if(ci==2)
{
return medicines.get(ri).getAmmountOfMedicine();
}
return null;
}
public Class getColumnClass(int c)
{
try
{
Class b=null;
if(c==0) b=Class.forName("java.lang.String");
if(c==1) b=Class.forName("java.math.BigDecimal");
if(c==2) b=Class.forName("java.lang.Integer");
return b;
}
catch(ClassNotFoundException cnfe)
{
return null;
}
}

public int search(String searchWhat)
{
int index=0;
searchWhat=searchWhat.toUpperCase();
for(MedicineInterface medicine:medicines)
{
if(medicine.getName().toUpperCase().startsWith(searchWhat))
{
return index;
}
index++;
}
return -1;
}

public MedicineInterface getMedicineAt(int index)
{
return medicines.get(index);
}

public void fire()
{
try
{
medicines=medicineManager.getAll();
fireTableDataChanged();
System.out.println("Fire Table");
}catch(ProcessException pe)
{
System.out.println("fire Exception");
}
}

public void add(MedicineInterface medicine)
{
try
{
medicineManager.add(medicine);
medicines=medicineManager.getAll();
fireTableDataChanged();
}
catch(ProcessException pe)
{
return;
}
catch(ValidationException ve)
{
return;
}
}

public void update(MedicineInterface medicine)
{
try
{
medicineManager.update(medicine);
medicines=medicineManager.getAll();
fireTableDataChanged();
}
catch(ProcessException pe)
{
return;
}
catch(ValidationException ve)
{
return;
}
}
public void delete(String name)
{
try
{
medicineManager.delete(name);
medicines=medicineManager.getAll();
fireTableDataChanged();
}
catch(ProcessException pe)
{
return;
}
catch(ValidationException ve)
{
return;
}
}

public boolean findName(String name)
{
boolean s;
try
{
s=medicineManager.findName(name);
}
catch(ProcessException pe)
{
return false;
}
return s;
}

public boolean sell(String patientName,String medicineName,String amount)
{
try
{
boolean success;
success=medicineManager.sell(patientName,medicineName,Integer.parseInt(amount));
medicines=medicineManager.getAll();
fireTableDataChanged();
return success;
}
catch(ProcessException pe)
{
return false;
}
catch(ValidationException ve)
{
return false;
}
}

}