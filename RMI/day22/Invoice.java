package day22;
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;

import Assignment_Components.*;
public interface Invoice extends Remote{
	public void createInvoice(int invno,int day,int month,int year,int cusno,String cusname,String mobile,String address,String email,int noofitems,int[] itemno,int[] itemqty) throws RemoteException;
	public ArrayList<ArrayList<String>> printInvoice(int invno) throws RemoteException;
	public byte[] convertToExcel(ArrayList<ArrayList<String>> al) throws RemoteException;
	public byte[] convertToPDf(ArrayList<ArrayList<String>> al) throws RemoteException;
	public String trackDelivery(LocalDate date,String origin,String destination,LocalTime time,float hour1,float minute1,float dist,float speed,int hour,int minute) throws RemoteException;
	public void addItem(int itemno,String desc,int price,int unit) throws RemoteException;
}