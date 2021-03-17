package Assignment_Components;

import java.util.ArrayList;

public abstract class Parser implements XMLtoArrListConverter,Cloneable{
	public Parser() {
		// TODO Auto-generated constructor stub
	}
	public abstract ArrayList<ArrayList<String>> parse();
}
