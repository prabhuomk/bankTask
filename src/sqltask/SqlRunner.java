package sqltask;

import java.util.Map;

import myscanner.MyScanner;


public class SqlRunner {
	
	SqlTask task = new SqlTask();
	
	
	
	private void createQuery()
	{
		try
		{
		       task.createTable();
		
		       System.out.println("table create successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void insertQuery()
	{
		try
		{
		    task.insertData();
		    
		    System.out.println("data inserted successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void insertQuery(int id,String name,int age,String sex)
	{
		try
		{
		    task.insertData(id,name,age,sex);
		    
		    System.out.println("data inserted successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void selectQuery()
	{
		try
		{
		    Map<Integer,TableData> result=task.viewData();
		    
		    System.out.println(result);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void updateQuery()
	{
		try
		{
		    task.updateData();
		    
		    System.out.println("data updated successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void deleteQuery()
	{
		try
		{
		    task.deleteData();
		    
		    System.out.println("record deleted successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void dropTableQuery()
	{
		try
		{
		    task.dropTable();
		    
		    System.out.println("table dropped successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) 
	{
		
		SqlRunner run =new SqlRunner();
		
		MyScanner input=new MyScanner();
		
		int number=input.getInputNumber("Enter the case number");
		
		switch(number)
		{
		  case 1:run.createQuery();
		  break;
		
		  case 2:run.insertQuery();
		  break;
		  
		  case 3:run.selectQuery();
		  break;
		  
		  case 4:run.updateQuery();
		  break;
		  
		  case 5:run.deleteQuery();
		  break;
		  
		  case 6:run.dropTableQuery();
		  break;
		  
		  case 7:run.insertQuery(1,"Prabhakaran",25,"Male");
		  break;
		}
		
		
		
		
		
	}
	
	

}
