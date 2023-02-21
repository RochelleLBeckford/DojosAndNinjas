package com.rochelle.dojos_ninjas_demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

// designate this as an Entity in my DB that i want to track 
@Entity
@Table(name = "dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // This will not allow the createdAt column to be updated after creation
    // will add our updatedAt and CreatedAt
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // now to set up my relationships
    // -> annotates the data type
    // specify that there is one dojo and many ninjas 
    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
    // list of ninjas
    private List<Ninja> ninjas;

    // Now can create Java Bean aka POJO
    // empty constructor
    public Dojo() {
    }
    
    // constructor with all fields
    public Dojo(Long id, String name, Date createdAt, Date updatedAt, List<Ninja> ninjas) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ninjas = ninjas;
    }

    /* 
    ~ since private need to access them -> getters and setters ~ 
    ~ POJO -> Plain old java object ~
        -> specific format for creating objects in java
        -> it has to have private attributes 
        -> it has to have a constructor that takes all the params
        -> it has to have getters and setters
        -> it has to have serialized
    -> spring will be able to use it w/o any other set up or config from us -> will be able to access our programs 
    ~ Now can go into controller ~
    -> needed to be a Java Been 
    -> added these id getter and setters so can access private Long id -> now need to create a route for this 
    */
    //~ Getters and setters 
    // have this setter b/c allows us to use and access the id -> not good practice to change the id -> SO DON'T CHANGE IT 

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // we have a getter to return our list of ninjas
    public List<Ninja> getNinjas() {
        return this.ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
    // ~ now need to do our ninja model 
}
