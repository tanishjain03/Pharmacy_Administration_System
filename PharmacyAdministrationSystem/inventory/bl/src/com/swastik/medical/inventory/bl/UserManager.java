package com.swastik.medical.inventory.bl;
import com.swastik.medical.inventory.bl.Exceptions.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.pojo.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import java.util.*;
import java.math.*;
public class UserManager
{
public boolean add(UserInterface user) throws ValidationException,ProcessException
{
boolean success=false;
ValidationException ve;
ve =new ValidationException();
if(user==null)
{
ve.add("User","Required");
throw ve;
}
String vUserName;
vUserName=user.getUserName();
if(vUserName==null)
{
ve.add("User Name","Required");
}
String vPassward;
vPassward=user.getPassward();
if(vPassward==null)
{
ve.add("Passward","Required");
}
if(ve.size()!=0)
{
return false;
}
UserDAOInterface userDAO;
userDAO=new UserDAO();
UserDTOInterface userDTO;
userDTO=new UserDTO();
userDTO.setUserName(user.getUserName());
userDTO.setPassward(user.getPassward());
userDTO.setMasterPassward(user.getMasterPassward());
try
{
success=userDAO.add(userDTO);
return success;
}catch(DAOException dao)
{
return false;
}
}


public void delete(String userName) throws ValidationException,ProcessException
{
ValidationException ve;
ve=new ValidationException();
if(userName==null)
{
ve.add("User Name","Required");
}
if(ve.size()>0)
{
throw ve;
}
try
{
UserDAOInterface userDAO=new UserDAO();
userDAO.delete(userName);
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
}


public void update(UserInterface user,String newPassward) throws ValidationException,ProcessException
{
ValidationException ve;
ve =new ValidationException();
if(user==null)
{
ve.add("User","Required");
throw ve;
}
String vUserName;
vUserName=user.getUserName();
if(vUserName==null)
{
ve.add("User Name","Required");
}
else
{
vUserName=vUserName.trim();
if(vUserName.length()==0)
{
ve.add("User Name","Required");
}
else if(vUserName.length()>15)
{
ve.add("User Name","does not exceed 15 characters");
}
}
String vPassward;
vPassward=user.getPassward();
if(vPassward==null)
{
ve.add("Passward","Required");
}
else
{
vPassward=vPassward.trim();
if(vPassward.length()==0)
{
ve.add("Passward","Required");
}
else if(vPassward.length()>15)
{
ve.add("Passward","does not exceed 15 characters");
}
}
if(newPassward==null)
{
ve.add("New Passward","Required");
}
else
{
newPassward=newPassward.trim();
if(newPassward.length()==0)
{
ve.add("New Passward","Required");
}
else if(newPassward.length()>15)
{
ve.add("New Passward","does not exceed 15 characters");
}
}

if(ve.size()>0)
{
throw ve;
}
UserDAOInterface userDAO;
userDAO=new UserDAO();
UserDTOInterface userDTO;
userDTO=new UserDTO();
try
{
userDTO.setUserName(user.getUserName());
userDTO.setPassward(user.getPassward());
System.out.println("updating");
userDAO.update(userDTO,newPassward);
System.out.println("updated");
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
}


public boolean login(String vUserName,String vPassward) throws ValidationException,ProcessException
{
ValidationException ve;
ve =new ValidationException();
if(vUserName==null)
{
ve.add("User Name","Required");
}
if(vPassward==null)
{
ve.add("Passward","Required");
}
if(ve.size()!=0)
{
throw ve;
}
UserDAOInterface userDAO;
userDAO=new UserDAO();
try
{
boolean login=false;
login=userDAO.login(vUserName,vPassward);
return login;
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
}


public boolean changePassward(String vUserName,String vPassward,String vNewPassward) throws ValidationException,ProcessException
{
ValidationException ve;
ve =new ValidationException();
if(vUserName==null)
{
ve.add("User Name","Required");
}
else
{
vUserName=vUserName.trim();
if(vUserName.length()==0)
{
ve.add("User Name","Required");
}
else if(vUserName.length()>15)
{
ve.add("User Name","does not exceed 15 characters");
}
}
if(vPassward==null)
{
ve.add("Passward","Required");
}
else
{
vPassward=vPassward.trim();
if(vPassward.length()==0)
{
ve.add("Passward","Required");
}
else if(vPassward.length()>15)
{
ve.add("Passward","does not exceed 15 characters");
}
}
if(vNewPassward==null)
{
ve.add("New Passward","Required");
}
else
{
vNewPassward=vNewPassward.trim();
if(vNewPassward.length()==0)
{
ve.add("New Passward","Required");
}
else if(vNewPassward.length()>15)
{
ve.add("New Passward","does not exceed 15 characters");
}
}
if(ve.size()>0)
{
throw ve;
}
UserDAOInterface userDAO;
userDAO=new UserDAO();
try
{
boolean success=userDAO.changePassward(vUserName,vPassward,vNewPassward);
return success;
}catch(DAOException dao)
{
throw new ProcessException(dao.getMessage());
}
}


}