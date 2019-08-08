/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Course;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author TT2019
 */
public class CourseDAO {

    private static Session ses;
    private List<Course> getAllCourse; 

    public static boolean add(Course courseToAdd) {
        
        Transaction tx = null;
        
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.save(courseToAdd);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        } finally {
            ses.close();
        }
    }

    public static void update(Course courseToUpdate) {
        Transaction tx = null;
         try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.update(courseToUpdate);
//            ses.saveOrUpdate(courseToUpdate);
            tx.commit();   
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();        
        } finally {
            ses.close();
        }
        
    }

    public static void delete(Course courseToDelete) {
        Transaction tx = null;
         try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.delete(courseToDelete);
            tx.commit();   
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();        
        } finally {
            ses.close();
        }
        
    }

    public List<Course> getAll() {
         Transaction tx = null;
         List course=new ArrayList();
         try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            Criteria getAllCourse = ses.createCriteria(Course.class);
            return getAllCourse.list(); 
              
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();         
        } finally {
            ses.close();
        }
        return course;
    }

    public Session getSes() {
        return ses;
    }

    public void setSes(Session ses) {
        this.ses = ses;
    }

    public List<Course> getGetAllCourse() {
        return getAllCourse;
    }

    public void setGetAllCourse(List<Course> getAllCourse) {
        this.getAllCourse = getAllCourse;
    }
    

}
