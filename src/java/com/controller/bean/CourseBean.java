/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.dao.CourseDAO;
import com.pojo.Course;
import com.util.HibernateUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author TT2019
 */
@ManagedBean
@ViewScoped
public class CourseBean {
    public boolean renderedpanel=false;
    private int idFromForm;
    private String nameFromFrom;
    private int actsFromFrom;
    private int hoursFromFrom;
    private String classroomFromFrom;
    private int quotaFromFrom;
    private String catagoryFromFrom;
    private String termFromFrom;
    private boolean statusFromFrom;
    private Course selectedcourse;

    private Course courseToRegister;
    private List<Course> getAllCourse;

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void didFinishViewing() {
    }

    public void saveCourseToDB() {
        try {
            courseToRegister = new Course();

            courseToRegister.setId(idFromForm);
            courseToRegister.setName(nameFromFrom);
            courseToRegister.setActs(actsFromFrom);
            courseToRegister.setHours(hoursFromFrom);
            courseToRegister.setClassroom(classroomFromFrom);
            courseToRegister.setQuota(quotaFromFrom);
            courseToRegister.setCatagory(catagoryFromFrom);
            courseToRegister.setTerm(termFromFrom);
            courseToRegister.setStatus(statusFromFrom);

            if (CourseDAO.add(courseToRegister)) {
                System.out.println("Course registered successfully.");
            } else {
                System.out.println("Faced with error.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateCourse(){
        try {
            CourseDAO.update(selectedcourse);  
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"updated","succesfull");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            renderedpanel = false;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }   
    public void deleteCourse(){
        try {
            CourseDAO.delete(selectedcourse);
            System.out.println("Course deleted successfully.");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"deleted","succesfull");
            FacesContext.getCurrentInstance().addMessage(null, message);
            renderedpanel = false;
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
        
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Selected Course", ((Course) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String getNameFromFrom() {
        return nameFromFrom;
    }

    public void setNameFromFrom(String nameFromFrom) {
        this.nameFromFrom = nameFromFrom;
    }

    public int getActsFromFrom() {
        return actsFromFrom;
    }

    public void setActsFromFrom(int actsFromFrom) {
        this.actsFromFrom = actsFromFrom;
    }

    public int getHoursFromFrom() {
        return hoursFromFrom;
    }

    public void setHoursFromFrom(int hoursFromFrom) {
        this.hoursFromFrom = hoursFromFrom;
    }

    public String getClassroomFromFrom() {
        return classroomFromFrom;
    }

    public void setClassroomFromFrom(String classroomFromFrom) {
        this.classroomFromFrom = classroomFromFrom;
    }

    public int getQuotaFromFrom() {
        return quotaFromFrom;
    }

    public void setQuotaFromFrom(int quotaFromFrom) {
        this.quotaFromFrom = quotaFromFrom;
    }

    public String getCatagoryFromFrom() {
        return catagoryFromFrom;
    }

    public void setCatagoryFromFrom(String catagoryFromFrom) {
        this.catagoryFromFrom = catagoryFromFrom;
    }

    public String getTermFromFrom() {
        return termFromFrom;
    }

    public void setTermFromFrom(String termFromFrom) {
        this.termFromFrom = termFromFrom;
    }

    public boolean isStatusFromFrom() {
        return statusFromFrom;
    }

    public void setStatusFromFrom(boolean statusFromFrom) {
        this.statusFromFrom = statusFromFrom;
    }

    public Course getCourseToRegister() {
        return courseToRegister;
    }

    public void setCourseToRegister(Course courseToRegister) {
        this.courseToRegister = courseToRegister;
    }

    public int getIdFromForm() {
        return idFromForm;
    }

    public void setIdFromForm(int idFromForm) {
        this.idFromForm = idFromForm;
    }

    public List<Course> getGetAllCourse() {
        CourseDAO sdao = new CourseDAO();
        getAllCourse = sdao.getAll();
        return getAllCourse;
    }

    public void setGetAllCourse(List<Course> getAllCourse) {
        this.getAllCourse = getAllCourse;
    }

    public Course getSelectedcourse() {
        return selectedcourse;
    }

    public void setSelectedcourse(Course selectedcourse) {
        this.selectedcourse = selectedcourse;
    }

    public boolean isRenderedpanel() {
        return renderedpanel;
    }

    public void setRenderedpanel(boolean renderedpanel) {
        this.renderedpanel = renderedpanel;
    }
    
    
    

}
