
public class TestStatic {
	
	static int value = 33;
	
	public static void main(String[] args) throws Exception{
		
		new TestStatic().printValue();
	}

	private void printValue(){
		
		int value = 3;
		// 局部变量value 与 this 没有关系， 所有this.value 访问的是静态变量
		System.out.println(this.value);
	}
}
