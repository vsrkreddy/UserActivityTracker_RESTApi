package project.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {
	
	private String description;
	private double duration;
	
	public Activity(){
		
	}
	
	public Activity(String description, double duration) {
		super();
		this.description = description;
		this.duration = duration;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDescription()+"  "+getDuration();
	}

}
