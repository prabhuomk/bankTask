package cache;


import customerinfo.CustomerInfo;
import accountinfo.AccountInfo;
import maputility.MapUtility;
import proexception.ProException;
import java.util.HashMap;
import java.util.Map;

public class CacheStorage {
	
	
	   Map<Integer,CustomerInfo> customerData=new HashMap<Integer,CustomerInfo>();
	  	
	   Map<Integer,Map<Integer,AccountInfo>> customerAccount=new  HashMap<Integer,Map<Integer,AccountInfo>>();
	   
	   MapUtility utility=new MapUtility();
	 
	  public void setData(Map<Integer,CustomerInfo> customerMap,Map<Integer,Map<Integer,AccountInfo>> accountMap)
	  {
		  
	    	  customerData=customerMap;
	    
	    	  customerAccount=accountMap;
	      
	  }
	  
	  public void addCustomer(int customerId,CustomerInfo customerInfo)
	  {
		  
		  utility.addCustomer(customerId, customerInfo,customerData);
	  }
	
	  public CustomerInfo getCustomer(int customerId)
	  {
		  return utility.getCustomer(customerId,customerData);
	  }

	  public void addAccount(int accountId,AccountInfo accountInfo)
	  {
		  
		  utility.addAccount(accountId,accountInfo,customerAccount);
	  }
	  
	  public Map<Integer,AccountInfo> getAccount(int customerId)
	  {
		  return utility.getAccount(customerId,customerAccount);
	  }
	  
	  public void changeCustomerStatus(int customerId,int status)throws ProException
	  {
		  utility.changeCustomerStatus(customerId,status,customerData);
		  
	  }
	  
	  public void changeAccountStatus(int customerId,int accountId,int status)throws ProException
		{
			
			utility.changeAccountStatus(customerId,accountId,status,customerAccount);
			
		}
	  
	  public void deposit(int customerId,int accountId,int amount)throws ProException
		{
			
			utility.deposit(customerId, accountId, amount,customerData,customerAccount);
				
		}
		
		public void withdrawal(int customerId,int accountId,int amount)throws ProException
		{
			
			utility.withdrawal(customerId, accountId, amount,customerData,customerAccount);
			
			
			
		}
}

