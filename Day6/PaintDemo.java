package Day6;

public class PaintDemo {
	public static void main(String args[]) throws Exception {
		PaintBrush pt=new PaintBrush();
		pt=Container1.ContainerMethod(args[0]);
		pt.doPaint();
	}
}

class Paint {
}
class RedPaint extends Paint {
}
class BluePaint extends Paint {
}
class GreenPaint extends Paint {
}

class PaintBrush {
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}

class Container1 {
	static public PaintBrush ContainerMethod(String s) throws Exception {
		PaintBrush brush=new PaintBrush();
		Paint p=(Paint)Class.forName(s).newInstance();
		brush.paint=p;
		return brush;
	}
}