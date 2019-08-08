/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Student;
import com.pojo.Teacher;
import com.pojo.User;
import com.pojo.UserDetail;
import com.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    private static Session ses;
    private List<Student> getAllStudent;

    public static boolean addStudent(Student studentToAdd) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.save(studentToAdd);
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

    public static void updateStudent(Student studentToUpdate) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.update(studentToUpdate);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
    }

    public static void updateUser(User userToUpdate) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.update(userToUpdate);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
    }

    public static void deleteStudent(Student studentToDelete) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.delete(studentToDelete);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
    }

    public static void deleteUser(User userToDelete) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.delete(userToDelete);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
    }

    public List<Student> getAllStudent() {
        Transaction tx = null;
        List student = new ArrayList();
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            Criteria getAllStudent = ses.createCriteria(Student.class);
            return getAllStudent.list();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
        return student;
    }

    public List<User> getAllUser() {
        Transaction tx = null;
        List user = new ArrayList();
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            Criteria getAllUser = ses.createCriteria(User.class);
            return getAllUser.list();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
        return user;
    }

    public static void insertUser(User user) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.save(user);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }

    }

    public static void insertUserDetail(UserDetail userdetail) {
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            ses.save(userdetail);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
    }

    public static Teacher getTeacherFromDB(int pk) {
        Teacher supervisor = null;
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            tx = ses.beginTransaction();
            supervisor = (Teacher) ses.get(Teacher.class, pk);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            ses.close();
        }
        
        return supervisor;
    }

    public static Session getSes() {
        return ses;
    }

    public static void setSes(Session ses) {
        StudentDao.ses = ses;
    }

    public List<Student> getGetAllStudent() {
        return getAllStudent;
    }

    public void setGetAllStudent(List<Student> getAllStudent) {
        this.getAllStudent = getAllStudent;
    }

}
