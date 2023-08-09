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
public class GetExpiryModel extends AbstractTableModel
{
private java.util.List<MedicineInterface> medicines;
private MedicineManager medicineManager;
private String [] title={"Name","Expiry Date","Stock","Trader Name"};
public GetExpiryModel()
{
medicineManager=new MedicineManager();
try
{
medicines=medicineManager.getExpiry();
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
return 4;
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
return medicines.get(ri).getExpiryFullDate();
}
if(ci==2)
{
return medicines.get(ri).getAmmountOfMedicine();
}
if(ci==3)
{
return medicines.get(ri).getTraderName();
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
if(c==3) b=Class.forName("java.lang.String");
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





}