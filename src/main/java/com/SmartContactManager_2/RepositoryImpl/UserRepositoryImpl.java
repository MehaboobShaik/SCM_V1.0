package com.SmartContactManager_2.RepositoryImpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SmartContactManager_2.model.User;
import com.SmartContactManager_2.Repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	Session session =null;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int registerUser(User user) {
		if(sessionFactory!=null) {
	    session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int cratedUser = (int)session.save(user);
		transaction.commit();
		return cratedUser;
		}else {
			return 0;		
		}
	}
    @Override
	public User getUserByEmail(String email) {
    	if(sessionFactory!=null) {
    	   session = sessionFactory.openSession();
    	String Query ="From User where email=:email";
		Query<?> createQuery = session.createQuery(Query);
		User user = (User) createQuery.setParameter("email", email).uniqueResult();
		System.out.println("user->"+user.toString());
		return user;
	}else {
		return null;
	}
   }

	
}
