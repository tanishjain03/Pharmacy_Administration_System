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
class MedicineAdd
{
public static void main(String data[])
{
MedicineInterface medicine;
medicine=new Medicine();
medicine.setName(data[0]);
medicine.setCategory(data[1]);
medicine.setBuyingCost(new BigDecimal(data[2]));
medicine.setMRP(new BigDecimal(data[3]));
medicine.setTraderName(data[4]);
medicine.setBillNumber(data[5]);
medicine.setManuMonth(data[6]);
medicine.setManuYear(data[7]);
medicine.setExMonth(data[8]);
medicine.setExYear(data[9]);
medicine.setBillDate(data[10]);
medicine.setBillMonth(data[11]);
medicine.setBillYear(data[12]);
medicine.setAmmountOfMedicine(Integer.parseInt(data[13]));
MedicineManager medicineManager;
medicineManager=new MedicineManager();
try
{
medicineManager.add(medicine);
}catch(ValidationException ve)
{
String[] properties;
properties=ve.getProperties();
for(String v:properties)
{
System.out.println(v+" "+ve.getExceptions(v));
}
}
catch(ProcessException pe)
{
System.out.println(pe.getMessage());
}
}
}