package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.user;
import com.the_bean_quartet.msc_project.entities.userList;
import com.the_bean_quartet.msc_project.services.libraryService;
import com.the_bean_quartet.msc_project.services.userService;

@Path("/user")
public class userCRUDService {
	
	
	@Inject
	private userService userService;
	@Inject
	private libraryService libservice;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public userList getUserData() {
		System.out.println("in user cruds");
        userList data = new userList();
       data.setUserCollection(userService.getUserDataset());
        return data;
    }
	
	@GET
    @Path("/adduser")
    public userList adduser() {
		user newuser = new user("kang","123");
		userService.addUser(newuser);
		
		library newlib = new library("asfd", newuser);
		libservice.addLibrary(newlib);
		return null;
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/verify")
	public String verifyUser(Options opt){
		System.out.println("verf11111111111111111111111111111111111iy user");
		user user = new user(opt.getOption1(),opt.getOption2());
		System.out.println("verfiy user");
		return userService.verifyUser(user);
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/register")
	public String register(Options opt){
		System.out.println("verfregister11111111111111111111iy user");

		String name = opt.getOption1();
		String password = opt.getOption2();
				
		return userService.addUser(new user(name,password));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(user user){	
		
		String username = user.getUserName();
		String userpassword = user.getUserPassword();

		return userService.addUser(user);
	}
	
	private String verifyUserRule(String name, String password){
		if(name.isEmpty()){
			return "No username entered";
		}
		if(password.isEmpty()){
			return "No password entered";
		}
		return "valid";
	}





	
//	
//	
//	/*
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
////	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/viewby")
//    public SysUserList getUsersBy(String viewBy) throws JsonParseException, JsonMappingException, IOException{
//		System.out.println(viewBy);
//		ObjectMapper mp = new ObjectMapper();
//		String viewByy = mp.readValue(viewBy, String.class);
//		System.out.println(viewByy);
//		SysUserList users = new SysUserList();
//		users.setSysUserCollection(service.getUsersBy(viewByy));
//        return users;
//    }
//    */
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/viewby")
//	public SysUserList getUsersBy(String viewBy) throws JsonParseException, JsonMappingException, IOException{
//		ObjectMapper mp = new ObjectMapper();
//		String viewByy = mp.readValue(viewBy, String.class);
//		System.out.println(viewByy);
//		SysUserList users = new SysUserList();
//		users.setSysUserCollection(service.getUsersBy(viewByy));
//        return users;
//	}
}
