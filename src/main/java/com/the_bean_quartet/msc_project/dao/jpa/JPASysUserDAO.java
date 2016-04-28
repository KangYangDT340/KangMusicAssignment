//package com.the_bean_quartet.msc_project.dao.jpa;
//
//import java.util.Collection;
//import java.util.List;
//
//import javax.ejb.Local;
//import javax.ejb.Stateless;
//import javax.ejb.TransactionAttribute;
//import javax.ejb.TransactionAttributeType;
//import javax.enterprise.inject.Default;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import com.the_bean_quartet.msc_project.dao.SysUserDAO;
//import com.the_bean_quartet.msc_project.entities.SysUser;
//
//
//
//
//
//
//
//@Default
//@Stateless
//@Local
//@TransactionAttribute (TransactionAttributeType.REQUIRED)
//public class JPASysUserDAO implements SysUserDAO{
//	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public void addUser(SysUser user) {
//		
//		if(userExist(user)){
//			return;
//		}
//		em.persist(user);
//		
//	}
//	public boolean userExist(SysUser user){
//		Query query = em.createQuery("from SysUser");
//		List<SysUser> users = query.getResultList();
//
//		for(int i=0; i<users.size(); i++){
//			if(users.get(i).getUserName().equals(user.getUserPassword())){
//				return false;
//			}
//		}
//		
//		return true;
//	}
//
//	
//	public Collection<SysUser> getAllUsers() {
//		// TODO Auto-generated method stub
//		Query query = em.createQuery("from SysUser");
//		List<SysUser> users = query.getResultList(); 
//		return users;
//		
//	}
//	public void userOption(String option){
//		if(option.equals("getAllUsersByAdmin")){
//			getAllUsersByAdmin();
//		}	
//	}
//	public Collection<SysUser> getAllUsersByAdmin() {
//		// TODO Auto-generated method stub
//		Query query = em.createQuery("from SysUser su where su.UserType = :UserType");
//		List<SysUser> users = query.getResultList(); 
//		return users;
//		
//	}
//
//
//}
