package 基础题;

import java.lang.reflect.Field;

public class JiekouIImpl implements Jiekoulei {
	
	public static void main(String[] args) throws Exception{
		
		
		Class<Jiekoulei>  clazz = Jiekoulei.class;
		Field filed = clazz.getDeclaredField("haha");
		System.out.println(filed.getType());
		System.out.println(filed.get(new JiekouIImpl()));
		System.out.println(JiekouIImpl.class.getSuperclass());
	}

}
