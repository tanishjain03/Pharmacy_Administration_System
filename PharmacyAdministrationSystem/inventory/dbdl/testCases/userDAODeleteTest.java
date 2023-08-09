import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class userDAODeleteTest
{
    public static void main(String data[])
    {
        UserDAO userDAO=new UserDAO();
        try
        {
            userDAO.delete(data[0]);
            System.out.println("User deleted with username"+" "+data[0]);
            
        }
        catch(DAOException dao)
        {
            System.out.println(dao.getMessage());
            
        }
        
    }
    
}
