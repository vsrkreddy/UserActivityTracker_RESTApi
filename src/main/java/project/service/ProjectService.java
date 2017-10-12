package project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;



//import java.util.Set;
import project.model.Activity;
import project.model.User;
import project.databasestub.ProjectDB;

public class ProjectService {
	 
	private static Map<User,List<Activity>> projectMap = ProjectDB.getUserActivity();
	private static List<Activity> activityList1 = new ArrayList<>();
	private static List<Activity> activityList2 = new ArrayList<>();
	
	static{
		//*****First Set of Activities ------ ArrayList
				activityList1.add(new Activity("Swimming", 120.00));
				activityList1.add(new Activity("Driving", 60.00));
				activityList1.add(new Activity("Mountain Climbing", 30.00));
				//******Adding the arraylist to----- Map(User, arraylist)
				projectMap.put(new User("Shiva", 1), activityList1);
				
				//*****First Set of Activities ------ ArrayList
				activityList2.add(new Activity("Stuyding", 1.00));
				activityList2.add(new Activity("Writing", 2.00));
				activityList2.add(new Activity("Sleeping", 3.00));
				//******Adding the arraylist to----- Map(User, arraylist)
				projectMap.put(new User("Virat", 5), activityList2);
				
	}
	
	public ProjectService(){
		
		}
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<>(projectMap.keySet());
		
		return userList;
	
	}
	
	public List<String> getUserNames(){
		List<User> userList = new ArrayList<>(projectMap.keySet());
		List<String> list = new ArrayList<>();
		for(User user: userList){
			list.add(user.getName());
			}
		return list;
		}
	
	public String getUserRollNum(int num){
		Iterator it = projectMap.entrySet().iterator();
		String name="null";
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			User u = (User) pair.getKey();
			if(u.getRollNum()== num){
				name = u.getName();
			}
			
		}
		return name;
		}
	
	
	
	public List<Activity> getActivityForUser(String name){
		Iterator it = projectMap.entrySet().iterator();
		List<Activity> item = new ArrayList<>();
		while(it.hasNext()){
	        Map.Entry pair = (Map.Entry)it.next();
	        User u= (User)pair.getKey();
	        if(u.getName().equalsIgnoreCase(name)){
	        item = (List<Activity>) pair.getValue();
	        }

		}
		return item;
	}
	
	
	
	public Map<User, List<Activity>> addUser(User user, Activity activity){
		
		List<Activity> l= new ArrayList<>();
		l.add(activity);
//		System.out.println(user.toString());
//		System.out.println(l.size()+ l.toString());
		Map<User, List<Activity>> q = (Map<User, List<Activity>>) projectMap.put(user, l);
		
//		Iterator it = q.entrySet().iterator();
//		List<Activity> item = new ArrayList<>();
//		while(it.hasNext()){
//	        Map.Entry pair = (Map.Entry)it.next();
//		System.out.println(pair.getKey().toString());
//		}
		return  q ;
	}
	
	public User addUserDetails(String name, int rollNum){
		
		return new User(name,rollNum);
	}
	
	public Activity addUserActivity(String description, double duration){
			
			return new Activity(description, duration);
		}
	
	
	public List<Activity> updateActivity(User user,Activity activity){
		
		if(projectMap.keySet().isEmpty()){
			return null;
		}
		Iterator it = projectMap.entrySet().iterator();
		List<Activity> item = new ArrayList<>();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			User u= (User)pair.getKey();
			if(u == user){
				item = (List<Activity>) pair.setValue(activity);
			}
		}
		return item;
		
	}
	
	
	public void deleteUser(User user){
		projectMap.remove(user);
		
	}
	}
	

