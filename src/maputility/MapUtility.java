package maputility;


import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import proexception.ProException;
import java.util.Map;
import java.util.HashMap;

public class MapUtility {
	
	 
	 
	  public  void addCustomer(int customerId,CustomerInfo customerinfo,Map<Integer,CustomerInfo> map)
	  {
		    
		  map.put(customerId, customerinfo);
		    
	  }
	  
	  public CustomerInfo getCustomer(int customerId,Map<Integer,CustomerInfo> map)
	  {
		    
		  return (CustomerInfo)map.get(customerId);
	  }
	  
	  public void addAccount(int accountId,AccountInfo accountInfo,Map<Integer,Map<Integer,AccountInfo>> map)
	  {
		  
		  int customerId=accountInfo.getCustomerId();
		  
		  Map<Integer,AccountInfo> accountMap=map.get(customerId);
		  
		  if(accountMap!=null)
		  {
			  accountMap.put(accountId, accountInfo);
			  
			  map.put(customerId, accountMap);
                
               
		  }
		  else
		  {
			     accountMap=new HashMap<Integer,AccountInfo>();
			  
                 accountMap.put(accountId, accountInfo);
			  
			     map.put(customerId, accountMap);
                
               
		  }
		  
		  
		  
		  
				  
	   }
	  
	  public Map<Integer,AccountInfo> getAccount(int customerId,Map<Integer,Map<Integer,AccountInfo>> map)
	  {
		  
		    return map.get(customerId);
		  
	  }
	  
	  public void changeCustomerStatus(int customerId,int status,Map<Integer,CustomerInfo> map)throws ProException
	  {
		 
		  CustomerInfo customer=getCustomer(customerId,map);
	 	  
	 	   
	 	   if(customer!=null)
		   {	   
		   
		       if(status==1)
		        {
		             customer.setStatus(true);
		             
		             addCustomer(customerId,customer,map);
		             
		            
		        }
		        else 
		        {
			         customer.setStatus(false);
			        
			         addCustomer(customerId,customer,map);  
			         
		        }
		   }
		   else
		   {
			   throw new ProException("No such customer Exist");
		   }
	  }
	  
	  public void changeAccountStatus(int customerId,int accountId,int status,Map<Integer,Map<Integer,AccountInfo>> map)throws ProException
	  {
		  Map<Integer,AccountInfo> accountMap=getAccount(customerId,map);
	 	   
	 	   
	 	  
		     if(accountMap!=null)
			 {	
		    	 
		    	 
		    	 AccountInfo account =(AccountInfo) accountMap.get(accountId);
		    	 
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
		             
	                  accountMap.put(accountId,account); 
	                  
		              map.put(customerId,accountMap);
		             
		             
	           }
		        else
		        {
			        throw new ProException("No such account Exist");
		        }
		    	 
			}
		    else
		    {
			     throw new ProException("No customer Exist");
		    }
	  }
	  
	  public void deposit(int customerId,int accountId,int amount,Map<Integer,CustomerInfo> customerMap,Map<Integer,Map<Integer,AccountInfo>> accountMap)throws ProException
		{
			
		   CustomerInfo info=getCustomer(customerId,customerMap);
	        
	        if(info.getStatus()==false)
	        {
	        	throw new ProException("customer is kept in inactive state");
	        }
	    	Map<Integer,AccountInfo> accountInfoMap=getAccount(customerId,accountMap);
	 	   
	 	   if(accountInfoMap ==null)
		   {
	 		  throw new ProException("No account information present");
		   } 
	 	  
	 	  AccountInfo account =accountInfoMap.get(accountId);
		       
		  if(account ==null || !account.getStatus())
		  {
			  throw new ProException("No account information present or deActivated");
			                
		  }           
		      
		  int balance=account.getBalance();
			
	      int total=balance+amount;

	      account.setBalance(total);	
		  
          accountInfoMap.put(accountId,account); 
          
          accountMap.put(customerId,accountInfoMap);
          
          
          
			
			
		}
		
		public void withdrawal(int customerId,int accountId,int amount,Map<Integer,CustomerInfo> customerMap,Map<Integer,Map<Integer,AccountInfo>> accountMap)throws ProException
		{
			
			    CustomerInfo info=getCustomer(customerId,customerMap);
		        
		        if(info.getStatus()==false)
		        {
		        	throw new ProException("customer is kept in inactive state");
		        }
		    	
		        Map<Integer,AccountInfo> accountInfoMap=getAccount(customerId,accountMap);
		    	
		    	if(accountInfoMap==null)
		    	{
		    		throw new ProException("No such customer present");
		    	}
		    	  
			 	   
			    AccountInfo account =accountInfoMap.get(accountId);

		    	if(account ==null || !account.getStatus())
		    	{
		    		throw new ProException("No account information present or your account is deActivated");
		    	}
		    	int deposit=account.getBalance();

		    	if(deposit<amount)
		    	{
		    		throw new ProException("Sorry your balance is "+deposit+" you can't withdraw");

		    	}

		    	int balance=deposit-amount;

		    	account.setBalance(balance);
		 	    	       
		    	accountInfoMap.put(accountId,account); 
		          
		        accountMap.put(customerId,accountInfoMap);
			
			
		}

}
