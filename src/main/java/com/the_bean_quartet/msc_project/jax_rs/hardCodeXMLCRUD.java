//package com.the_bean_quartet.msc_project.jax_rs;
//
//import javax.inject.Inject;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.xml.bind.JAXBException;
//
//import parser.populateDB;
//
//@Path("/xls_crud")
//public class hardCodeXMLCRUD {
//	@Inject
//	private populateDB populateDB=new populateDB();
//	
//	@POST
//	@Path("/upload")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String setPath(String path) throws JAXBException{
//		
//		populateDB.populate(path);
//		return path;
//	}
//
//}
