package com.Composite.Transient;

import java.util.List;
/**
 * 接口类，使用透明式的合成模式
 * @author may
 *
 */
public interface Component {
	
	void add(Component component);
	
	void remove(Component component);
	
	List<Component> getComponents();
	
}
