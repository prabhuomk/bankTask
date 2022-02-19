package bankinglogic;

import customerinfo.CustomerInfo;
import accountinfo.AccountInfo;
import cache.CacheStorage;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.Properties;
import storageinterface.DataStorage;
import proexception.ProException;

public class BankingLogic {
	
	CacheStorage cache=new CacheStorage();
	
	Properties property=new Properties();
	
	DataStorage store=null;
	
	public BankingLogic()throws ProException
	{
		loadInterface();
		
		loadData();
			
	}
	
	private void loadInterface()throws ProException 
	{
		try
	       {
	       
	       
	               FileReader readData = new FileReader("className.txt");
	       
	               BufferedReader buffer = new BufferedReader(readData);
	 
	               property.load(buffer);
	       
	               String name=property.getProperty("key");
   
                   Class className=Class.forName(name);
            
                   Object object=className.getDeclaredConstructor().newInstance();
            
                   store = (DataStorage)object;
            
            
           }
		 catch(Exception e)
	       {
	         
	          throw new ProException(e);
	       
	       }
        
	      
	}
	
	private void loadData()throws ProException
	{
         Map<Integer,CustomerInfo> customerMap=store.readCustomer();
		
		 Map<Integer,Map<Integer,AccountInfo>> accountMap=store.readAccount();
		
		 cache.setData(customerMap,accountMap);
	}
	
	
	
	public void addCustomer(CustomerInfo customerInfo)throws ProException
	{
		  int customerId=store.addCustomer(customerInfo);
		  
		  cache.addCustomer(customerId,customerInfo);
		  
	}
	
	public CustomerInfo getCustomer(int customerId)
	{
		return cache.getCustomer(customerId);
	}
	
	public void addAccount(AccountInfo accountInfo)throws ProException
	{
		
		int accountId=store.addAccount(accountInfo);
		
		cache.addAccount(accountId,accountInfo);
	}
	
	public Map<Integer,AccountInfo> getAccount(int customerId)
	{
		return cache.getAccount(customerId);
	}
	
	public void changeCustomerStatus(int customerId,int status)throws ProException
	{
		store.changeCustomerStatus(customerId, status);
		
		cache.changeCustomerStatus(customerId, status);
		
	}
	
	public void changeAccountStatus(int customerId,int accountId,int status)throws ProException
	{
		store.changeAccountStatus(customerId,accountId, status);
		
		cache.changeAccountStatus(customerId,accountId,status);
		
	}
	
	public void deposit(int customerId,int accountId,int amount)throws ProException
	{
		
		store.deposit(customerId, accountId, amount);
		
		cache.deposit(customerId, accountId, amount);
		
	}
	
	public void withdrawal(int customerId,int accountId,int amount)throws ProException
	{
		
		store.withdrawal(customerId, accountId, amount);
		
		cache.withdrawal(customerId, accountId, amount);
		
	}

}
