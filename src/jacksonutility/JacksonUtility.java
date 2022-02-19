package jacksonutility;

import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import customerinfo.CustomerInfo;
import accountinfo.AccountInfo;
import proexception.ProException;

public class JacksonUtility {
	
	
	static ObjectMapper mapper = new ObjectMapper();
	
	
	public static  String toJsonCustomer(Map<Integer,CustomerInfo> map)throws ProException
	{
		try 
		 {
			   ObjectMapper mapper = new ObjectMapper();
			
	          String jsonStr = mapper.writeValueAsString(map);
	        
	          return jsonStr;
	       
	    }

	    catch (IOException e) 
			 {
	   	 
	    	throw new ProException(e);
	        }
	}

	public static Map<Integer,CustomerInfo> fromJsonCustomer(String jstr)throws ProException
		{
			
		        ObjectMapper mapper = new ObjectMapper();
		      try
		      {
		         return mapper.readValue(jstr,Map.class);	
		        
		         
		      }
		      catch(IOException e)
		      {
		    	  throw new ProException(e);
		      }
		}
		
	public static  String toJsonId(Map<String,Integer> map)throws ProException
	{
		try 
		 {
			   ObjectMapper mapper = new ObjectMapper();
			
	          String jsonStr = mapper.writeValueAsString(map);
	        
	          return jsonStr;
	       
	    }

	    catch (IOException e) 
			 {
	   	 
	    	throw new ProException(e);
	        }
	}

	public static Map<String,Integer> fromJsonId(String jstr)throws ProException
		{
			
		        ObjectMapper mapper = new ObjectMapper();
		      try
		      {
		         return mapper.readValue(jstr,Map.class);	
		        
		         
		      }
		      catch(IOException e)
		      {
		    	  throw new ProException(e);
		      }
		}
		

	
	
	public static  String toJsonAccount( Map<Integer,Map<Integer,AccountInfo>> map)throws ProException
	{
		try 
		 {
			   ObjectMapper mapper = new ObjectMapper();
			
	          String jsonStr = mapper.writeValueAsString(map);
	        
	          return jsonStr;
	       
	    }

	    catch (IOException e) 
			 {
	   	 
	    	throw new ProException(e);
	        }
	}

	   public static Map<Integer,Map<Integer,AccountInfo>> fromJsonAccount(String jstr)throws ProException
		{
			
		        ObjectMapper mapper = new ObjectMapper();
		      try
		      {
		         return mapper.readValue(jstr,Map.class);	
		        
		         
		      }
		      catch(IOException e)
		      {
		    	  throw new ProException(e);
		 
		      }
		}
		      public static CustomerInfo fromJsonObject(String jstr)throws ProException
		  	{
		  		
		  		   
		  	      try
		  	      {
		  	         return mapper.readValue(jstr,CustomerInfo.class);	
		  	        
		  	         
		  	      }
		  	      catch(IOException e)
		  	      {
		  	    	  throw new ProException(e);
		  	      }
		  	}
		
		      public static AccountInfo fromJsons(String jstr)throws ProException
		  	{
		  		
		  		   
		  	      try
		  	      {
		  	         return mapper.readValue(jstr,AccountInfo.class);	
		  	        
		  	         
		  	      }
		  	      catch(IOException e)
		  	      {
		  	    	  throw new ProException(e);
		  	      }
		
		}
	
	
}
	
		
	
	

	

	
	
	
	
	
	
	
	
	
	/* public static String toJson(AccountInfo accountInfo)throws ProException
	{
		try 
		 {
		       
               String jsonStr = mapper.writeValueAsString(accountInfo);
             
               return jsonStr;
            
         }
  
         catch (IOException e) 
  		 {
        	 
             throw new ProException(e);
         }
	}
	
	 public static CustomerInfo fromJson(String jstr)throws ProException
	{
		
		   
	      try
	      {
	         return mapper.readValue(jstr,CustomerInfo.class);	
	        
	         
	      }
	      catch(IOException e)
	      {
	    	  throw new ProException(e);
	      }
	}
	
	public static AccountInfo fromJsons(String jstr)throws ProException
	{
		
		   
	      try
	      {
	         return mapper.readValue(jstr,AccountInfo.class);	
	        
	         
	      }
	      catch(IOException e)
	      {
	    	  throw new ProException(e);
	      }
	} */


