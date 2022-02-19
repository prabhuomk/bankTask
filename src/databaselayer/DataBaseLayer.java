package databaselayer;

import java.util.Map;
import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import proexception.ProException;
import storageinterface.DataStorage;
import tablequery.TableQuery;

public class DataBaseLayer implements DataStorage{

	
	TableQuery query =new TableQuery();
	
	
	
	
	public Map<Integer, CustomerInfo> readCustomer()throws ProException {
		
		return query.readCustomer();
	}

	
	public Map<Integer, Map<Integer, AccountInfo>> readAccount()throws ProException {
		
		return query.readAccount();
	}

	
	public int addCustomer(CustomerInfo customerInfo) throws ProException {
		
        String name=customerInfo.getName();
		
		String address=customerInfo.getAddress();
		
		String mobile=customerInfo.getMobile();
		
		return query.insertIntoTable("INSERT INTO CUSTOMER(Name,Address,Mobile) VALUES('"+name+"','"+address+"','"+mobile+"');");
		
		
	}

	
	public CustomerInfo getCustomer(int customerId) throws ProException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int addAccount(AccountInfo accountInfo) throws ProException {
		

		int customerID=accountInfo.getCustomerId();
		
		String branch=accountInfo.getBranch();
		
		int balance=accountInfo.getBalance();
		
		return query.insertIntoTable("INSERT INTO ACCOUNT(CustomerID,Branch,Balance) VALUES("+customerID+",'"+branch+"',"+balance+");");
		
		
	}

	
	public Map<Integer, AccountInfo> getAccount(int customerId) throws ProException {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeCustomerStatus(int customerId, int status) throws ProException {
		
		boolean value;
		
		if(status==1)
		{
			value=true;
		}
		else
		{
			value=false;
		}
		
		query.changeStatus(value,customerId,"UPDATE CUSTOMER SET Status=? WHERE CustomerID=?;");
		
	}

	
	public void changeAccountStatus(int customerId,int accountId, int status) throws ProException {
		
        boolean value;
		
		if(status==1)
		{
			value=true;
		}
		else
		{
			value=false;
		}
		
		query.changeStatus(value,accountId,"UPDATE ACCOUNT SET Status=? WHERE AccountID=?;");
		
	}

	
	public void deposit(int customerId, int accountId, int amount) throws ProException {
		
		int balance=query.getAmount(accountId);
		
		int deposit=balance+amount;
		
		query.updateBalance(deposit,accountId,customerId,"UPDATE ACCOUNT SET Balance=? WHERE AccountID=? AND CustomerID=?;");
	}


	public void withdrawal(int customerId, int accountId, int amount) throws ProException {
		
        int balance=query.getAmount(accountId);
        
        if(balance>amount)
        {
        	int deposit=balance-amount;
    		
    		query.updateBalance(deposit,accountId,customerId,"UPDATE ACCOUNT SET Balance=? WHERE AccountID=? AND CustomerID=?;");
        	
        }
		
		
		
	}

}
