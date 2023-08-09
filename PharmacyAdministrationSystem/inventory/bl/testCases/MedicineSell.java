import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.pojo.*;
import java.util.*;
import java.math.*;
class MedicineSell
{
public static void main(String data[])
{
String name=data[0].trim();
int ammount=Integer.parseInt(data[1].trim());
MedicineManager medicineManager;
medicineManager=new MedicineManager();
try
{
medicineManager.sell(name,ammount);
System.out.println("Medicine Selled");
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