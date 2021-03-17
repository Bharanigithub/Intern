package Assignment_Components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import Components.ArrListToString;
import Components.SAXDemo;

public class SMSSender implements SendSMS {
	@Override
	public void send(ArrayList<ArrayList<String>> arr) {
		// TODO Auto-generated method stub
		try {
		Properties data=new Properties();
		FileReader read=new FileReader("smsDatas.properties");
		data.load(read);
		TextConverter textConverter=TextConverter.createObject();
		String msg=textConverter.convert(arr);	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Mobile No. to send:");
		String phone = s.next();
		String username = data.getProperty("username");
		String password = data.getProperty("password");
		String address = data.getProperty("address");
		String port = data.getProperty("port");
		URL url = new URL(
				address+":"+port+"/SendSMS?username="+username+"&password="+password+
				"&phone="+phone+"&message="+URLEncoder.encode(msg,"UTF-8"));
		
		URLConnection connection = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while((inputLine = bufferedReader.readLine()) !=null){
			System.out.println(inputLine);
		}
		bufferedReader.close();
		System.out.println("Message Sent!!");
		}
		catch(Exception e) {}
	}
}
