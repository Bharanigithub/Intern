package day16;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringDemo {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("Hello World from String Builder");  		
		System.out.println(sb);		
		sb.append("Append Function");		
		System.out.println(sb);
		StringBuffer sbf=new StringBuffer("Hello World from String Buffer");
		sbf.append("Append Function");
		System.out.println(sbf);
		
		StringJoiner sJoiner=new StringJoiner(",");
		System.out.println(sJoiner);
		sJoiner.add("Hello");
		sJoiner.add("World");
		System.out.println(sJoiner);
		
		sJoiner=new StringJoiner(",","<",">");
		sJoiner.add("Hello");
		sJoiner.add("World");
		sJoiner.add("Welcome");
		sJoiner.add("Hai");
		System.out.println(sJoiner);
		
		StringTokenizer sToken=new StringTokenizer(sJoiner.toString(),",");
		while(sToken.hasMoreTokens()) {
			System.out.println(sToken.nextToken());
		}
	}
}
