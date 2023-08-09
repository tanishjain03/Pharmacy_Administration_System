import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class medicineDAODeleteTest
{
    public static void main(String data[])
    {
        MedicineDAO medicineDAO=new MedicineDAO();
        try
        {
            medicineDAO.delete(data[0]);
            System.out.println("Item deleted");
            
        }
        catch(DAOException dao)
        {
            System.out.println(dao.getMessage());
            
        }
        
    }
    
}
