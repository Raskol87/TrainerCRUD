/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kyrik
 */
@Entity
@Table(catalog = "EntitiesCRUD", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idTrainer"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainers.findAll", query = "SELECT t FROM Trainers t")
    ,
               @NamedQuery(name = "Trainers.findByIdTrainer",
                query = "SELECT t FROM Trainers t WHERE t.idTrainer = :idTrainer")
    ,
               @NamedQuery(name = "Trainers.findByFirstName",
                query = "SELECT t FROM Trainers t WHERE t.firstName = :firstName")
    ,
               @NamedQuery(name = "Trainers.findByLastName",
                query = "SELECT t FROM Trainers t WHERE t.lastName = :lastName")
    ,
               @NamedQuery(name = "Trainers.findBySubject",
                query = "SELECT t FROM Trainers t WHERE t.subject = :subject")
})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idTrainer;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String firstName;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String lastName;
    @Column(length = 45)
    private String subject;
        @Column(length = 45)
    private String tag;

    public Trainer() {
    }

    public Trainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public Trainer(Integer idTrainer, String firstName, String lastName
    ) {
        this.idTrainer = idTrainer;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrainer != null
                 ? idTrainer.hashCode()
                 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.idTrainer == null && other.idTrainer != null) || (this.idTrainer != null && !this.idTrainer.
                                                                    equals(
                                                                    other.idTrainer)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Trainer[ idTrainer=" + idTrainer + " ]";
    }

}
