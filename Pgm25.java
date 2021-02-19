package Day1;

protected class Pgm25 
{ 
	String Method() 
	{
		return "Wow";	
	}
}
class dervied 
{ 
	public void useD() 
	{ 
		Pgm25 z = new Pgm25();
		System.out.println("Pgm25 says, " + z.Method());
	}
}
