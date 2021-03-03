package day12;
public class ThreadDemo2 {
	public static void main(String[] args) {
		System.out.println("******First Line******");
		new Thread(()->{met();}).start();
		System.out.println("******Third Line******");
	}
	public static void met() {
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {}
		System.out.println("******Second Line******");
	}
}
