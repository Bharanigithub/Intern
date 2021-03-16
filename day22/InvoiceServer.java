package day22;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.*;

public class InvoiceServer extends UnicastRemoteObject implements Invoice {
	Scanner s = new Scanner(System.in);
	public CustomerMasterDTO customerMasterDTO;
	public InvoiceMasterDTO invoiceMasterDTO;
	public ItemTransactionDTO itemTransactionDTO;
	public ItemMasterDTO itemDetails = new ItemMasterDTO();
	public ArrayList<ArrayList<String>> arrl=new ArrayList<ArrayList<String>>();
	public InvoiceServer() throws RemoteException {

	}

	@Override
	public void createInvoice(int invno, int day, int month, int year, int cusno, String cusname, String mobile,
			String address, String email, int noofitems, int[] itemno, int[] itemqty) throws RemoteException {
		CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();
		customerMasterDTO.setCustomerNo(cusno);
		customerMasterDTO.setCustomerName(cusname);
		customerMasterDTO.setCustomerEmail(email);
		customerMasterDTO.setCustomerPhone(mobile);
		customerMasterDTO.setCustomerAddress(address);
		CustomerMasterDAO cuscr=new CustomerMasterDAOImpl();
		cuscr.insertCustomer(customerMasterDTO);	
		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		invoiceMasterDTO.setCustomerno(cusno);
		invoiceMasterDTO.setInvdate(LocalDate.of(year, month, day));
		invoiceMasterDTO.setInvno(invno);
		InvoiceMasterDAO invcr=new InvoiceMasterDAOImpl();
		invcr.insertInvoice(invoiceMasterDTO);
		ItemTransactionDAO itemTranImpl = new ItemTransactionDAOImpl();
		ItemTransactionDTO itemTransactionDTO = new ItemTransactionDTO();
		for (int i = 0; i < noofitems; i++) {
			itemTransactionDTO.setInvNo(invno);
			itemTransactionDTO.setItemNo(itemno[i]);
			itemTransactionDTO.setQty(itemqty[i]);
			itemTranImpl.insertQty(itemTransactionDTO);
			ItemTransactionDAO trcr=new ItemTransactionDAOImpl();
			trcr.insertQty(itemTransactionDTO);
		}
		System.out.println(invoiceMasterDTO);
		System.out.println(customerMasterDTO);
		System.out.println(itemTransactionDTO);
	}

	@Override
	public ArrayList<ArrayList<String>> printInvoice(int invno) throws RemoteException {
		System.out.println("Print Method!!");
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<>();
		InvoiceMasterDAOImpl inv = new InvoiceMasterDAOImpl();
		InvoiceMasterDTO invDetails = inv.getInvoiceMaster(invno);
		System.out.println("Hello");
		System.out.println(invDetails);
		CustomerMasterDAOImpl cus = new CustomerMasterDAOImpl();
		CustomerMasterDTO cusDetails = cus.getCustomerMaster(invDetails.getCustomerno());
		ItemTransactionDAOImpl itemTran = new ItemTransactionDAOImpl();
		Set<ItemTransactionDTO> itemTranDetails = new HashSet<>();
		itemTranDetails = itemTran.getItemTransaction(invno, invno);

		temp.add("Invoice No");
		temp.add("Invoice Date");
		al.add(temp);
		temp = new ArrayList<>();
		temp.add(Integer.toString(invDetails.getInvno()));
		temp.add(invDetails.getInvdate().toString());
		al.add(temp);
		temp = new ArrayList<>();
		temp.add("Customer No");
		temp.add("Customer Name");
		temp.add("Customer Mobile");
		temp.add("Customer Address");
		temp.add("Customer Email");
		al.add(temp);
		temp = new ArrayList<>();
		temp.add(Integer.toString(cusDetails.getCustomerNo()));
		temp.add(cusDetails.getCustomerName());
		temp.add(cusDetails.getCustomerPhone());
		temp.add(cusDetails.getCustomerAddress());
		temp.add(cusDetails.getCustomerEmail());
		al.add(temp);
		temp = new ArrayList<>();

		temp.add("Item No");
		temp.add("Item Description");
		temp.add("Item Unit");
		temp.add("Item Price");
		temp.add("Item Quantity");
		al.add(temp);
		temp = new ArrayList<>();
		for (ItemTransactionDTO td : itemTranDetails) {
			int ino = td.getItemNo();
			ItemMasteDAOImpl item = new ItemMasteDAOImpl();
			ItemMasterDTO itemDetails = item.getItemMaster(ino);
			temp.add(Integer.toString(itemDetails.getItemNo()));
			temp.add(itemDetails.getItemDesc());
			temp.add(Integer.toString(itemDetails.getItemUnit()));
			temp.add(Integer.toString(itemDetails.getItemPrice()));
			temp.add(Integer.toString(td.getQty()));
			temp=new ArrayList<>();
		}
		System.out.println("HI"+al);
		arrl=al;
		return al;
	}

	@Override
	public void convertToExcel() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertToPDf() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void trackDelivery() throws RemoteException {
		// TODO Auto-generated method stub

	}

}