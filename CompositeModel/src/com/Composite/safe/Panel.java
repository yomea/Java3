package com.Composite.safe;

import java.util.ArrayList;
import java.util.List;

public class Panel implements Component {
	
	private List<Component> components = new ArrayList<Component>();
	
	private String name;
	
	public Panel(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void add(Component component) {
		components.add(component);
		
	}

	
	public void remove(Component component) {
		components.remove(component);
		
	}

	
	public List<Component> getComponents() {
		// TODO Auto-generated method stub
		return components;
	}

	@Override
	public Component returnComponent() {
		return this;
	}

}
