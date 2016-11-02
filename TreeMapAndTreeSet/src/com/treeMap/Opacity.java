package com.treeMap;

public class Opacity implements Comparable<Opacity> {
	
	private int opacity = 0;
	
	public Opacity(int opacity) {
		this.opacity = opacity;
		
	}
	
	public int getOpacity() {
		
		return opacity;
	}
	
	public void setOpacity(int opacity) {
		
		this.opacity = opacity;
	}

	@Override
	public int compareTo(Opacity o) {
		
		return this.opacity - o.getOpacity();
	}
	
	@Override
	public String toString() {
		return "opacity:" + opacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + opacity;
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
		Opacity other = (Opacity) obj;
		if (opacity != other.opacity)
			return false;
		return true;
	}
	
	

}
