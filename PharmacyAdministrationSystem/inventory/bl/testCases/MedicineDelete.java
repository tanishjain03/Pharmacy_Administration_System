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
class MedicineDelete
{
public static void main(String data[])
{
MedicineManager medicineManager;
medicineManager=new MedicineManager();
String name=data[0].trim();
try
{
medicineManager.delete(name);
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