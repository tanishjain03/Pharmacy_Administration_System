package com.swastik.medical.inventory.bl.Exceptions;
import java.util.*;
public class ValidationException extends Exception
{
    private HashMap<String,String> exceptions;
    public ValidationException()
    {
        exceptions=new HashMap<String,String>();
        
    }
    public void add(String property,String exception)
    {
        this.exceptions.put(property,exception);
        
    }
    public String getExceptions(String property)
    {
        return this.exceptions.get(property);
        
    }
    public String[] getProperties()
    {
        return this.exceptions.keySet().toArray(new String[this.exceptions.size()]);
        
    }
    public boolean containsProperty(String property)
    {
        return this.exceptions.containsKey(property);
        
    }
    public int size()
    {
        return this.exceptions.size();
        
    }
    
}
