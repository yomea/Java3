package 基础题;

public class ValueTranslate {
	

	public static final int[] aa= new int[2];

	public static void main(String[] args) {
		Integer a = 10;
		Integer b = a;
		System.out.println(1^5);//异或
		System.out.println(~5);//位非
		aa[0] = 23;
		short i = 8;
		//i = i + 8;//baocuo
		i += 8;
		String str = "hello";
		hhe(str);
		b++;
		System.out.println(a);
		System.out.println(b);
		System.out.println(str);
	}
	
	public static void hhe(String str) {
		str += "sdtgj";
		System.out.println(str);
	}
}
