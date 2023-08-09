import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.pojo.*;
import java.util.*;
import java.math.*;
class MedicineUpdate
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
medicine.setBillNumber(data[11]);
medicine.setBillYear(data[12]);
medicine.setAmmountOfMedicine(Integer.parseInt(data[13]));
MedicineManager medicineManager;
medicineManager=new MedicineManager();
try
{
medicineManager.update(medicine);
System.out.println("Medicine Updated");
}catch(ValidationException ve)
{
String[] properties;
properties=ve.getProperties();
for(String s:properties)
{
System.out.println(s+"\n");
}
}
catch(ProcessException pe)
{
System.out.println(pe.getMessage());
}
}
}