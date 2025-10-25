/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.Insertable;
import model.interfaces.Removable;

/**
 *
 * @author dg
 */
public class AwfulMovies extends Movie implements Insertable, Removable {
    private int personalRating;
    
    
    
    
    
    public AwfulMovies() {
    }
    
    public AwfulMovies(String title, Integer year, double rating, String gender, int duration, Director director, int personalRating) {
        super(title, year, rating, gender, duration, director);
        this.personalRating = personalRating;
    }

    
    public int getPersonalRating() {
        return personalRating;
    }

    
    public void setPersonalRating(int personalRating) {
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
    public void remove(List<Movie> movie) {
        movie.remove(this);
        System.out.println("removed from awful movies");
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(Favorite) ");
        sb.append(title);
        sb.append(" | ");
        sb.append(id);
        
        return sb.toString();
    }
    
     
}
 