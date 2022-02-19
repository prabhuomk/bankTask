package bankstorage;

import java.util.*;
import customerinfo.CustomerInfo;
import accountinfo.AccountInfo;

public class BankStorage {
	
	Map<Integer,CustomerInfo> customerData=new HashMap<>();
	
	Map<Integer,Map<Integer,AccountInfo>> customerAccount=new HashMap<>();
	
	// deals with customerAccount map
	
	public Map<Integer,CustomerInfo> customerInfoMap()
	{
		  return customerData;
	}
	
	public void addCustomerInfo(int customerId,CustomerInfo customerInfo)
	{
		   customerData.put(customerId,customerInfo);
		
	}
	
	public CustomerInfo getCustomerInfo(int customerId)
	{
		   return customerData.get(customerId);
		
	}
	
	
	
	// deals with customerData map
	
	public void addCustomerAccount(int customerId,Map<Integer,AccountInfo> accountMap)
	{
		   customerAccount.put(customerId,accountMap);
		
	}
	
	public  Map<Integer,AccountInfo> getCustomerAccount(int customerId)
	{
		  return customerAccount.get(customerId);
		
	}
	
	
	//deals with accountInfo Map
	
	public Map<Integer,AccountInfo> accountInfoMap()
	{
		Map<Integer,AccountInfo> accountData=new HashMap<>();
		
		return accountData;
	}
	
	public void addAccountInfo(Map<Integer,AccountInfo> mapInput,int accountId,AccountInfo accountInfo)
	{
		mapInput.put(accountId, accountInfo);
	}
	
	public AccountInfo getAccountInfo(Map<Integer,AccountInfo> mapInput,int accountId)
	{
		return mapInput.get(accountId);
	}
	
	

}
