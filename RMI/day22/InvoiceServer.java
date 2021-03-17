package day22;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import Assignment_Components.*;

public class InvoiceServer extends UnicastRemoteObject implements Invoice {
	Scanner s = new Scanner(System.in);
	public CustomerMasterDTO customerMasterDTO;
	public InvoiceMasterDTO invoiceMasterDTO;
	public ItemTransactionDTO itemTransactionDTO;
	public ItemMasterDTO itemDetails = new ItemMasterDTO();
	public ArrayList<ArrayList<String>> arrl = new ArrayList<ArrayList<String>>();

	public InvoiceServer() throws RemoteException {

	}

	@Override
	public void createInvoice(int invno, int day, int month, int year, int cusno, String cusname, String mobile,
			String address, String email, int noofitems, int[] itemno, int[] itemqty) throws RemoteException {
		CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();
		customerMasterDTO.setCustno(cusno);
		customerMasterDTO.setName(cusname);
		customerMasterDTO.setEmail(email);
		customerMasterDTO.setPhone(mobile);
		customerMasterDTO.setAddress(address);

		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		invoiceMasterDTO.setCustomerno(cusno);
		invoiceMasterDTO.setInvDate(LocalDate.of(year, month, day));
		invoiceMasterDTO.setInvno(invno);

		ItemTransactionDAOImpl itemTranImpl = new ItemTransactionDAOImpl();
		ItemTransactionDTO itemTransactionDTO = new ItemTransactionDTO();
		for (int i = 0; i < noofitems; i++) {
			itemTransactionDTO.setInvno(invno);
			itemTransactionDTO.setItemno(itemno[i]);
			itemTransactionDTO.setQty(itemqty[i]);
			itemTranImpl.insertItem(itemTransactionDTO);
		}
		CustomerMasterDAOImpl cuscr = new CustomerMasterDAOImpl();
		cuscr.insertCustomerDetials(customerMasterDTO);
		InvoiceMasterDAOImpl invcr = new InvoiceMasterDAOImpl();
		invcr.insertInvoice(invoiceMasterDTO);
		System.out.println("Details Inserted!!");
	}

	@Override
	public ArrayList<ArrayList<String>> printInvoice(int invno) throws RemoteException {
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<>();
		InvoiceMasterDAOImpl inv = new InvoiceMasterDAOImpl();
		InvoiceMasterDTO invDetails = inv.getInvoiceMaster(invno);
		CustomerMasterDAOImpl cus = new CustomerMasterDAOImpl();
		CustomerMasterDTO cusDetails = cus.getCustomerDetials(invDetails.getCustomerno());
		ItemTransactionDAOImpl itemTran = new ItemTransactionDAOImpl();
		Set<ItemTransactionDTO> hs = new HashSet<>();
		hs = itemTran.getItemDetails(invno);

		temp.add("Invoice No");
		temp.add("Invoice Date");
		al.add(temp);
		temp = new ArrayList<>();
		temp.add(Integer.toString(invDetails.getInvno()));
		temp.add(invDetails.getInvDate().toString());
		al.add(temp);
		temp = new ArrayList<>();
		temp.add("Customer No");
		temp.add("Customer Name");
		temp.add("Customer Mobile");
		temp.add("Customer Address");
		temp.add("Customer Email");
		al.add(temp);
		temp = new ArrayList<>();
		temp.add(Integer.toString(cusDetails.getCustno()));
		temp.add(cusDetails.getName());
		temp.add(cusDetails.getPhone());
		temp.add(cusDetails.getAddress());
		temp.add(cusDetails.getEmail());
		al.add(temp);
		temp = new ArrayList<>();

		temp.add("Item No");
		temp.add("Item Description");
		temp.add("Item Unit");
		temp.add("Item Price");
		temp.add("Item Quantity");
		al.add(temp);
		temp = new ArrayList<>();
		for (ItemTransactionDTO td : hs) {
			temp.add(Integer.toString(td.getItemno()));
			ItemMasteDAOImpl item = new ItemMasteDAOImpl();
			ItemMasterDTO itemDetails = item.getItemDetailsMaster(td.getItemno());
			temp.add(itemDetails.getDesc());
			temp.add(Integer.toString(itemDetails.getUnits()));
			temp.add(Integer.toString(itemDetails.getPrice()));
			temp.add(Integer.toString(td.getQty()));
			al.add(temp);
			temp = new ArrayList<>();
		}
		arrl = al;
		return al;
	}

	@Override
	public void convertToExcel() throws RemoteException {
		System.out.println("Excel Generated!!");
	}

	@Override
	public void convertToPDf() throws RemoteException {
		System.out.println("PDF Generated!!");
	}

	@Override
	public String trackDelivery(LocalDate date, String origin, String destination, LocalTime time, float hour1,
			float minute1, float dist, float speed, int hour, int minute) throws RemoteException {
		String str = "";
		try {
			CalculateDetails calculateDetails = CalculateDetails.createObject();
			calculateDetails.setDetails(date, origin, destination, time, hour1, minute1, dist, speed, hour, minute);
			LocalDateTime ltd = calculateDetails.compute(calculateDetails);
			LocalDate dat = ltd.toLocalDate();
			LocalTime tim = ltd.toLocalTime();
			str = "Estimated Delivery Date:" + dat.getDayOfMonth() + "/" + dat.getMonthValue() + "/" + dat.getYear()
					+ "\n";
			str = str + "Estimated Delivery Time:" + tim;
		} catch (Exception e) {

		}
		return str;
	}

	@Override
	public void addItem(int itemno, String desc, int price, int unit) throws RemoteException {
		ItemMasterDTO item = new ItemMasterDTO();
		item.setDesc(desc);
		item.setItemno(itemno);
		item.setPrice(price);
		item.setUnits(unit);
		ItemMasteDAOImpl itim = new ItemMasteDAOImpl();
		itim.insertItemDetailsMaster(item);
		System.out.println("New Item Added:");
	}

}