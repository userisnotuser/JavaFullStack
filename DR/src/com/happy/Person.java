package com.happy;


import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private String surname;
    private LocalDate newDate;
    private String post;



    public void setId(int id) {
        if(id>0)this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDate(LocalDate date){
       this.newDate = date;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return newDate;
    }

    public String getName() {
        return name;
    }



}
