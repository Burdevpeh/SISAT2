package com.controller.bean;

import com.dao.LoginDAO;
import com.pojo.User;
import com.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import com.pojo.User;
import java.util.Map;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Login {

    private String email;
    private String pass;
    private String output_msg;
    private User myUser;
    
    public Login() {
    }

    public String fetchUser() {
        
        User user = null;
        if( (user = LoginDAO.CheckUser(email, pass) ) != null) {
             Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
             sessionMap.put("user", user);
            System.out.println("User var");
            return "welcome?facesRedirect=true";
        } else {
            System.out.println("User yok");
            return "welcome?facesRedirect=false";
        }
        
    }
 
    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }
    
    public String getOutput_msg() {
        return output_msg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
     
   
   

}