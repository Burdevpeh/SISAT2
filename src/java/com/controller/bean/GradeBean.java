package com.controller.bean;

import com.dao.GradeDAO;
import com.pojo.Course;
import com.pojo.CourseInfo;
import com.pojo.Student;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TT2019
 */
@ManagedBean
@ViewScoped
public class GradeBean {
    
    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void didFinishViewing() {
    }

     private List<CourseInfo> getAllCourseInfo;
     private CourseInfo courseInfoToRegister;
     private CourseInfo selectedcourseinfo;
     public boolean renderedpanel=false;
    private Integer idfromform;
    private String gradefromform;
    private String explanationfromform;
    private Student studentIdfromform;
    private Course courseIdfromform;

    
public void saveCourseInfoToDB() {
        try {
            courseInfoToRegister = new CourseInfo();

            courseInfoToRegister.setId(idfromform);
            courseInfoToRegister.setGrade(gradefromform);
            courseInfoToRegister.setExplanation(explanationfromform);
            courseInfoToRegister.setStudentId(studentIdfromform);
            courseInfoToRegister.setCourseId(courseIdfromform);
            
            if (GradeDAO.add(courseInfoToRegister)) {
                System.out.println("Course registered successfully.");
            } else {
                System.out.println("Faced with error.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void updateCourseInfo(){
        try {
            GradeDAO.update(selectedcourseinfo);  
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"updated","succesfull");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            renderedpanel = false;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    public List<CourseInfo> getGetAllCourseInfo() {
        GradeDAO ldao = new GradeDAO();
        getAllCourseInfo = ldao.getAllInfo();
        return getAllCourseInfo;
    }

    public void setGetAllCourseInfo(List<CourseInfo> getAllCourseInfo) {
        this.getAllCourseInfo = getAllCourseInfo;
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

    public CourseInfo getCourseInfoToRegister() {
        return courseInfoToRegister;
    }

    public void setCourseInfoToRegister(CourseInfo courseInfoToRegister) {
        this.courseInfoToRegister = courseInfoToRegister;
    }

    public CourseInfo getSelectedcourseinfo() {
        return selectedcourseinfo;
    }

    public void setSelectedcourseinfo(CourseInfo selectedcourseinfo) {
        this.selectedcourseinfo = selectedcourseinfo;
    }

    public boolean isRenderedpanel() {
        return renderedpanel;
    }

    public void setRenderedpanel(boolean renderedpanel) {
        this.renderedpanel = renderedpanel;
    }
        public void show() {
        renderedpanel = true;
    }
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Selected Course", ((CourseInfo) event.getObject()).getGrade());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    
    
}
