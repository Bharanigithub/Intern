package Day1;
public class Pgm15_a {
	public static void main(String args[]) {
		System.out.println("Prime Numbers from 1 to 100");
		for(int i=2;i<=100;i++)
		{
			if(i==2)
				System.out.print(i+" ");
			else
			{
				if(i%2!=0)
				{
					int flag=1;
					for(int j=3;j<=i/2;j++)
					{
						if(i%j==0)
						{
							flag=0;
							break;
						}
					}
					if(flag==1)
						System.out.print(i+" ");
				}
			}
		}
	}	
}