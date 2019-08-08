/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.dao.CourseDAO;
import com.dao.LectureDAO;
import com.pojo.Course;
import com.pojo.CourseInfo;
import com.pojo.Student;
import com.pojo.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author TT2019
 */
@ManagedBean
@RequestScoped
public class LectureBean {
    private List<Course> getAllCourse;
    private List<CourseInfo> getAllCourseInfo;
    
    private CourseInfo enrollLecture;
    
    private Integer idfromform;
    private String gradefromform;
    private String explanationfromform;
    private Student studentIdfromform;
    private Course courseIdfromform;
    private Course selectedCourse;
    static int i;
    int j;
    public void enrollLecture() {
        try {
            enrollLecture = new CourseInfo();
            j=getGetAllCourseInfo();
            j=j+1;
            enrollLecture.setId(j);
            
            enrollLecture.setGrade("-");
            enrollLecture.setExplanation("-");
            Student student ;
            
            List<Student> list = new ArrayList(whoAmI().getStudentCollection());
            
            student = list.get(0);
            enrollLecture.setStudentId(student);
            enrollLecture.setCourseId(selectedCourse);
            
            if (LectureDAO.add(enrollLecture)) {
                System.out.println("Course registered successfully.");
            } else {
                System.out.println("Faced with error.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public List<Course> getGetAllCourse() {
        LectureDAO ldao = new LectureDAO();
        getAllCourse = ldao.getAll();
        return getAllCourse;
    }
    
    public int getGetAllCourseInfo() {
        LectureDAO ldao = new LectureDAO();
        getAllCourseInfo = ldao.getAllInfo();
        i=getAllCourseInfo.size();
        return i;
    }
    public User whoAmI() {
        Map<String, Object> sessionMap = null;
        User temp = null;
        
        try{
        sessionMap = FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap();
        temp = (User) sessionMap.get("user");
        }catch(Exception e){
            System.out.println(e+"\nwhoAmI() null pointer");
        }
        return temp;
    }
    public void setGetAllCourse(List<Course> getAllCourse) {
        this.getAllCourse = getAllCourse;
    }
    public void setGetAllCourseInfo(List<CourseInfo> getAllCourseInfo) {
        this.getAllCourseInfo = getAllCourseInfo;
    }

    public CourseInfo getEnrollLecture() {
        return enrollLecture;
    }

    public void setEnrollLecture(CourseInfo enrollLecture) {
        this.enrollLecture = enrollLecture;
    }

    public Integer getIdfromform() {
        return idfromform;
    }

    public void setIdfromform(Integer idfromform) {
        this.idfromform = idfromform;
    }

    public String getGradefromform() {
        return gradefromform;
    }

    public void setGradefromform(String gradefromform) {
        this.gradefromform = gradefromform;
    }

    public String getExplanationfromform() {
        return explanationfromform;
    }

    public void setExplanationfromform(String explanationfromform) {
        this.explanationfromform = explanationfromform;
    }

    public Student getStudentIdfromform() {
        return studentIdfromform;
    }

    public void setStudentIdfromform(Student studentIdfromform) {
        this.studentIdfromform = studentIdfromform;
    }

    public Course getCourseIdfromform() {
        return courseIdfromform;
    }

    public void setCourseIdfromform(Course courseIdfromform) {
        this.courseIdfromform = courseIdfromform;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
    
    
}
