package project.databasestub;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import project.model.Activity;
import project.model.User;

public class ProjectDB {
	
	
	private static Map<User, List<Activity>> userActivity = new HashMap<>();

	
	public static Map<User, List<Activity>> getUserActivity() {
		return userActivity;
	}

	}
	

