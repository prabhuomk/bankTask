package bankapi;

import java.util.*;
import java.util.Map.Entry;
import accountinfo.AccountInfo;
import bankstorage.BankStorage;
import customerinfo.CustomerInfo;
import proexception.ProException;

public class BankApi {
	
	       int customerIds=0;
	       
	       int accountIds=100;
	       
	       BankStorage store=new BankStorage();
	       
	       
	       // add customer detail
	       
	       public void addCustomer(CustomerInfo customerInfo)throws ProException
	        {  
		       if(customerInfo!=null)
		       {
	    	         int customerId=generateCustomerId();
		       
	    	         store.addCustomerInfo(customerId,customerInfo);
		       }
		       else
		       {
		    	    throw new ProException("Customer info object can't be null");
		       }
		       	
			}
	       
	       // generate customer id
	       
	       public int generateCustomerId()
	       {
	    	         return ++customerIds;
	       }
	       
	       // generate account id
	       
	       public int generateAccountId()
	       {
	    	         return accountIds++;
	       }
	       
	       
	       //get customer detail based on id
	       
	       public CustomerInfo getCustomerById(int id)
	       {
	    	       return store.getCustomerInfo(id);
	    	   
	    	        
	       }
	       
	       // get active active customer
	       
	       public CustomerInfo activeCustomer(int id)throws ProException
	       {
	    	       
	    	   CustomerInfo customer=getCustomerById(id);
	    	   
	    	  if(customer!=null)
	    	  {
	    	   
	    	     boolean status=customer.getStatus();
	    	   
	    	     if(status==true)
	    	     {
	    		   return customer;
	    	     }
	    	    
	    	        throw new ProException("Sorry customer is in inactive status");

	    	  }
	    	  
	    	  throw new ProException("No Such customer Exist");     
	       }
           

	       
	       
           
	       
	       // add account details based on customer id
	       
	       public void customerAccountDetail(AccountInfo account)throws ProException
	       {
	    	   if(account!=null)
	    	   {
	    		  int customerId=account.getCustomerId();
	    		  
	    		  Map<Integer,AccountInfo> accountMapData=store.getCustomerAccount(customerId);
	    		  
	    		  if(accountMapData==null)
	    		  {
	    			  accountMapData=store.accountInfoMap(); 
	    			  
	    			  store.addCustomerAccount(customerId,accountMapData);
	    		  }
	    		  int generatedAccountId=generateAccountId();
	    		  
	    		  store.addAccountInfo(accountMapData,generatedAccountId, account);
	    	   }
	    	   else
	    	   {
	    		   throw new ProException("no such account is present");
	    	   }
    			  
	       }
	       
	       
	       // get all account details of a customer by id
	       
	       public Map<Integer,AccountInfo> getAccountList(int id)
	       {
	    	     return store.getCustomerAccount(id);
	    	   
			     
	       }
	       
	       // active account list
	       
	       public List<AccountInfo> getActiveAccountList(int id)
	       {
	    	   Map<Integer,AccountInfo> account=getAccountList(id);
	    	   
	    	   if(account!=null)
	    	   {
	    	   
	    	          List<AccountInfo> listAccount=new ArrayList<>();
	    	   
	    	         for(Entry<Integer, AccountInfo> entry:account.entrySet())
	    	         {
	    		          AccountInfo data=entry.getValue();
	    		          
	    		          if(data.getStatus()==true)
	    		          {
	    			          listAccount.add(data);
	    		           }
	    	         }
	    	   
			        return listAccount;   
	    	   }
	    	   
	    	      return null;
	       }
           
	       // change status of customer
	       
	       public void changeStatusCustomer(int customerId,int status)throws ProException
	       {
	    	   CustomerInfo customer=store.getCustomerInfo(customerId);
	    	   
	    	   if(customer!=null)
	    	   {	   
	    	   
	    	       if(status==1)
	    	        {
	    	             customer.setStatus(true);
	    	        }
	    	        else 
	    	        {
	    		          customer.setStatus(false);
	    	        }
	    	   }
	    	   else
	    	   {
	    		   throw new ProException("no such customer Exist");
	    	   }
	    	   
	       }
	       
	       //change status of account
	       
	       public void changeStatusAccount(int customerId,int accountId,int status)throws ProException
	       {
	    	   Map<Integer,AccountInfo> accountInfo=getAccountList(customerId);
	    	   
	    	   AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	    	   
	    	   if(account!=null)
	    	   {	   
	    	   
	    	       if(status==1)
	    	       {
	    	          account.setStatus(true);
	    	       }
	    	       else 
	    	       {
	    		       account.setStatus(false);
	    	       }
	    	   }
	    	   else
	    	   {
	    		   throw new ProException("no such customer Exist");
	    	   }
	    	  
	       }
	       
	       
	       public void withdrawal(int customerId,int accountId,int withdrawAmt)throws ProException
	   	   {
	   		
	    	   activeCustomer(customerId);
	    	   
	    	   Map<Integer,AccountInfo> accountInfo=getAccountList(customerId);
	    	   
	    	   
	    	   if(accountInfo !=null)
	    	   {
	    	         AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	    	   
	    	         if(account !=null)
		    	       {
	   		
	   		               int deposit=account.getBalance();
	   		
	   		                if(deposit>withdrawAmt)
	   		                {
	   			                   int balance=deposit-withdrawAmt;
	   			                   
	   			                    account.setBalance(balance);
	   		                }
	   		                else
	   		               {
	   			                        throw new ProException("sorry your balance is "+deposit+" you can't withdraw");
	   		                }
		    	       }
	    	         else
		    	       {
		    	    	          throw new ProException("no account information present");
		    	       }
		   			
		    	   }
		    	   else
	    	       {
	    	    	               throw new ProException("no account information present");
	    	       }
	   		
	   	}
	       public void deposit(int customerId,int accountId,int depositAmt)throws ProException
	   	   {
	   		
	    	   Map<Integer,AccountInfo> accountInfo=getAccountList(customerId);
	    	   
	    	   if(accountInfo !=null)
	    	   {
	    	   
	    	       AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	    	       
	    	       if(account !=null)
	    	       {
	   		
	   		                int balance=account.getBalance();
	   		
	   		                int total=balance+depositAmt;
	   		    
	   			            account.setBalance(total);
	   		   
	   			            
	    	       }
	    	       else
	    	       {
	    	    	          throw new ProException("no account information present");
	    	       }
	   			
	    	   }
	    	   else
    	       {
    	    	               throw new ProException("no account information present");
    	       }
   		   }
	   	  
	       
}
