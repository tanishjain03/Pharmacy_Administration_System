import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class userDAOChangePasswardTest
{
    public static void main(String data[])
    {
	String userName=data[0].trim();
	String passward=data[1].trim();
	String newPassward=data[2].trim();
	boolean b;
	UserDAO userDAO=new UserDAO();
	try
        {

            b=userDAO.changePassward(userName,passward,newPassward);
            if(b==true) System.out.println("passward changed successful");
	    else System.out.println("passward changed unsuccessful");
        }catch(DAOException dao)
        {
            System.out.println(dao);
            
        }


    }
}