import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class userDAOUpdateTest
{
    public static void main(String data[])
    {
	UserDTO userDTO=new UserDTO();
	userDTO.setUserName(data[0].trim());
        userDTO.setPassward(data[1].trim());
	String newPassward=data[2].trim();
        UserDAO userDAO=new UserDAO();
        try
        {
            userDAO.update(userDTO,newPassward);
            System.out.println("user updated - "+userDTO.getUserName());
            
        }
        catch(Exception e)
        {
e.getStackTrace();         
            
        }
        
    }
    
}
