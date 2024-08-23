package io.testNgOOPS;

import org.testng.annotations.Test;

@Test
public class Class3 extends Class1 {

	public void printingParent() {
		Class1 a = new Class1();
		a.meth1();
		meth1();
	}
	
	public void meth2() {
		Class2 c= new Class2(1);
		SuperClass s = new SuperClass(3);
		int value= c.increment();
		System.out.println(value);
		int multiValue = s.multiply();
		System.out.println(multiValue);
		
		
		
	}
	
	

}
