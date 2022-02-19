package sqltask;

import java.util.*;
import java.sql.*;
import proexception.ProException;

public class SqlTask {
	
	// enum class
	public enum connectionUtlity
	{
		
		CONNECTION;
		
	    private String url="jdbc:mysql://localhost:3306/student";
	    //student is the name of the database
	    
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

	
	
		
	//table creation method
	
	
	public void createTable()throws ProException
	{
	    Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement();)
		{
		   
			
			String sql="CREATE TABLE OFFICE(id INTEGER not NULL,name VARCHAR(20),age INTEGER not NULL,sex VARCHAR(10),PRIMARY KEY(id))";
			
			statement.executeUpdate(sql);
			
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
		
	}
	
	//insert data in a table
	
	public void insertData()throws ProException
	{
        
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement())
		{
		
			
			String sql1="INSERT INTO OFFICE VALUES(2,'Gokul',25,'male')";
			String sql2="INSERT INTO OFFICE VALUES(3,'dharma',22,'male')";
			String sql3="INSERT INTO OFFICE VALUES(4,'shiva',22,'male')";
			String sql4="INSERT INTO OFFICE VALUES(5,'ali',22,'male')";
			
			
			String[] data= {sql1,sql2,sql3,sql4,sql4};
			
			for(int i=0;i<data.length;i++)
			{
				statement.executeUpdate(data[i]);
			}
			
			
			
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}
	
	//insert data in a table
	
		public void insertData(int id,String name,int age,String sex)throws ProException
		{
	        
			Connection connection=connectionUtlity.CONNECTION.createConnection();
			
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO OFFICE VALUES(?,?,?,?)"))
			{
		            statement.setInt(1,id);
		            statement.setString(2,name);
		            statement.setInt(3,age);
		            statement.setString(4,sex);
					statement.executeUpdate();
			
			}
			catch(SQLException e)
			{
				throw new ProException(e);
				
			}
			
		}
	
	// get data from a table
	
	public Map<Integer,TableData> viewData()throws ProException
	{
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement())
		{
		
			 Map<Integer,TableData> map=new HashMap<>();
			
			 String sql="SELECT * FROM OFFICE";
			
			 ResultSet result=statement.executeQuery(sql);
			 
			 while(result.next())
			 {
				 
				 TableData dataObj=new TableData();
				 
				 dataObj.setId(result.getInt("id"));
				 
				 dataObj.setName(result.getString("name"));
				 
				 dataObj.setAge(result.getInt("age"));
				 
				 dataObj.setSex(result.getString("sex"));
				 
				 map.put(result.getInt("id"),dataObj);
				
			 }
			
			 return map;
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}
	// update table 
	
	public void updateData()throws ProException
	{
		Connection connection=connectionUtlity.CONNECTION.createConnection();
		
		try(Statement statement = connection.createStatement())
		{
		      
			String sql="UPDATE OFFICE SET name='prabha' WHERE id in(1)";
			
			statement.executeUpdate(sql);
			
			
		
		}
		catch(SQLException e)
		{
			throw new ProException(e);
			
		}
		
	}	
	
	// update table  pre
	
		public void updateData(String name,int id)throws ProException
		{
			Connection connection=connectionUtlity.CONNECTION.createConnection();
			
			try(PreparedStatement statement = connection.prepareStatement("UPDATE OFFICE SET name=? WHERE id in(?)"))
			{
			      
				
				statement.setString(1, name);
				statement.setInt(2, id);
				statement.executeUpdate();
				
				
			
			}
			catch(SQLException e)
			{
				throw new ProException(e);
				
			}
			
		}	
	
	// delete record
	
		public void deleteData()throws ProException
		{
			Connection connection=connectionUtlity.CONNECTION.createConnection();
			
			try(Statement statement = connection.createStatement())
			{
			      
				String sql="DELETE FROM OFFICE WHERE id in(1)";
				
				statement.executeUpdate(sql);
				
				
			
			}
			catch(SQLException e)
			{
				throw new ProException(e);
				
			}
			
		}	
		
		// delete record pre
		
			public void deleteData(int id)throws ProException
			{
				Connection connection=connectionUtlity.CONNECTION.createConnection();
				
				try(PreparedStatement statement = connection.prepareStatement("DELETE FROM OFFICE WHERE id in(?)"))
				{
				      
				
					statement.setInt(1,id);
					statement.executeUpdate();
					
					
				
				}
				catch(SQLException e)
				{
					throw new ProException(e);
					
				}
				
			}	
	
	
	
	// drop table
		
		public void dropTable()throws ProException
		{
			Connection connection=connectionUtlity.CONNECTION.createConnection();
			
			try(Statement statement = connection.createStatement())
			{
			      
				String sql="DROP TABLE ZOHO";
				
				statement.executeUpdate(sql);
				
				
			
			}
			catch(SQLException e)
			{
				throw new ProException(e);
				
			}
		
		
	}
	

}
