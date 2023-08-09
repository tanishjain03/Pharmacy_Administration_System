import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import java.io.*;
import java.math.*;
import java.util.*;
class medicineDAOGetByCodeTest
{
    public static void main(String gg[])
    {
        try
        {
            MedicineDAOInterface medicineDAO=new MedicineDAO();
            MedicineDTOInterface medicineDTO=medicineDAO.getByCode(Integer.parseInt(gg[0]));
            System.out.println("Code: " + medicineDTO.getCode());
        System.out.println("Name: " + medicineDTO.getName());
        System.out.println("Category: " + medicineDTO.getCategory());
        System.out.println("Buying Cost: " + medicineDTO.getBuyingCost().toPlainString());
        System.out.println("MRP: " + medicineDTO.getMRP().toPlainString());
System.out.println("Bill Number: " + medicineDTO.getBillNumber());
System.out.println("Trader Name: " + medicineDTO.getTraderName());
System.out.println("Manufacturing Date: " + medicineDTO.getManufacturingFullDate());
System.out.println("Expiry Date: " + medicineDTO.getExpiryFullDate());
System.out.println("Bill Date: " + medicineDTO.getBillFullDate());
System.out.println("Stock: " + medicineDTO.getAmmountOfMedicine());

            
        }
        catch(DAOException dao)
        {
            System.out.println(dao.getMessage());
            
        }
        
    }
    
}
