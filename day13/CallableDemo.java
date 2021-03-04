package day13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws Exception {
		ExecutorService es=Executors.newFixedThreadPool(1);
		Future<String> future=es.submit(new MyCallable());
		String str=future.get();
		System.out.println(str);
	}
}

class MyCallable implements Callable<String>{
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Hello";
	}
}