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
public class UserSettingsModel
{
private UserManager userManager;
private UserInterface userInterface;
public UserSettingsModel()
{
userManager=new UserManager();
}
public boolean add(String userName,String password)
{
try
{
boolean success=false;
userInterface=new User();
userInterface.setUserName(userName);
userInterface.setPassward(password);
success=userManager.add(userInterface);
return success;
}catch(ProcessException pe)
{
return false;
}
catch(ValidationException ve)
{
return false;
}
}

public boolean changePassword(String userName,String oldPassword,String newPassword)
{
try
{
boolean success=false;
success=userManager.changePassward(userName,oldPassword,newPassword);
return success;
}catch(ProcessException pe)
{
return false;
}
catch(ValidationException ve)
{
return false;
}

}





}