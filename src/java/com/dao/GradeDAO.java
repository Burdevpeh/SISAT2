/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.CourseInfo;
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
public class GradeDAO {
    private static Session ses;
    private List<CourseInfo> getAllCourseInfo; 
    
    public static boolean add(CourseInfo CourseInfoToAdd) {
        
        Transaction tx = null;
        
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.save(CourseInfoToAdd);
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
    
    public static void update(CourseInfo courseInfoToUpdate) {
        Transaction tx = null;
         try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.update(courseInfoToUpdate);
//            ses.saveOrUpdate(courseToUpdate);
            tx.commit();   
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();        
        } finally {
            ses.close();
        }
        
    }
    public List<CourseInfo> getAllInfo() {
         Transaction tx = null;
         List course=new ArrayList();
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
        return course;
    }

    public static Session getSes() {
        return ses;
    }

    public static void setSes(Session ses) {
        GradeDAO.ses = ses;
    }

    public List<CourseInfo> getGetAllCourseInfo() {
        return getAllCourseInfo;
    }

    public void setGetAllCourseInfo(List<CourseInfo> getAllCourseInfo) {
        this.getAllCourseInfo = getAllCourseInfo;
    }
    
    
    
}
