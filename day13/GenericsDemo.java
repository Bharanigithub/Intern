package day13;

public class GenericsDemo {
	public static void main(String[] args) {
		PaintBrush<Water> paintBrush1=new PaintBrush<>();
		paintBrush1.obj=new Water();
		Water water=paintBrush1.getObj();
		System.out.println(water);
		PaintBrush<Paint> paintBrush2=new PaintBrush<>();
		paintBrush2.obj=new RedPaint();
		Paint paint=(Paint)paintBrush2.getObj();
		System.out.println(paint);
	}
}
class PaintBrush<T> {
	T obj;
	public T getObj() {
		return obj;
	}
}
abstract class Paint {
	
}
class RedPaint extends Paint {
	
}
class BluePaint extends Paint {
	
}
class Water {
	
}