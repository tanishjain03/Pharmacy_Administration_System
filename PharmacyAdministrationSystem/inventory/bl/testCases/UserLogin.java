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
class UserLogin
{
public static void main(String data[])
{
String userName=data[0].trim();
String passward=data[1].trim();
UserManager userManager;
userManager=new UserManager();
try
{
boolean login;
login=userManager.login(userName,passward);
if(login==true) System.out.println("logged in successful");
else  System.out.println("logged in Unsuccessful");
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