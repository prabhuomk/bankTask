package proexception;
public class ProException extends Exception
{
//constructor
     public ProException(String exceptionMsg)
     {     
           super(exceptionMsg);
     }
     
     public ProException(Exception exception)
     {     
           super(exception);
     }
     
     
     
     
}
