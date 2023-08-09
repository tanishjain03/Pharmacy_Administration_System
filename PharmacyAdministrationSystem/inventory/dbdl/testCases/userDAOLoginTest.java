import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class userDAOLoginTest
{
    public static void main(String data[])
    {
	String userName=data[0].trim();
	String passward=data[1].trim();
	boolean b;
	UserDAO userDAO=new UserDAO();
	try
        {

            b=userDAO.login(userName,passward);
            if(b==true) System.out.println("login successful");
	    else System.out.println("login unsuccessful");
        }catch(DAOException dao)
        {
            System.out.println(dao);
            
        }


    }
}