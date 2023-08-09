package com.swastik.medical.inventory.dbdl;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.net.*;
import java.sql.*;
public class UserDAO implements UserDAOInterface
{


public boolean add(UserDTOInterface userDTO) throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select userName from users where userName=?");
ps.setString(1,userDTO.getUserName());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
rs.close();
ps.close();
c.close();
return false;
}
ps=c.prepareStatement("insert into users (userName,passward,masterPassward) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
ps.setString(1,userDTO.getUserName().trim());
ps.setString(2,userDTO.getPassward().trim());
ps.setString(3,userDTO.getMasterPassward().trim());
ps.executeUpdate();
rs=ps.getGeneratedKeys();
rs.next();
rs.close();
ps.close();
c.close();
return true;
}catch(Exception e)
{
return false;
}
}



public void delete(String userName) throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps=c.prepareStatement("select userName from users where userName=?");
ps.setString(1,userName);
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("User doesnot exists");
}
r.close();
ps.close();
ps=c.prepareStatement("delete from users where userName=?");
ps.setString(1,userName);
ps.executeUpdate();
ps.close();
c.close();
}catch(SQLException sqlException)
{
throw new DAOException("Unable to remove User");
}
}


public void update(UserDTOInterface userDTO,String newPassward) throws DAOException
{
String vUserName=userDTO.getUserName();
String vPassward=userDTO.getPassward();
try
{
Connection c=DAOConnection.getConnection();
PreparedStatement ps;
ps=c.prepareStatement("select * from users where userName=?");
ps.setString(1,vUserName);
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("Invalid UserName");
}
else
{
String userName=r.getString("userName");
String oldPassward=r.getString("passward").trim();
String masterPassward=r.getString("masterPassward").trim();
r.close();
ps.close();
if(vPassward.equals(oldPassward) || vPassward.equals(masterPassward))
{
ps=c.prepareStatement("update users set passward=? where userName=?");
ps.setString(1,newPassward);
ps.setString(2,userName);
ps.executeUpdate();
ps.close();
c.close();
}
else
{
c.close();
throw new DAOException("Invalid UserName");
}
}
}catch(SQLException sqlException)
{
throw new DAOException("Unable to update");
}
}


public List<UserDTOInterface> getAllUser() throws DAOException
{
try
{
List<UserDTOInterface> users;
users=new LinkedList<>();
String userName;
UserDTOInterface userDTO;
Connection c=DAOConnection.getConnection();
Statement s=c.createStatement();
ResultSet r;
r=s.executeQuery("select userName from users order by userName");
while(r.next())
{
userDTO=new UserDTO();
userName=r.getString("userName").trim();
userDTO.setUserName(userName);
users.add(userDTO);
}
r.close();
s.close();
c.close();
return users;
}catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch user");
}
}


public boolean login(String vUserName,String vPassward) throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
String passward="";
String masterPassward="";
PreparedStatement ps;
ps=c.prepareStatement("select userName from users where userName=?");
ps.setString(1,vUserName);
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("Invalid UserName");
}
r.close();
ps.close();
ps=c.prepareStatement("select passward,masterPassward from users where userName=?");
ps.setString(1,vUserName);
r=ps.executeQuery();
if(r.next())
{
passward=r.getString("passward").trim();
masterPassward=r.getString("masterPassward").trim();
}
r.close();
ps.close();
c.close();
if(vPassward.equals(passward) || vPassward.equals(masterPassward)) 
{
return true;
}
else
{
return false;
}
}catch(SQLException sqlException)
{
throw new DAOException("Unable to update");
}
}


public boolean changePassward(String vUserName,String vPassward,String vNewPassward) throws DAOException
{
try
{
Connection c=DAOConnection.getConnection();
String passward="";
String masterPassward="";
PreparedStatement ps;
ps=c.prepareStatement("select userName from users where userName=?");
ps.setString(1,vUserName);
ResultSet r;
r=ps.executeQuery();
if(r.next()==false)
{
r.close();
ps.close();
c.close();
throw new DAOException("Invalid UserName");
}
r.close();
ps.close();
ps=c.prepareStatement("select passward,masterPassward from users where userName=?");
ps.setString(1,vUserName);
r=ps.executeQuery();
if(r.next())
{
passward=r.getString("passward").trim();
masterPassward=r.getString("masterPassward").trim();
}
r.close();
ps.close();
if(vPassward.equals(passward) || vPassward.equals(masterPassward)) 
{
ps=c.prepareStatement("update users set passward=? where userName=?");
ps.setString(1,vNewPassward);
ps.setString(2,vUserName);
ps.executeUpdate();
ps.close();
c.close();
return true;
}
else
{
c.close();
return false;
}
}catch(SQLException sqlException)
{
throw new DAOException("Unable to update");
}
}

}