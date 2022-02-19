package implementskey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import proexception.ProException;

public class ContainKey {
	
	public  static void  main(String[] args)
	{
		Properties data =new Properties();
		
		data.setProperty("key","databaselayer.DataBaseLayer");
		
		try
	       {
	       
	       
	       FileWriter writeData = new FileWriter("className.txt");

	       data.store(writeData,"contains value ");
	        
	       }
	       catch(IOException e)
	       {
	         
	         System.out.println(e);
	       
	       }
		
		
		
	}

}
