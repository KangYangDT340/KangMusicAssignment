//package com.the_bean_quartet.msc_project.jax_rs;
//
//import javax.inject.Inject;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import com.the_bean_quartet.msc_project.entities.SysUser;
//import com.the_bean_quartet.msc_project.entities.SysUserList;
//import com.the_bean_quartet.msc_project.services.SysUserService;
//
//@Path("/user")
//public class SysUserCRUDService {
//	
//	@Inject
//	private SysUserService service;
//	
//	@GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public SysUserList getUsers() {
//		SysUserList users = new SysUserList();
//		users.setSysUserCollection(service.getUsers());
//        return users;
//    }
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void addUser(SysUser user2){
//		
//		////
//		
//		
//	//	System.out.println(user2.getUserName());
//		
//	//	ObjectMapper objectMapper = new ObjectMapper();
//	//	SysUser user1 = objectMapper.readValue(test, SysUser.class);
//		
//	//	user1.setId(0);
//	//	user1.setUserName("test");
//	//	user1.setUserPassword("test");
//	//	user1.setUserType("test");
//		
//		service.addUser(user2);
//	}
//	
//
//	
//}
