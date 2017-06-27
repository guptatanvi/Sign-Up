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
@Transactional
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
        User userToUpdate=getUser(user.getId());
        userToUpdate.setId(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPw(user.getPw());

        getCurrentSession().update(userToUpdate);
    }
    public User getUser(Integer id){
        User user=(User) getCurrentSession().get(User.class, id);
        return user;
    }

    public void deleteUser(Integer id) {
        User user=getUser(id);
        if(user!=null)
            getCurrentSession().delete(user);
    }
    public List<User> getUsers() {

        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return criteria.list();
//        return getCurrentSession().createQuery("from users").list();
    }

}
