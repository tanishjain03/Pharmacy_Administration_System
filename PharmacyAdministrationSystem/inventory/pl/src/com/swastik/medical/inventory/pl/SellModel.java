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
public class SellModel
{
private MedicineManager medicineManager;
public SellModel()
{
medicineManager=new MedicineManager();
}
public boolean sell(String patientName,String medicineName,String amount)
{
try
{
boolean success;
success=medicineManager.sell(patientName,medicineName,Integer.parseInt(amount));
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