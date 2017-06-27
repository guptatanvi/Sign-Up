package com.sprhib.dao;

/**
 * Created by tanvigupta on 23/06/17.
 */

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){

        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user){
        getCurrentSession().save(user);
    }

    public void updateUser(User user){
        User userToUpdate=getUser(user.getName());
        userToUpdate.setId(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPw(user.getPw());
        getCurrentSession().update(userToUpdate);
    }
    public User getUser(String name){
        User user=(User) getCurrentSession().get(User.class, name);
        return user;
    }

    public void deleteUser(String name) {
        User user=getUser(name);
        if(user!=null)
            getCurrentSession().delete(user);
    }
    public List<User> getUsers() {

        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return criteria.list();
//        return getCurrentSession().createQuery("from users").list();
    }

}
