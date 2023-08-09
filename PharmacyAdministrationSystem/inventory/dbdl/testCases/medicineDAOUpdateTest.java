import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class medicineDAOUpdateTest
{
    public static void main(String data[])
    {
	MedicineDTO medicineDTO=new MedicineDTO();
        medicineDTO.setName(data[0].trim());
        medicineDTO.setCategory(data[1].trim());
        medicineDTO.setBuyingCost(new BigDecimal(data[2].trim()));
        medicineDTO.setMRP(new BigDecimal(data[3].trim()));
	medicineDTO.setBillNumber(data[4].trim());
	medicineDTO.setTraderName(data[5].trim());
	medicineDTO.setManuMonth(data[6].trim());        
	medicineDTO.setManuYear(data[7].trim());
	medicineDTO.setExMonth(data[8].trim());        
	medicineDTO.setExYear(data[9].trim());
	medicineDTO.setBillDate(data[10].trim());
	medicineDTO.setBillMonth(data[11].trim());        
	medicineDTO.setBillYear(data[12].trim());
	medicineDTO.setAmmountOfMedicine(Integer.parseInt(data[13].trim()));
	MedicineDAO medicineDAO=new MedicineDAO();
        try
        {
            medicineDAO.update(medicineDTO);
            System.out.println("Medicine updated with name"+" "+medicineDTO.getName());
            
        }
        catch(DAOException dao)
        {
             System.out.println(dao.getMessage());
     
         
         
        }
        
    }
    
}
