package storageinterface;

import customerinfo.CustomerInfo;
import java.util.Map;
import accountinfo.AccountInfo;
import proexception.ProException;


public interface DataStorage {
	
	//get customer map
	public Map<Integer,CustomerInfo> readCustomer() throws ProException;
	
	//get account map
	public Map<Integer,Map<Integer,AccountInfo>> readAccount()throws ProException;
	
	//add customer
	public int addCustomer(CustomerInfo customerInfo)throws ProException;
	
	//get customer
	public CustomerInfo getCustomer(int customerId)throws ProException;
	
	//add account
	public int addAccount(AccountInfo accountInfo)throws ProException;
	
	//get account
	public Map<Integer,AccountInfo> getAccount(int customerId)throws ProException;
	
	//change customer status
	public void changeCustomerStatus(int customerId,int status)throws ProException;
	
	//change account status
	public void changeAccountStatus(int customerId,int accountId,int status)throws ProException;
	
	
	//deposit
	public void deposit(int customerId,int accountId,int amount)throws ProException;
	
	//withdraw
	public void withdrawal(int customerId,int accountId,int amount)throws ProException;

}
