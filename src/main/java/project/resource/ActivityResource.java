package project.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import project.model.Activity;
import project.model.User;
import project.service.ProjectService;
import java.lang.ClassCastException;

@Path("/users")
public class ActivityResource {
	ProjectService projectService = new ProjectService();
	
	/*
	  GET Method Functionalities...
	  				1. Get all user details
	  				2. Get all user names
	  				3. Get user activities - input parameter "Name of user"
	  				4.Give it a ro1lNum it gives you User name 
	 */
	
	@GET//http://localhost:8080/project/users
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<User> getAllUserDetails(){
		return projectService.getAllUsers();
	}
	
	@Path("/names")//http://localhost:8080/project/users/names
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getAllUserNames(){
		ArrayList<String> array = new ArrayList<>(projectService.getUserNames());
		
		return array.toString();
		
	}
	
	@Path("/names/{name}")//http://localhost:8080/project/users/names/Virat
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getActivityForUser(@PathParam("name")String name1){
		List<Activity> array = new ArrayList<>(projectService.getActivityForUser(name1.toLowerCase()));
//		int i = projectService.getUserRollNum(name1.toLowerCase());
		//Display i to get the rollNumber using name
		
		return array.toString();
		
	}
	
	@Path("/rollnum/{num}")//http://localhost:8080/project/users/rollnum/1
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getNameForRollNum(@PathParam("num")int num1){
		return projectService.getUserRollNum(num1);
		
	}
	//*********************************************************************************************
	@POST
	@Path("/adduser/{username}/{rollnum}/{desc}/{time}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	
	public void addUsers(@PathParam("username") String user,@PathParam("rollnum") int num,
			@PathParam("desc") String desc,@PathParam("time") int time){
		// Gives you userdetails and activity detail 
		User u = projectService.addUserDetails(user, num);
		Activity a = projectService.addUserActivity(desc, time);
		projectService.addUser(u, a);


	
	}
	
	//*********************************************************************************************
	@PUT
	@Path("/update/{username}/{rollnum}/{desc}/{time}")
	
	@Produces(MediaType.APPLICATION_JSON)
	public void updateMsg(@PathParam("username") String user,@PathParam("rollnum") int num,
			@PathParam("desc") String desc,@PathParam("time") double time){
		User u = projectService.addUserDetails(user, num);
		Activity a = projectService.addUserActivity(desc, time);
		projectService.updateActivity(u, a);
	}
	//*********************************************************************************************
	@DELETE
	@Path("/{name}/{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("name") String user,@PathParam("num") int num){
		User u = new User(user,num);
		projectService.deleteUser(u);
	}
	
}
