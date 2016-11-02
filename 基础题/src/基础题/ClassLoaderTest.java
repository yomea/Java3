package 基础题;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		System.out.println(args[0]);
		System.err.println(ClassLoaderTest.class.getClassLoader().getResource("").toString());
		URL[] urls = new URL[] { new URL(ClassLoaderTest.class.getClassLoader().getResource("").toString()) };
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(urls);
		Class<?> clazz = urlClassLoader.loadClass("基础题.A");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		A obj = (A) constructor.newInstance();
		obj.main(null);
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		System.out.println(classLoader);// AppClassLoader
		System.out.println(classLoader.getParent());// ExtClassLoader
		System.out.println(classLoader.getParent().getParent());// 由c++编写到的，所有看不到，会返回null
		System.out.println(Vector.class.getSuperclass().getSuperclass().getSuperclass());
	}
}
