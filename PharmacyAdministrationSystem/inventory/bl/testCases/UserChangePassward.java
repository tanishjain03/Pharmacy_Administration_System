import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.pojo.*;
import java.util.*;
import java.math.*;
class UserChangePassward
{
public static void main(String data[])
{
String userName=data[0].trim();
String passward=data[1].trim();
String newPassward=data[2].trim();
UserManager userManager;
userManager=new UserManager();
try
{
boolean success;
success=userManager.changePassward(userName,passward,newPassward);
if(success==true) System.out.println("logged in successful");
else  System.out.println("logged in Unsuccessful");
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