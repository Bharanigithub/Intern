package day22;
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Invoice extends Remote{
	public void createInvoice(int invno,int day,int month,int year,int cusno,String cusname,String mobile,String address,String email,int noofitems,int[] itemno,int[] itemqty) throws RemoteException;
	public ArrayList<ArrayList<String>> printInvoice(int invno) throws RemoteException;
	public void convertToExcel() throws RemoteException;
	public void convertToPDf() throws RemoteException;
	public void trackDelivery() throws RemoteException;
}