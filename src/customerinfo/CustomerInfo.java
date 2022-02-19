package customerinfo;

public class CustomerInfo
{
	
	
	
	private String name;
	
	private String address;
	
	private String mobile;
	
	private boolean status=true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerInfo [name=" + name + ", address=" + address + ", mobile=" + mobile + ", status=" + status
				+ "]";
	}

	
	

	

	
	

	
	
	
}
