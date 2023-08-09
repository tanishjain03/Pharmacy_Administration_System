import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.pojo.*;
import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import java.util.*;
import java.math.*;
class MedicineGetByName
{
public static void main(String data[])
{
MedicineInterface medicine;
medicine=new Medicine();
MedicineManager medicineManager;
medicineManager=new MedicineManager();
String name=data[0];
try
{
medicine=medicineManager.getByName(name);
System.out.println(medicine.getName()+",");
System.out.println(medicine.getCategory()+",");
System.out.println(medicine.getBuyingCost().toPlainString()+",");
System.out.println(medicine.getMRP().toPlainString()+",");            
System.out.println(medicine.getBillNumber()+",");
System.out.println(medicine.getTraderName()+",");
System.out.println(medicine.getManufacturingFullDate()+",");
System.out.println(medicine.getExpiryFullDate()+",");
System.out.println(medicine.getBillFullDate()+",");
System.out.println(medicine.getAmmountOfMedicine());
System.out.println("-------------------------------------");

}catch(ProcessException pe)
{
System.out.println(pe.getMessage());
}
}
}