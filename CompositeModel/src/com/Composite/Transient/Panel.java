package com.Composite.Transient;

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

	@Override
	public void add(Component component) {
		components.add(component);
		
	}

	@Override
	public void remove(Component component) {
		components.remove(component);
		
	}

	@Override
	public List<Component> getComponents() {
		// TODO Auto-generated method stub
		return components;
	}

}
