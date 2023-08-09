import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import java.util.*;
import java.math.*;
import java.io.*;
class userDAOGetAllUserTest
{
    public static void main(String data[]) throws DAOException
    {
        UserDTOInterface userDTO;
        List<UserDTOInterface> users;
        UserDAO userDAO=new UserDAO();
        users=userDAO.getAllUser();
        for(int i=0;i<users.size();i++)
        {
            userDTO=users.get(i);
            System.out.println(userDTO.getUserName());
        }
        
    }
    
}
