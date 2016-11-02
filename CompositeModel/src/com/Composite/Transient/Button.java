package com.Composite.Transient;

import java.util.List;

/**
 * buttion是个叶子节点
 * @author may
 *
 */
public class Button implements Component {
	
	private String name;
	
	public Button(String name) {
		this.name = name;
		
	}
	
	//空实现
	@Override
	public void add(Component component) {
		// TODO Auto-generated method stub

	}
	//空实现
	@Override
	public void remove(Component component) {
		// TODO Auto-generated method stub

	}
	//空实现
	@Override
	public List<Component> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Button other = (Button) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Button [name=" + name + "]";
	}
	
	

	
	
}
