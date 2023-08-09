import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.pojo.*;
import java.util.*;
import java.math.*;
class UserUpdate
{
public static void main(String data[])
{
UserInterface user;
user=new User();
user.setUserName(data[0].trim());
user.setPassward(data[1].trim());
String newPassward=data[2].trim();
UserManager userManager;
userManager=new UserManager();
try
{
userManager.update(user,newPassward);
System.out.println("User Updated");
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