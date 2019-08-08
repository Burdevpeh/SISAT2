/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.dao.StudentDao;
import com.pojo.Student;
import com.pojo.Teacher;
import com.pojo.User;
import com.pojo.UserDetail;
import com.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author TT2019
 */
@ManagedBean(name = "UserBean")
@ViewScoped
public class UserBean implements java.io.Serializable {

    @PostConstruct
    public void init() {

    }
    public boolean renderDetail = false;
    private List<User> getAllUsers;
    private List<Student> getAllStudent;
    private boolean renderedPanel1 = false;
    private Integer idFromForm;
    private int gradFromForm;
    private int scholarshipPercentageFromForm;
//    private Teacher teacherIdFromForm;
    private User userIdFromForm;

    private Integer idFromFormUser;
    private String emailFromForm;
    private String passFromForm;
    private String nameFromForm;
    private String surnameFromForm;
    private String statusFromForm;
    private String tcNoFromForm;
    private Date dobFromForm;

    private Integer idFromFormUserDetail;
    private String adressFromForm;
    private String phoneFromForm;
    private String departmentFromForm;
    private User userIdFromFormUserDetail;

    private Student newstudent;
    private Student selectedstudent;
    private User selecteduser;

    int supvervisorTeacherId ;
    User studentUser = new User();

    public void saveUserToDB() {
        try {

            studentUser.setId(idFromFormUser);
            studentUser.setEmail(emailFromForm);
            studentUser.setPass(passFromForm);
            studentUser.setName(nameFromForm);
            studentUser.setSurname(surnameFromForm);
            studentUser.setStatus(statusFromForm);
            studentUser.setTcNo(tcNoFromForm);
            studentUser.setDob(dobFromForm);

            StudentDao.insertUser(studentUser);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveUserDetailToDB() {
    try {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(selecteduser.getId());
        userDetail.setAdress(adressFromForm);
        userDetail.setDepartment(departmentFromForm);
        userDetail.setPhone(phoneFromForm);
        userDetail.setUserId(selecteduser);

        StudentDao.insertUserDetail(userDetail);
         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveStudentToDB() {
        try {
            studentUser = new User();
            studentUser.setId(idFromFormUser);
            studentUser.setEmail(emailFromForm);
            studentUser.setPass(passFromForm);
            studentUser.setName(nameFromForm);
            studentUser.setSurname(surnameFromForm);
            studentUser.setStatus("Active");
            studentUser.setTcNo(tcNoFromForm);
            studentUser.setDob(dobFromForm);
            System.out.println("user name "+ studentUser.getName());
            StudentDao.insertUser(studentUser);
            
            
            newstudent.setUserId(studentUser);
            newstudent.setId(idFromForm);
            newstudent.setGrad(gradFromForm);
            newstudent.setScholarshipPercentage(scholarshipPercentageFromForm);
            Teacher supervisor = StudentDao.getTeacherFromDB(supvervisorTeacherId);
            System.out.println("Teacher Name  " + supervisor.getUserId().getName());
            newstudent.setTeacherId(supervisor);
            newstudent.setUserId(selecteduser);
            if (StudentDao.addStudent(newstudent)) {
                System.out.println("Course registered successfully.");
            } else {
                System.out.println("Faced with error.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateStudent() {
        try {
            StudentDao.updateStudent(selectedstudent);
            System.out.println("Student updated successfully.");
            renderedPanel1 =false;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void updateUser() {
        try {
            StudentDao.updateUser(selecteduser);
            System.out.println("User updated successfully.");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"updated","succesfull");
            FacesContext.getCurrentInstance().addMessage(null, message);
            renderedPanel1 =false;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteStudent() {
        try {
            StudentDao.deleteStudent(selectedstudent);
            System.out.println("Student deleted successfully.");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"deleted","succesfull");
            FacesContext.getCurrentInstance().addMessage(null, message);
            renderedPanel1 =false;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteUser() {
        try {
            StudentDao.deleteUser(selecteduser);
            System.out.println("User deleted successfully.");
            renderedPanel1 =false;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Student Selected", ((Student) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowSelect2(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Student Selected", ((User) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Integer getIdFromForm() {
        return idFromForm;
    }

    public void setIdFromForm(Integer idFromForm) {
        this.idFromForm = idFromForm;
    }

    public int getGradFromForm() {
        return gradFromForm;
    }

    public void setGradFromForm(int gradFromForm) {
        this.gradFromForm = gradFromForm;
    }

    public int getScholarshipPercentageFromForm() {
        return scholarshipPercentageFromForm;
    }

    public void setScholarshipPercentageFromForm(int scholarshipPercentageFromForm) {
        this.scholarshipPercentageFromForm = scholarshipPercentageFromForm;
    }

//    public Teacher getTeacherIdFromForm() {
//        return teacherIdFromForm;
//    }
//
//    public void setTeacherIdFromForm(Teacher teacherIdFromForm) {
//        this.teacherIdFromForm = teacherIdFromForm;
//    }

    public User getUserIdFromForm() {
        return userIdFromForm;
    }

    public void setUserIdFromForm(User userIdFromForm) {
        this.userIdFromForm = userIdFromForm;
    }

    public Student getNewstudent() {
        return newstudent;
    }

    public void setNewstudent(Student newstudent) {
        this.newstudent = newstudent;
    }

    public Integer getIdFromFormUser() {
        return idFromFormUser;
    }

    public void setIdFromFormUser(Integer idFromFormUser) {
        this.idFromFormUser = idFromFormUser;
    }

    public String getEmailFromForm() {
        return emailFromForm;
    }

    public void setEmailFromForm(String emailFromForm) {
        this.emailFromForm = emailFromForm;
    }

    public String getPassFromForm() {
        return passFromForm;
    }

    public void setPassFromForm(String passFromForm) {
        this.passFromForm = passFromForm;
    }

    public String getNameFromForm() {
        return nameFromForm;
    }

    public void setNameFromForm(String nameFromForm) {
        this.nameFromForm = nameFromForm;
    }

    public String getSurnameFromForm() {
        return surnameFromForm;
    }

    public void setSurnameFromForm(String surnameFromForm) {
        this.surnameFromForm = surnameFromForm;
    }

    public String getStatusFromForm() {
        return statusFromForm;
    }

    public void setStatusFromForm(String statusFromForm) {
        this.statusFromForm = statusFromForm;
    }

    public String getTcNoFromForm() {
        return tcNoFromForm;
    }

    public void setTcNoFromForm(String tcNoFromForm) {
        this.tcNoFromForm = tcNoFromForm;
    }

    public Date getDobFromForm() {
        return dobFromForm;
    }

    public void setDobFromForm(Date dobFromForm) {
        this.dobFromForm = dobFromForm;
    }

    public Integer getIdFromFormUserDetail() {
        return idFromFormUserDetail;
    }

    public void setIdFromFormUserDetail(Integer idFromFormUserDetail) {
        this.idFromFormUserDetail = idFromFormUserDetail;
    }

    public String getAdressFromForm() {
        return adressFromForm;
    }

    public void setAdressFromForm(String adressFromForm) {
        this.adressFromForm = adressFromForm;
    }

    public String getPhoneFromForm() {
        return phoneFromForm;
    }

    public void setPhoneFromForm(String phoneFromForm) {
        this.phoneFromForm = phoneFromForm;
    }

    public String getDepartmentFromForm() {
        return departmentFromForm;
    }

    public void setDepartmentFromForm(String departmentFromForm) {
        this.departmentFromForm = departmentFromForm;
    }

    public User getUserIdFromFormUserDetail() {
        return userIdFromFormUserDetail;
    }

    public void setUserIdFromFormUserDetail(User userIdFromFormUserDetail) {
        this.userIdFromFormUserDetail = userIdFromFormUserDetail;
    }

    public Student getSelectedstudent() {
        return selectedstudent;
    }

    public void setSelectedstudent(Student selectedstudent) {
        this.selectedstudent = selectedstudent;
    }

    public void show() {
        renderedPanel1 = true;
    }
    public void showDetail(){
        renderDetail = true;
    }

    public boolean isRenderedPanel1() {
        return renderedPanel1;
    }

    public void setRenderedPanel1(boolean renderedPanel1) {
        this.renderedPanel1 = renderedPanel1;
    }

    public List<User> getGetAllUsers() {
        StudentDao sdao = new StudentDao();
        getAllUsers = sdao.getAllUser();
        return getAllUsers;
    }
    


    public void setGetAllUsers(List<User> getAllUsers) {
        this.getAllUsers = getAllUsers;
    }

    public User getSelecteduser() {
        return selecteduser;
    }

    public void setSelecteduser(User selecteduser) {
        this.selecteduser = selecteduser;
    }

    public User getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(User studentUser) {
        this.studentUser = studentUser;
    }

    public boolean isRenderDetail() {
        return renderDetail;
    }

    public void setRenderDetail(boolean renderDetail) {
        this.renderDetail = renderDetail;
    }

    public List<Student> getGetAllStudent() {
        StudentDao sdao = new StudentDao();
       getAllStudent = sdao.getAllStudent();
        return getAllStudent;
    }

    public void setGetAllStudent(List<Student> getAllStudent) {
        this.getAllStudent = getAllStudent;
    }

    public int getSupvervisorTeacherId() {
        return supvervisorTeacherId;
    }

    public void setSupvervisorTeacherId(int supvervisorTeacherId) {
        this.supvervisorTeacherId = supvervisorTeacherId;
    }
    

}
