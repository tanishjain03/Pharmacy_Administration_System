import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import java.util.*;
import java.math.*;
import java.io.*;
class medicineDAOGetAllTest
{
    public static void main(String data[]) throws DAOException
    {
        MedicineDTOInterface medicineDTO;
        List<MedicineDTOInterface> medicines;
        MedicineDAO medicineDAO=new MedicineDAO();
        medicines=medicineDAO.getAll();
        for(int i=0;i<medicines.size();i++)
        {
            medicineDTO=medicines.get(i);
            System.out.println(medicineDTO.getName()+",");
            System.out.println(medicineDTO.getCategory()+",");
            System.out.println(medicineDTO.getBuyingCost().toPlainString()+",");
            System.out.println(medicineDTO.getMRP().toPlainString()+",");            
            System.out.println(medicineDTO.getBillNumber()+",");
            System.out.println(medicineDTO.getTraderName()+",");
            System.out.println(medicineDTO.getManufacturingFullDate()+",");
            System.out.println(medicineDTO.getExpiryFullDate()+",");
            System.out.println(medicineDTO.getBillFullDate()+",");
            System.out.println(medicineDTO.getAmmountOfMedicine());
            System.out.println("-------------------------------------");

        }
        
    }
    
}
