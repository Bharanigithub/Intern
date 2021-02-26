package friday_26_02_2021;

public class Unique3Digit {
	public static void main(String[] args) {
		int cnt=0;
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				for(int k=1;k<=4;k++) {
					if(i!=j && j!=k && i!=k) {
						System.out.println(i+""+j+""+k);
						cnt++;
					}
				}
			}
		}
		System.out.println("Total no. of three digit numbers is "+cnt);
	}
}
