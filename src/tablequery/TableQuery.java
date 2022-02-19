package tablequery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import proexception.ProException;
import sqltask.TableData;
import sqltask.SqlTask.connectionUtlity;
import customerinfo.CustomerInfo;
import maputility.MapUtility;
import accountinfo.AccountInfo;
import bankapi.JsonApi;


public class TableQuery {
	
	   Map<Integer,CustomerInfo> customerData=new HashMap<Integer,CustomerInfo>();
  	
	   Map<Integer,Map<Integer,AccountInfo>> customerAccount=new  HashMap<Integer,Map<Integer,AccountInfo>>();
	   
	   MapUtility utility=new MapUtility();
	
	public enum connectionUtlity
	{
		
		CONNECTION;
		
	    private String url="jdbc:mysql://localhost:3306/BANK";
	    //BANK is the name of the database
	    
	    private  String user="root";
	    
	    private String password="Root@123";
	    
		private Connection connector=null;
		
		public Connection createConnection()throws ProException
		{
		          
			try
			{
				   if(connector==null)
				   {
			          connector =DriverManager.getConnection( url,user,password);
			          
				   }
				   
			       return connector;
				  
			
			 }
			 catch(SQLException exception) 
			 {
				
				   throw new ProException(exception);
				
			  }
			    
		}
		
		public void closeConnection()
	    {
	    	try
	    	{
	    	    if(connector!=null)
	    	    {
	    		   connector.close();
	    	    }
	    	}
	    	catch(SQLException e) {}
	    	
	    	
	    }

	}
	
	
	public Map<Integer,CustomerInfo> readCustomer()throws ProException
	{
        
		try
		{
		
		createCustomerTable();
			
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement())
		{
			
			 String sql="SELECT * FROM CUSTOMER;";
			
			 ResultSet result=statement.executeQuery(sql);
			 
			 if(result!=null)
			 {
			 
			 while(result.next())
			 {
				 
				 CustomerInfo customerInfo=new CustomerInfo();
				 
				 customerInfo.setName(result.getString("Name"));
				 
				 customerInfo.setAddress(result.getString("Address"));
				 
				 customerInfo.setMobile(result.getString("Mobile"));
				 
				 int customerID=result.getInt("CustomerID");
				 
				 utility.addCustomer(customerID, customerInfo,customerData);
				 
				 
				
			 }
			
			 return customerData;
			 }
			 
			 return customerData;
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw new ProException(e);
		
		
	}
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> readAccount()throws ProException
	{
        
		try
		{
		createAccountTable();
			
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement())
		{
		
			
			 String sql="SELECT * FROM ACCOUNT;";
			
			 ResultSet result=statement.executeQuery(sql);
			 
			 if(result!=null)
			 {
			 
			 while(result.next())
			 {
				 
				 AccountInfo accountInfo=new AccountInfo();
				 
				 accountInfo.setCustomerId(result.getInt("CustomerID"));
				 
				 accountInfo.setBranch(result.getString("Branch"));
				 
				 accountInfo.setBalance(result.getInt("Balance"));
				 
				 accountInfo.setStatus(result.getBoolean("Status"));
				 
				 int accountId=result.getInt("AccountID");
				 
				 utility.addAccount(accountId, accountInfo,customerAccount);
				
			 }
			
			 return customerAccount;
			 }
			 return customerAccount;
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		}
		catch(Exception e)
		{
			throw new ProException(e);
			
		}
	}
	
	
			 
			 
			 
			
	

	public void createCustomerTable()throws ProException
	{
		
        Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement();)
		{
		   
			
			String sql="CREATE TABLE IF NOT EXISTS CUSTOMER(CustomerID INTEGER NOT NULL AUTO_INCREMENT,Name VARCHAR(20),Address VARCHAR(40),Mobile VARCHAR(15),Status BOOLEAN default TRUE,PRIMARY KEY(CustomerID));";
			
			statement.executeUpdate(sql);
			
			
			
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
		
		 
	}
	
	public void createAccountTable()throws ProException
	{
		
        Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement();)
		{
		   
			
			String sql="CREATE TABLE IF NOT EXISTS ACCOUNT (AccountID INTEGER NOT NULL AUTO_INCREMENT,CustomerID INTEGER NOT NULL,Branch VARCHAR(20),Balance INTEGER,Status BOOLEAN default TRUE,PRIMARY KEY(AccountID),FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID));";
			
			statement.executeUpdate(sql);
			
			
			
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
		
		
	}
	
	
	
		
	   public int insertIntoTable(String sql)throws ProException
	   {
	      
		   Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		   try(Statement statement = connection.createStatement())
		   {
			  
				 statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
				 
				 ResultSet rs = statement.getGeneratedKeys();
				 
					if (rs.next()) {
						
						return rs.getInt(1);
					}
		
					return 0;
		   }
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}
	   
	  
	
	
	
	public void changeStatus(boolean status,int Id,String sql)throws ProException
	{
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(PreparedStatement statement = connection.prepareStatement(sql))
		{
		      
			
			statement.setBoolean(1, status);
			
			statement.setInt(2, Id);
			
			statement.executeUpdate();
			
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}	
	
	
	public void updateBalance(int balance,int accountId,int customerId,String sql)throws ProException
	{
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(PreparedStatement statement = connection.prepareStatement(sql))
		{
		      
			
			statement.setInt(1, balance);
			
			statement.setInt(2, accountId);
			
			statement.setInt(3, customerId);
			
			statement.executeUpdate();
				
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}	
	
	
	   public int getAmount(int accountId)throws ProException
	   {

		   Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		   try(PreparedStatement statement = connection.prepareStatement("SELECT Balance FROM ACCOUNT where AccountID=?;"))
		   {
			  
			   statement.setInt(1,accountId);
			   
			   ResultSet amount=statement.executeQuery();
			   
			   int balance=0;
			   
			   while(amount.next())
			   {
				   balance=amount.getInt("Balance");
			   }
			   
			   return balance;
		   }
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
	   }
	
	
	
	
}
