package java8NewProperties;

@FunctionalInterface
public interface Java8Interface {
	
	public static final String name = "java8������";
	
	
	public void hello();
	
	
	public static String getName() {
		return name;
	}
	
	public default void defaultHello() {
		System.out.println("������Щ������Ϊ�˱���̫������ʱ��Ҫȫ��ȥʵ�ֵ����⣡");
	}
}
