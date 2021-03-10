package day17;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class AnnotationDemo {
	public static void main(String[] args) throws Exception {
		PaintBrush brush=PaintContainer.Container();
		brush.doPaint();
	}
}

class PaintBrush {
	@In(paintClass = "day17.BluePaint")
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}

class PaintContainer {
	public static PaintBrush Container() throws Exception {
		PaintBrush paintBrush=new PaintBrush();
		Field f=paintBrush.getClass().getDeclaredField("paint");
		f.setAccessible(true);
		In in=f.getAnnotation(In.class);
		if(in!=null) {
			String paintClass=in.paintClass();
			paintBrush.paint=(Paint)Class.forName(paintClass).getConstructor().newInstance();
		}
		return paintBrush;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface In {
	String paintClass();
}
abstract class Paint {
	public Paint() {
		// TODO Auto-generated constructor stub
	}
}
class RedPaint extends Paint {
	public RedPaint() {
		// TODO Auto-generated constructor stub
	}
}
class BluePaint extends Paint {
	public BluePaint() {
		// TODO Auto-generated constructor stub
	}
}