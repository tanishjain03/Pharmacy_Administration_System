import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class medicineDAOSellTest
{
    public static void main(String data[])
    {
String patientName=data[0].trim();
String medicineName=data[1].trim();
int ammount=Integer.parseInt(data[2].trim());
        MedicineDAO medicineDAO=new MedicineDAO();
        try
        {
boolean s=false;
            s=medicineDAO.sell(patientName,medicineName,ammount);
	    if(s) System.out.println(ammount+"-"+medicineName+" selled to "+patientName);
	    else System.out.println("not selled");
	}catch(DAOException dao)
        {
            System.out.println(dao.getMessage());
            
        }
    }
}