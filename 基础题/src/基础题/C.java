package 基础题;

public class C {
	public static void main(String[] args) {
		short a = 128;//0000 0000 1000 0000
		byte b = (byte)a;////Short a = 128;就会编译出错//1000 0000 从补码转换成源码也是-0，-0表示-128
		System.out.println(a + "||" + b);
	}
}
