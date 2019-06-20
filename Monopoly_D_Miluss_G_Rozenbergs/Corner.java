/**
 * A class for representing the four corners on the field
 */
package model;

public class Corner {
	private boolean isGo;
	private boolean isGoToJail;
	private String name;
	private int cornerID;
	
	public Corner(boolean isGo, boolean isGoToJail, String name, int cornerID) {
		setGo(isGo);
		setGoToJail(isGoToJail);
		setName(name);
		setCornerID(cornerID);
	}
	
	public boolean isGo() {
		return isGo;
	}
	public void setGo(boolean isGo) {
		this.isGo = isGo;
	}
	public boolean isGoToJail() {
		return isGoToJail;
	}
	public void setGoToJail(boolean isGoToJail) {
		this.isGoToJail = isGoToJail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCornerID() {
		return cornerID;
	}

	public void setCornerID(int cornerID) {
		this.cornerID = cornerID;
	}

	@Override
	public String toString() {
		return "Corner [isGo=" + isGo + ", isGoToJail=" + isGoToJail + ", name=" + name + ", cornerID=" + cornerID
				+ "]";
	}
}
