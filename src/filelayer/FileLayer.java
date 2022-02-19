package filelayer;

import java.util.Map;

import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import filequery.FileQuery;
import proexception.ProException;
import storageinterface.DataStorage;

public class FileLayer implements DataStorage{

	
	FileQuery query=new FileQuery();
	
	public Map<Integer, CustomerInfo> readCustomer()throws ProException {
	
		return query.readCustomer();
	}


	public Map<Integer, Map<Integer, AccountInfo>> readAccount()throws ProException {
		
		return query.readAccount();
	}

	

	public int addCustomer(CustomerInfo customerInfo) throws ProException {
		
		return query.addCustomer(customerInfo);
		
		
	}

	
	public CustomerInfo getCustomer(int customerId) throws ProException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int addAccount(AccountInfo accountInfo) throws ProException {
		
		return query.addAccount(accountInfo);
	}

	@Override
	public Map<Integer, AccountInfo> getAccount(int customerId) throws ProException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeCustomerStatus(int customerId, int status) throws ProException {
		
		query.changeCustomerStatus(customerId,status);
		
	}

	@Override
	public void changeAccountStatus(int customerId, int accountId, int status) throws ProException {
		
		query.changeAccountStatus(customerId,accountId,status);
		
	}

	@Override
	public void deposit(int customerId, int accountId, int amount) throws ProException {
		
		query.deposit(customerId,accountId,amount);
		
	}

	@Override
	public void withdrawal(int customerId, int accountId, int amount) throws ProException {
		
		query.withdrawal(customerId,accountId,amount);
		
	}
	
	

}
