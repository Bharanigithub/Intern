package day15;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class IODemo4 {
	public static void main(String[] args) throws Exception {
		String str="Hello Hello Hello";
		PushbackInputStream pbi=new PushbackInputStream(new ByteArrayInputStream(str.getBytes()));
		int c=0;
		while((c=pbi.read())!=-1) {
			if((char)c=='h') {
				pbi.unread('H');
			}
			else
				System.out.print((char)c);
		}
	}
}
