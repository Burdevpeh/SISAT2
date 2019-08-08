

package com.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TT2019
 */
@Entity
@Table(name = "course_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseInfo.findAll", query = "SELECT c FROM CourseInfo c")
    , @NamedQuery(name = "CourseInfo.findById", query = "SELECT c FROM CourseInfo c WHERE c.id = :id")
    , @NamedQuery(name = "CourseInfo.findByGrade", query = "SELECT c FROM CourseInfo c WHERE c.grade = :grade")
    , @NamedQuery(name = "CourseInfo.findByExplanation", query = "SELECT c FROM CourseInfo c WHERE c.explanation = :explanation")})
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "GRADE")
    private String grade;
    @Basic(optional = false)
    @Column(name = "EXPLANATION")
    private String explanation;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Course courseId;

    public CourseInfo() {
    }

    public CourseInfo(Integer id) {
        this.id = id;
    }

    public CourseInfo(Integer id, String grade, String explanation) {
        this.id = id;
        this.grade = grade;
        this.explanation = explanation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
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
        if (!(object instanceof CourseInfo)) {
            return false;
        }
        CourseInfo other = (CourseInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pojo.CourseInfo[ id=" + id + " ]";
    }
    
}
