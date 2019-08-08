package com.dao;

import com.pojo.Student;
import com.pojo.User;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TT2019
 */
public class LoginDAO {

    public static User CheckUser(String emailFromUser, String passFromUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            Criteria isUserValidCriteria = session.createCriteria(User.class);
            isUserValidCriteria.add(Restrictions.eq("email", emailFromUser));
            isUserValidCriteria.add(Restrictions.eq("pass", passFromUser));
            List<User> myList = isUserValidCriteria.list();

            if (!(myList.size() <= 0)) {
                return myList.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
}

