import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import proexception.ProException;

public class Tester {
	
	public static void main(String[] arg)
	{
		CustomerInfo  customerData1=new CustomerInfo();
		customerData1.setName("Prabhakaran");
	    customerData1.setAddress("Karaikudi");
	    customerData1.setMobile("9444951598");
	    customerData1.setStatus(true);
	
	    
	    CustomerInfo  customerData2=new CustomerInfo();
		customerData2.setName("Shiva");
	    customerData2.setAddress("Theni");
	    customerData2.setMobile("099088900");
	    customerData2.setStatus(true);
	  
	    
	    Map<Integer,CustomerInfo> data=new 	HashMap<Integer,CustomerInfo>();
	    
	    Map<Integer,Map<Integer,CustomerInfo>> customer=new  HashMap<Integer,Map<Integer,CustomerInfo>>();
	    
	     data.put(1, customerData2);
	     data.put(2, customerData1);
		  customer.put(1, data) ;
		  
		  String json=toJsonAccount(data);
		  System.out.println(json);
		  Map<Integer,CustomerInfo> map=fromJsonAccount(json);
		  System.out.println(map);
		  System.out.println(map.get("1"));
	    
	}
	public static  String toJsonAccount( Map<Integer,CustomerInfo> map)
	{
		try 
		 {
			   ObjectMapper mapper = new ObjectMapper();
			
	          String jsonStr = mapper.writeValueAsString(map);
	        
	          return jsonStr;
	       
	    }

	    catch (IOException e) 
			 {
	   	     e.printStackTrace();
	    	return null;
	        }
	}

	public static Map<Integer,CustomerInfo> fromJsonAccount(String jstr)
		{
			
		        ObjectMapper mapper = new ObjectMapper();
		      try
		      {
		         return mapper.readValue(jstr,Map.class);	
		        
		         
		      }
		      catch(IOException e)
		      {
		    	  return null;
		      }
		}
		

	}

