import com.swastik.medical.inventory.dbdl.Interfaces.*;
import com.swastik.medical.inventory.dbdl.pojo.*;
import com.swastik.medical.inventory.dbdl.*;
import com.swastik.medical.inventory.dbdl.Exceptions.*;
import java.math.*;
import java.util.*;
class medicineDAOTodayReportTest
{
public static void main(String data[])
{
try
{
int m=Integer.parseInt(data[0].trim());
int y=Integer.parseInt(data[1].trim());
//int y=Integer.parseInt(data[2].trim());
SellDetailsDTOInterface sellDetailsDTO;
List<SellDetailsDTOInterface> s;
MedicineDAO medicineDAO=new MedicineDAO();
s=medicineDAO.getMonthReport(m,y);
for(int i=0;i<s.size();i++)
{
sellDetailsDTO=s.get(i);
System.out.println(sellDetailsDTO.getPatientName()+",");
System.out.println(sellDetailsDTO.getMedicineName()+",");
System.out.println(sellDetailsDTO.getAmount()+",");
System.out.println(sellDetailsDTO.getTodayDate()+",");
System.out.println(sellDetailsDTO.getTodayMonth()+",");
System.out.println(sellDetailsDTO.getTodayYear()+",");
System.out.println("------------------");
}
}
catch(Exception e)
{
System.out.println(e);
}        
}
}