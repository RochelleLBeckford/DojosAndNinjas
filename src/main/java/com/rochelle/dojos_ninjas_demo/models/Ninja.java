package com.rochelle.dojos_ninjas_demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ninjas")
public class Ninja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String first;
    private String last;
    private Integer age;

    // This will not allow the createdAt column to be updated after creation
    // will add our updatedAt and CreatedAt
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    //many to one link -> many ninjas to a dojo
    @ManyToOne(fetch = FetchType.LAZY)
    // have to specify the join column
    @JoinColumn(name = "dojo_id")
    private Dojo dojo;

    // Now can create Java Bean aka POJO
    // empty constructor
    public Ninja() {
    }

    // constructor with all fields
    public Ninja(Long id, String first, String last, Integer age, Date createdAt, Date updatedAt, Dojo dojo) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dojo = dojo;
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

    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Dojo getDojo() {
        return this.dojo;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

} 