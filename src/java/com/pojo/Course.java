/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TT2019
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
    , @NamedQuery(name = "Course.findByActs", query = "SELECT c FROM Course c WHERE c.acts = :acts")
    , @NamedQuery(name = "Course.findByHours", query = "SELECT c FROM Course c WHERE c.hours = :hours")
    , @NamedQuery(name = "Course.findByClassroom", query = "SELECT c FROM Course c WHERE c.classroom = :classroom")
    , @NamedQuery(name = "Course.findByQuota", query = "SELECT c FROM Course c WHERE c.quota = :quota")
    , @NamedQuery(name = "Course.findByCatagory", query = "SELECT c FROM Course c WHERE c.catagory = :catagory")
    , @NamedQuery(name = "Course.findByTerm", query = "SELECT c FROM Course c WHERE c.term = :term")
    , @NamedQuery(name = "Course.findByStatus", query = "SELECT c FROM Course c WHERE c.status = :status")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ACTS")
    private int acts;
    @Basic(optional = false)
    @Column(name = "HOURS")
    private int hours;
    @Basic(optional = false)
    @Column(name = "CLASSROOM")
    private String classroom;
    @Basic(optional = false)
    @Column(name = "QUOTA")
    private int quota;
    @Basic(optional = false)
    @Column(name = "CATAGORY")
    private String catagory;
    @Basic(optional = false)
    @Column(name = "TERM")
    private String term;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseInfo> courseInfoCollection;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String name, int acts, int hours, String classroom, int quota, String catagory, String term, boolean status) {
        this.id = id;
        this.name = name;
        this.acts = acts;
        this.hours = hours;
        this.classroom = classroom;
        this.quota = quota;
        this.catagory = catagory;
        this.term = term;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActs() {
        return acts;
    }

    public void setActs(int acts) {
        this.acts = acts;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<CourseInfo> getCourseInfoCollection() {
        return courseInfoCollection;
    }

    public void setCourseInfoCollection(Collection<CourseInfo> courseInfoCollection) {
        this.courseInfoCollection = courseInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pojo.Course[ id=" + id + " ]";
    }
    
}
