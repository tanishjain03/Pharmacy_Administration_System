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
class UserAdd
{
public static void main(String data[])
{
UserInterface user;
user=new User();
user.setUserName(data[0]);
user.setPassward(data[1]);
UserManager userManager;
userManager=new UserManager();
try
{
boolean s;
s=userManager.add(user);
if(s)System.out.println("added");
else System.out.println("not added");
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