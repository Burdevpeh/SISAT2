/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Course;
import com.pojo.CourseInfo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author TT2019
 */
@ManagedBean
@RequestScoped
public class LectureDAO {
    
    private static Session ses;
    private List<Course> getAllCourse; 
    
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
    public List<CourseInfo> getAllInfo() {
         Transaction tx = null;
         List courseınfo=new ArrayList();
         try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            Criteria getAllCourse = ses.createCriteria(CourseInfo.class);
            return getAllCourse.list(); 
              
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();         
        } finally {
            ses.close();
        }
        return courseınfo;
    }
    public static boolean add(CourseInfo courseınfo) {
        
        Transaction tx = null;
        
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.save(courseınfo);
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


    public static Session getSes() {
        return ses;
    }

    public static void setSes(Session ses) {
        LectureDAO.ses = ses;
    }

    public List<Course> getGetAllCourse() {
        return getAllCourse;
    }

    public void setGetAllCourse(List<Course> getAllCourse) {
        this.getAllCourse = getAllCourse;
    }
    
}
