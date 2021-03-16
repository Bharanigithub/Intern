package day22;

public class MainClass {
	public static void main(String[] args) {
		CustomerMasterDTO cus=new CustomerMasterDTO();
		cus.setCustomerName("Bharani");
		cus.setCustomerAddress("21,Ranga Street,Erode");
		cus.setCustomerEmail("abc@gmail.com");
		cus.setCustomerNo(5);
		cus.setCustomerPhone("9876543210");
		CustomerMasterDAOImpl cusImpl=new CustomerMasterDAOImpl();
		cusImpl.insertCustomer(cus);
		cus.setCustomerPhone("9898989898");
		cusImpl.updateCustomer(cus);
		CustomerMasterDTO eg=cusImpl.getCustomerMaster(1);
		System.out.println(eg);
		System.out.println(cusImpl.getCustomerMasterAll());
		cusImpl.deleteCustomer(5);
	}
}
