package day15;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class IODemo5 {
	public static void main(String[] args) throws Exception {
		ByteArrayInputStream ba=new ByteArrayInputStream("Hello World".getBytes());
		StringBufferInputStream sb=new StringBufferInputStream("HelloHai World");
		SequenceInputStream sis=new SequenceInputStream(ba, sb);
		int c=0;
		while((c=sis.read())!=-1) {
			System.out.print((char)c);
		}
	}
}
