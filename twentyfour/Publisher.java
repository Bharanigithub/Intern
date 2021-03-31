package twentyfour;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2030/ws/hello2", new ComplexServiceImpl());
		System.out.println("Published!!");
	}
}
