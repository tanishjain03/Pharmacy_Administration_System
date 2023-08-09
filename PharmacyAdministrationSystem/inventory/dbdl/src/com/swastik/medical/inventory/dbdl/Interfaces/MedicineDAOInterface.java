package com.swastik.medical.inventory.dbdl.Interfaces;
import com.swastik.medical.inventory.dbdl.Interfaces.*;

import com.swastik.medical.inventory.dbdl.Exceptions.*;

import java.util.*;

public interface MedicineDAOInterface

{
public void add(MedicineDTOInterface medicineDTO) throws DAOException;

public void delete(String name) throws DAOException;

public void update(MedicineDTOInterface medicineDTO) throws DAOException;

public MedicineDTOInterface getByName(String name) throws DAOException;

public List<MedicineDTOInterface> getAll() throws DAOException;

public int getCount() throws DAOException;

public List<MedicineDTOInterface> getExpiry() throws DAOException;

public boolean sell(String patientName,String MedicineName,int ammount) throws DAOException;
public List<SellDetailsDTOInterface> getDayReport(int date,int month,int year) throws DAOException;
public List<SellDetailsDTOInterface> getMonthReport(int month,int year) throws DAOException;
}
