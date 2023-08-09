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
public class UserModel
{
private UserManager userManager;
public UserModel()
{
userManager=new UserManager();
}
public boolean login(String userName,String passward)
{
try
{
boolean success;
success=userManager.login(userName,passward);
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