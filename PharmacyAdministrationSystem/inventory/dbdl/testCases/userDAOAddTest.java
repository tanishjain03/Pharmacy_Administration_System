import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class userDAOAddTest
{
    public static void main(String data[])
    {
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName(data[0].trim());
        userDTO.setPassward(data[1].trim());
       
        UserDAO userDAO=new UserDAO();
        try
        {
	    boolean s=false;
            s=userDAO.add(userDTO);
            if(s) System.out.println(userDTO.getUserName()+" - User added");
            else System.out.println("not added");
        }catch(DAOException dao)
        {
            System.out.println(dao);
            
        }


    }
}