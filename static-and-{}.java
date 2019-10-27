class TestA{
	public TestA() {
		System.out.println("this is TestA Construct");
	}
	{System.out.println("this is A");}
	static {
		System.out.println("A");
	}
}

public class Test extends TestA{
	public Test() {
		System.out.println("this is Test construcr");
	}
	{System.out.println("this is test");}
	static {
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
/**
*A
*test
*this is A
*this is testA Construct
*this is test
*this is test construcr
**/