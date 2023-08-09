import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class medicineDAOGetCountTest
{
    public static void main(String data[])
    {
        MedicineDAO medicineDAO=new MedicineDAO();
        try
        {
            int x=0;
            x=medicineDAO.getCount();
            System.out.println("Numbers of items are: "+x);
            
        }
        catch(DAOException dao)
        {
            System.out.println(dao.getMessage());
            
        }
        
    }
    
}
