package 基础题;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsTest {
	
	//HashMap,TreeMap,HashTable,WeakHashMap,LinkedList,ArrayList,Vector,TreeSet,HashSet

	public static void main(String[] args) {
		//将HashMap像HashTable那样变成同步的
		Map<?, ?> map = Collections.synchronizedMap(new HashMap()); 
	}
	
}
