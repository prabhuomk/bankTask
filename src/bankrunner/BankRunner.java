package bankrunner;

import customerinfo.CustomerInfo;
import myscanner.MyScanner;
import proexception.ProException;
import accountinfo.AccountInfo;
import bankinglogic.BankingLogic;



public class BankRunner {

	MyScanner input=new MyScanner();
	
	BankingLogic api=null;
	
	public BankRunner()
	{
		try
		{
			api=new BankingLogic();
			
		}
		catch(ProException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
		
	
	
	// contains list of dummy customer info
	
	
	  private void addDummyValues()
	  { 
	     try 
	    { 
	    	 CustomerInfo customerData1=new CustomerInfo();
	    	  customerData1.setName("Prabhakaran");
	          customerData1.setAddress("Karaikudi");
	          customerData1.setMobile("9444951598");
	          api.addCustomer(customerData1);
	  
	         CustomerInfo customerData2=new CustomerInfo();
	         customerData2.setName("Shiva");
	         customerData2.setAddress("Theni");
	         customerData2.setMobile("099088900");
	         api.addCustomer(customerData2);
	  
	         CustomerInfo customerData3=new CustomerInfo();
	         customerData3.setName("Gokul"); 
	         customerData3.setAddress("Salem");
	         customerData3.setMobile("90889009900");
	         api.addCustomer(customerData3);
	  
	         CustomerInfo customerData4=new CustomerInfo();
	         customerData4.setName("Dharma");
	         customerData4.setAddress("Madurai");
	         customerData4.setMobile("90990830303");
	         api.addCustomer(customerData4);
	  
	         CustomerInfo customerData5=new CustomerInfo();
	         customerData5.setName("Hari");
	         customerData5.setAddress("Karaikudi");
	         customerData5.setMobile("78898366283"); 
	         api.addCustomer(customerData5);  
	         
	         System.out.println("Dummay account deatails added"); 
	        } 
	         catch(ProException e)
	        { 
	        	 System.out.println(e); 
	        	 e.printStackTrace();
	        	 
	        } 
	     }
	  
	  // contains list of dummy account details
	  
		private void addDummyAccount() {

			try {
				AccountInfo accountData1 = new AccountInfo();
				accountData1.setCustomerId(1);
				accountData1.setBranch("karaikudi");
				accountData1.setBalance(20000);
				
				api.addAccount(accountData1);

				AccountInfo accountData2 = new AccountInfo();
				accountData2.setCustomerId(1);
				accountData2.setBranch("salem");
				accountData2.setBalance(200000);
			
				api.addAccount(accountData2);

				AccountInfo accountData3 = new AccountInfo();
				accountData3.setCustomerId(2);
				accountData3.setBranch("trichy");
				accountData3.setBalance(80000);
				
				api.addAccount(accountData3);

				AccountInfo accountData4 = new AccountInfo();
				accountData4.setCustomerId(2);
				accountData4.setBranch("madurai");
				accountData4.setBalance(70000);
				
				api.addAccount(accountData4);

				AccountInfo accountData5 = new AccountInfo();
				accountData5.setCustomerId(3);
				accountData5.setBranch("chennai");
				accountData5.setBalance(30000);
				
				api.addAccount(accountData5);

				AccountInfo accountData6 = new AccountInfo();
				accountData6.setCustomerId(3);
				accountData6.setBranch("chennai");
				accountData6.setBalance(20600);
				
				api.addAccount(accountData6);

				AccountInfo accountData7 = new AccountInfo();
				accountData7.setCustomerId(3);
				accountData7.setBranch("vilupuram");
				accountData7.setBalance(900000);
				
				api.addAccount(accountData7);

				AccountInfo accountData8 = new AccountInfo();
				accountData8.setCustomerId(4);
				accountData8.setBranch("kotaiyur");
				accountData8.setBalance(780000);
				
				api.addAccount(accountData8);

				AccountInfo accountData9 = new AccountInfo();
				accountData9.setCustomerId(5);
				accountData9.setBranch("kanyakumari");
				accountData9.setBalance(89000);
				
				api.addAccount(accountData9);

				AccountInfo accountData10 = new AccountInfo();
				accountData10.setCustomerId(5);
				accountData10.setBranch("pallatur");
				accountData10.setBalance(4000);
				
				api.addAccount(accountData10);

				

				System.out.println("Dummay account deatails added");
			} 
			catch (ProException e)
			{
				System.out.println(e);
			}

		}
	  
	  // add customer info
	  
		private void putCustomerInfo() {

			int numberCustomer = input.getInputNumber("Enter the  number of customer you want to add");

			for (int i = 0; i < numberCustomer; i++) 
			{
				CustomerInfo customerData = new CustomerInfo();
				try {
					String name = input.getInput("Enter the customer Name");
					
					String address = input.getInput("Enter the customer Address");
					
					String mobile = input.getInput("Enter the customer Mobile Number");

					customerData.setName(name);
					
					customerData.setAddress(address);
					
					customerData.setMobile(mobile);

					api.addCustomer(customerData);
					
				} catch (ProException e)
				{
					System.out.println(e);
				}

			}

		}
	  
		private void putAccountInfo() {

			int numberaccount = input.getInputNumber("Enter the  number of account you want to add");

			for (int i = 0; i <numberaccount; i++) 
			{
				AccountInfo accountData = new AccountInfo();
				try {
					int id = input.getInputNumber("Enter the customer id");
					
					String branch = input.getInput("Enter the customer branch");
					
			     	int balance = input.getInputNumber("Enter the customer balance");

					
					accountData.setCustomerId(id);
					accountData.setBranch(branch);
					accountData.setBalance(balance);
					api.addAccount(accountData);
					
				} catch (ProException e)
				{
					System.out.println(e);
				}

			}

		}
	  
	  
	  // get customer info by using customer id
	  
		private void getCustomerById() 
		{
			int id = input.getInputNumber("Enter the customer id");
			
			System.out.println(api.getCustomer(id));

			
		}

	 
	  
	  // get all account details of customer by using customer id
	  
	  
		private void getAllAccount() 
		{
			    int id = input.getInputNumber("Enter the customer id");
			
				System.out.println(api.getAccount(id));
			
		}
	  
	 
	  // change status of customer
	  
		private void changeStatusCustomerInfo()
		{
			
			int customerId = input.getInputNumber("Enter the customer id");

			System.out.println("Enter 0 for deActivation");

			System.out.println("Enter 1 for activation");

			int status = input.getInputNumber("enter 0 or 1");

			try {
				
				api.changeCustomerStatus(customerId, status);

				System.out.println("status changed successfully");
				
			} catch (ProException e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}

		}
	  
	  // change status of account
	  
		private void changeStatusAccountInfo() 
		{
			int customerId = input.getInputNumber("Enter the customer id");

			int accountId = input.getInputNumber("Enter the account id");

			System.out.println("Enter 0 for deActivation");

			System.out.println("Enter 1 for activation");

			int status = input.getInputNumber("enter 0 or 1");

			try {
				api.changeAccountStatus(customerId, accountId, status);

				System.out.println("status changed successfully");
				
			} catch (ProException e) 
			{
				System.out.println(e);
			}
		}
	  
		public void addDeposit() 
		{
			int customerId = input.getInputNumber("Enter the customer id");

			int accountId = input.getInputNumber("Enter the account id");

			int deposit = input.getInputNumber("Enter the deposit amount");

			try {
				
				api.deposit(customerId, accountId, deposit);
			} 
			catch (ProException e) 
			{
				System.out.println(e);
			}

		}
	  
	 
	  
	  
		public void withDrawAmt()
		{
			int customerId = input.getInputNumber("Enter the customer id");

			int accountId = input.getInputNumber("Enter the account id");

			int withdraw = input.getInputNumber("Enter the withdraw amount");

			try 
			{
				api.withdrawal(customerId, accountId, withdraw);
				
			} catch (ProException e) 
			{
				System.out.println(e);
			}
		}
		
		
		 public void createFileWithData()
		 {
			  
			  addDummyValues();
			  addDummyAccount();
			  
			  
		  }
		 
	  
	  //main method
	  
	  public static void main(String[] args) { MyScanner input=new MyScanner();
	  
	  BankRunner run = new BankRunner();
	  
	  int number=input.getInputNumber("Enter the case number");
	  
	  switch(number) {
	  
	  
	  case 1:run.createFileWithData(); break;
	  
	  case 2:run.putCustomerInfo(); break;
	  
	  case 3:run.getCustomerById(); break;
	  
	  case 4:run.getAllAccount(); break;
	  
	  case 5:run.changeStatusCustomerInfo(); break;
	  
	  case 6:run.changeStatusAccountInfo(); break;
	  
	  case 7:run.addDeposit(); break;
	  
	  case 8:run.withDrawAmt(); break;
	  
	  case 9:run.putAccountInfo();break;
	  
	
	  
	  
	  
	  
	  
	  } }
	 
	}


