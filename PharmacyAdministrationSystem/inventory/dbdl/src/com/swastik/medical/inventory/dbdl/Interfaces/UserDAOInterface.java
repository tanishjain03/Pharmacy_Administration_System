package com.swastik.medical.inventory.dbdl.Interfaces;
import com.swastik.medical.inventory.dbdl.Interfaces.*;

import com.swastik.medical.inventory.dbdl.Exceptions.*;

import java.util.*;

public interface UserDAOInterface

{
public boolean add(UserDTOInterface userDTO) throws DAOException;

public void delete(String userName) throws DAOException;

public void update(UserDTOInterface userDTO,String newPassward) throws DAOException;

public List<UserDTOInterface> getAllUser() throws DAOException;
public boolean login(String vUserName,String vPassward) throws DAOException;
public boolean changePassward(String vUserName,String vPassward,String vNewPassward) throws DAOException;
}