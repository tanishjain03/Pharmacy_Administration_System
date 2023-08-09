package com.swastik.medical.inventory.dbdl;
import java.sql.*;
public class DAOConnection
{
public static Connection getConnection()
{
Connection connection=null;
try
{
Class.forName("org.apache.derby.jdbc.ClientDriver");
connection=DriverManager.getConnection("jdbc:derby://localhost:1527/Medicines");
}catch(Exception exception)
{
System.out.println(exception);
}
return connection;
}
}