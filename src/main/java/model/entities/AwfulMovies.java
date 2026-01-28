/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import model.exceptions.IllegalNotesException;
import model.interfaces.Insertable;


/**
 *
 * @author dg
 */
public class AwfulMovies extends Movie implements Insertable{
    private double personalRating;
    
    
    
    
    
    public AwfulMovies() {
    }
    
    public AwfulMovies(String title, Integer year, double rating, String gender, int duration, Director director, double personalRating) {
        super(title, year, rating, gender, duration, director);
        if(personalRating < 0.0) {
            throw new IllegalNotesException("Note cannot be lower than 0!");
        }
        if(personalRating > 5.0) {
            throw new IllegalNotesException("Note cannot be higher than 5!");
        }
        this.personalRating = personalRating;
    }

    
    public double getPersonalRating() {
        return personalRating;
    }

    
    public void setPersonalRating(double personalRating) {
        this.personalRating = personalRating;
    }

    @Override
    public String showMovies() {
        StringBuilder sb = new StringBuilder();
        sb.append("(Awful)");
        sb.append(title);
        sb.append(" | ");
        sb.append(id); 
        
        return sb.toString();
    }

    @Override
    public void insert(List<Movie> movie) {
        movie.add(this);
        System.out.println("added to awful movies");
    }

    
    
    @Override
    public String toString() {
        return String.format(
            "(Awful) ID: %d | Title: %s | Year: %d | Rating: %.1f | Genre: %s | Duration: %d min | Director: %s | Personal Rating: %.1f",
            getId(),       
            getTitle(),     
            getYear(),      
            getRating(),    
            getGender(),    
            getDuration(),  
            getDirector(),  
            personalRating  
        );
    }
    
     
}
 