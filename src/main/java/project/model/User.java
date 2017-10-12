package project.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String name;
	private int rollNum;
	
	public User(String name, int rollNum) {
		super();
		this.name = name;
		this.rollNum = rollNum;
	}
//	Activity activity = new Activity();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName()+"   "+getRollNum();
	}
	
	
}
