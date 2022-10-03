package de.twist.todo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.twist.todo.model.User;
import de.twist.todo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRep;
//	
//	//save User
//	public void saveUserData(User usr) {
//		userRep.save(usr);
//	}
//	
//	public User setUpUser(String name, String email) { 
//		User userNew = new User();
//		userNew.setName(name);
//		userNew.setEmail(email);
//		
//		return userNew;
//	}
//	
//	public void saveUser(User usr) {
//		userRep.save(usr);
//	}
	EntityManager entityManager;
	 
    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    @Transactional
    public long saveUser(User user){
        entityManager.persist(user);
        return user.getId();
    }
    
    public List<User> findAll() {
    	return userRep.findAll();
    }
	
	
}

