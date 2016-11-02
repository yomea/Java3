package 基础题;

public class ReturnFinally {
	
	public static void main(String[] args) {
		//System.out.println(returnFinally1());
		//returnFinally2();
		returnFinally3();
	}
	
	public static int returnFinally1() {
		try {
			//	int s = 1 / 0;
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("astfhs");
				return 2; //将会覆盖return 1
			}
	}
	
	public static int returnFinally2() {
		int s = 1 / 0;//所以finally不一定会执行。
		if(s == 0) {
			
			throw new ArithmeticException();//运行时异常，不必trycatch，检查异常才会要求捕获
		}
		try {
			//	int s = 1 / 0;
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("astfhs");
			}
		
		return 0;
	}
	
	
	public static int returnFinally3() {
		try {
			System.exit(0);//finally不会被执行
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("astfhs");
			}
		
		return 0;
	}

}
