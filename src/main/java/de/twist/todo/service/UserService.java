package de.twist.todo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.twist.todo.model.User;
import de.twist.todo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRep;
	
	private EntityManager entityManager;
	 
	
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

	public boolean isUserAlreadyStored(User user) {
		if (findAll().size() == 0) {
			return false;
		}
		Optional<User> userOpt = userRep.findByName(user.getName());
		
		if (userOpt.isPresent()) {
			return true;
		}
		
		return false;
	}
}

