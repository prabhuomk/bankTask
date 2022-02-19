package bankapi;

import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import jacksonutility.JacksonUtility;
import org.json.simple.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.*;

import proexception.ProException;

public class JsonApi {

	/*
	 * JsonStorage store=new JsonStorage();
	 * 
	 * JacksonUtility utility=new JacksonUtility();
	 * 
	 * 
	 * // add customer detail
	 * 
	 * public void addCustomer(CustomerInfo customerInfo)throws ProException {
	 * if(customerInfo!=null) { store.addCustomerInfo(customerInfo); } else { throw
	 * new ProException("Customer info object can't be null"); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //get customer detail based on id
	 * 
	 * public CustomerInfo getCustomerById(int id)throws ProException { return
	 * store.getCustomerInfo(id);
	 * 
	 * 
	 * }
	 * 
	 * // get active active customer
	 * 
	 * public CustomerInfo activeCustomer(int id)throws ProException {
	 * 
	 * CustomerInfo customer=getCustomerById(id);
	 * 
	 * 
	 * if(customer!=null) {
	 * 
	 * boolean status=customer.getStatus();
	 * 
	 * if(status==true) { return customer; }
	 * 
	 * throw new ProException("Sorry customer is in inactive status");
	 * 
	 * }
	 * 
	 * throw new ProException("No Such customer Exist");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * // add account details based on customer id
	 * 
	 * public void customerAccountDetail(AccountInfo account)throws ProException {
	 * 
	 * if(account!=null) { int customerId=account.getCustomerId();
	 * 
	 * JSONObject accountMapData=store.getCustomerAccount(customerId);
	 * 
	 * if(accountMapData==null) { accountMapData=store.accountInfoJson();
	 * 
	 * store.addCustomerAccount(customerId,accountMapData); }
	 * 
	 * store.addAccountInfo(accountMapData,account);
	 * 
	 * store.write(); } else { throw new ProException("No such account is present");
	 * }
	 * 
	 * }
	 * 
	 * 
	 * // get all account details of a customer by id
	 * 
	 * public JSONObject getAccountList(int id)throws ProException { return
	 * store.getCustomerAccount(id);
	 * 
	 * 
	 * }
	 * 
	 * // active account list
	 * 
	 * public List<AccountInfo> getActiveAccountList(int id)throws ProException {
	 * JSONObject account=getAccountList(id);
	 * 
	 * if(account!=null) {
	 * 
	 * List<AccountInfo> listAccount=new ArrayList<>();
	 * 
	 * for (Object key : account.keySet()) { String jstr =(String)account.get(key);
	 * 
	 * AccountInfo value=utility.fromJsons(jstr);
	 * 
	 * if(value.getStatus()==true) { listAccount.add(value); } }
	 * 
	 * return listAccount; }
	 * 
	 * throw new ProException("No such account exist"); }
	 * 
	 * // change status of customer
	 * 
	 * public void changeStatusCustomer(int customerId,int status)throws
	 * ProException { CustomerInfo customer=store.getCustomerInfo(customerId);
	 * 
	 * 
	 * if(customer!=null) {
	 * 
	 * if(status==1) { customer.setStatus(true);
	 * 
	 * store.addCustomerInfo(customerId,customer); } else {
	 * customer.setStatus(false);
	 * 
	 * store.addCustomerInfo(customerId,customer);
	 * 
	 * 
	 * } } else { throw new ProException("No such customer Exist"); }
	 * 
	 * 
	 * }
	 * 
	 * //change status of account
	 * 
	 * public void changeStatusAccount(int customerId,int accountId,int
	 * status)throws ProException { JSONObject
	 * accountInfo=getAccountList(customerId);
	 * 
	 * 
	 * 
	 * if(accountInfo!=null) {
	 * 
	 * 
	 * AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	 * 
	 * if(account!=null) {
	 * 
	 * if(status==1) { account.setStatus(true);
	 * store.addAccountInfo(accountInfo,accountId,account);
	 * 
	 * 
	 * 
	 * } else { account.setStatus(false);
	 * store.addAccountInfo(accountInfo,accountId,account);
	 * 
	 * } store.addCustomerAccount(customerId, accountInfo); store.write(); } else {
	 * throw new ProException("No such account Exist"); }
	 * 
	 * } else { throw new ProException("No customer Exist"); }
	 * 
	 * }
	 * 
	 * 
	 * public void withdrawal(int customerId,int accountId,int withdrawAmt)throws
	 * ProException {
	 * 
	 * activeCustomer(customerId);
	 * 
	 * JSONObject accountInfo=getAccountList(customerId);
	 * 
	 * 
	 * if(accountInfo !=null) { AccountInfo account
	 * =store.getAccountInfo(accountInfo, accountId);
	 * 
	 * if(account !=null && account.getStatus()) {
	 * 
	 * int deposit=account.getBalance();
	 * 
	 * if(deposit>withdrawAmt) { int balance=deposit-withdrawAmt;
	 * 
	 * account.setBalance(balance); } else { throw new
	 * ProException("sorry your balance is "+deposit+" you can't withdraw"); } }
	 * 
	 * else { throw new
	 * ProException("no account information present or your account is deActivated"
	 * ); }
	 * 
	 * } else { throw new ProException("no such customer present"); }
	 * 
	 * if(accountInfo==null) { throw new ProException("No such customer present"); }
	 * AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	 * 
	 * if(account ==null || !account.getStatus()) { throw new
	 * ProException("No account information present or your account is deActivated"
	 * ); } int deposit=account.getBalance();
	 * 
	 * if(deposit<withdrawAmt) { throw new
	 * ProException("Sorry your balance is "+deposit+" you can't withdraw");
	 * 
	 * }
	 * 
	 * int balance=deposit-withdrawAmt;
	 * 
	 * account.setBalance(balance);
	 * 
	 * store.addAccountInfo(accountInfo,accountId,account);
	 * 
	 * store.addCustomerAccount(customerId, accountInfo);
	 * 
	 * store.write(); }
	 * 
	 * 
	 * 
	 * public void deposit(int customerId,int accountId,int depositAmt)throws
	 * ProException {
	 * 
	 * 
	 * activeCustomer(customerId);
	 * 
	 * JSONObject accountInfo=getAccountList(customerId);
	 * 
	 * if(accountInfo !=null) {
	 * 
	 * AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	 * 
	 * if(account !=null && account.getStatus()) {
	 * 
	 * int balance=account.getBalance();
	 * 
	 * int total=balance+depositAmt;
	 * 
	 * account.setBalance(total);
	 * 
	 * } else { throw new
	 * ProException("no account information present or deActivated"); }
	 * 
	 * } else { throw new ProException("no account information present"); }
	 * 
	 * if(accountInfo ==null) { throw new
	 * ProException("No account information present"); }
	 * 
	 * AccountInfo account =store.getAccountInfo(accountInfo, accountId);
	 * 
	 * if(account ==null || !account.getStatus()) { throw new
	 * ProException("No account information present or deActivated");
	 * 
	 * }
	 * 
	 * int balance=account.getBalance();
	 * 
	 * int total=balance+depositAmt;
	 * 
	 * account.setBalance(total);
	 * 
	 * store.addAccountInfo(accountInfo,accountId,account);
	 * 
	 * store.addCustomerAccount(customerId, accountInfo);
	 * 
	 * store.write();
	 * 
	 * }
	 * 
	 * public boolean creationOfFile()throws ProException {
	 * 
	 * 
	 * File newFile = new File("customerData.txt");
	 * 
	 * try {
	 * 
	 * return newFile.createNewFile();
	 * 
	 * } catch(IOException e) {
	 * 
	 * throw new ProException(e);
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public void addDummyCustomerToFile()throws ProException { store.write(); }
	 * 
	 * public void addDummyAccountToFile()throws ProException { store.write(); }
	 * 
	 */
}
