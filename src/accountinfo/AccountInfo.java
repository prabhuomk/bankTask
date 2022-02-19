package accountinfo;

public class AccountInfo {
	
	
	
	private int customerId;
	private String branch;
	private int balance;
	private boolean status=true;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "AccountInfo [customerId=" + customerId + ", branch=" + branch
				+ ", balance=" + balance + ", status=" + status + "]";
	}
	
	
	
	
	

	

	
	
	

	
	

}
