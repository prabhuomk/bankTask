package myscanner;
import java.util.Scanner;
import proexception.ProException;

public class MyScanner

{

Scanner obj = new Scanner(System.in);



// Method 1 - String Scanner

public String getInput(String caseSpecific) throws ProException
{

           System.out.println(caseSpecific);
           String stringName =obj.nextLine();
           if(stringName.isEmpty())
           {
           throw new ProException("String can't be empty");
           }
           return stringName;
           
}

// Method 2 - Char Scanner



public char getInputChar(String caseSpecificChar)
{

        System.out.println(caseSpecificChar);
        try
        {
              char letter=obj.nextLine().charAt(0);
              return letter;
        }
        catch(Exception e)
        {
           
               System.out.println("Enter a letter properly");
              
        }
         
        return getInputChar(caseSpecificChar);

}

// Method 3 - Integer Scanner

public int getInputNumber(String caseSpecificNumber)
{

         System.out.println(caseSpecificNumber);
         
         try
         {
              int numForOper =obj.nextInt();
              obj.nextLine();
              return numForOper;
         }
         catch(Exception e)
         {
              System.out.println("Enter a number ,string or char not accepted");
              obj.nextLine();
         }
         
         return getInputNumber(caseSpecificNumber);

}

// Method 4 - decimal Scanner

public double getInputDecimal(String caseSpecificNumber)
{

         System.out.println(caseSpecificNumber);
         
         try
         {
              double numForOper =obj.nextDouble();
              obj.nextLine();
              return numForOper;
         }
         catch(Exception e)
         {
              System.out.println("Enter a decimal number ,string or char not accepted");
              obj.nextLine();
         }
         
         return getInputNumber(caseSpecificNumber);

}

// Method 5 - long Scanner

public long getInputLong(String caseSpecificNumber)
{

         System.out.println(caseSpecificNumber);
         
         try
         {
              long numForOper =obj.nextLong();
              obj.nextLine();
              return numForOper;
         }
         catch(Exception e)
         {
              System.out.println("Enter a long value ,string or char not accepted");
              obj.nextLine();
         }
         
         return getInputNumber(caseSpecificNumber);

}

// Method 6 - to display all case`s details



}
