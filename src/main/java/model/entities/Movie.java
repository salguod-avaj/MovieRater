/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.interfaces.Insertable;


/**
 *
 * @author dg
 */
public abstract class Movie implements Insertable{
    protected String title;
    protected Integer year;
    protected double rating;
    protected String gender;
    protected int duration;
    protected Director director;
    protected int id;
    private static int nextId  = 1;

    public Movie() {
    }

    public Movie(String title, Integer year, double rating,  String gender, int duration, Director director) {
        this.id = nextId++;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.gender = gender;
        this.duration = duration;
        this.director = director;
        
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public Integer getYear() {
        return year;
    }

    
    public void setYear(Integer year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    
    public void setRating(double rating) {
        this.rating = rating;
    }

    
    public String getGender() {
        return gender;
    }

    
    public void setGender(String gender) {
        this.gender = gender;
    }

   
    public int getDuration() {
        return duration;
    }

   
    public Director getDirector() {
        return director;
    }
    
    public int getID() {
        return id;
    }
    
    
    public abstract String showMovies();
    
    
    public abstract String toString();
    
   
}
