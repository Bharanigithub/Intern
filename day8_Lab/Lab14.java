package day8_Lab;

public class Lab14 {
	public static void main(String[] args) {
		Result s1=new Result(25,"Bharani",95,90,95);
		System.out.println(s1.total());
	}
}

class Student {
	int rollno;
	String name;
	public Student(int rollno,String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.rollno=rollno;
	}
}

class Exam extends Student {
	int mark1;
	int mark2;
	int mark3;
	public Exam(int rollno, String name, int mark1, int mark2, int mark3) {
		super(rollno, name);
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
}

class Result extends Exam {
	int totalMarks;
	
	public Result(int rollno, String name, int mark1, int mark2, int mark3) {
		super(rollno, name, mark1, mark2, mark3);
	}
	
	public int total() {
		return mark1+mark2+mark3;
	}
}