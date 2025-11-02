/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.Insertable;


/**
 *
 * @author dg
 */
public class FavoriteMovies extends Movie implements Insertable{

    private int personalRating;
    
    
   
    
    public FavoriteMovies() {
    }
   

    public FavoriteMovies(String title, Integer year, double rating, String gender, int duration, Director director, int personalRating) {
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
        sb.append("(Favorite) ");
        sb.append(title);
        sb.append(" | ");
        sb.append(id);
        
        return sb.toString();
    }

    @Override
    public void insert(List<Movie> movie) {
        movie.add(this);
        System.out.println("added to favorite movies");
    }

    
    @Override
    public String toString() {
    return String.format(
            "(Favorite) ID: %d | Title: %s | Year: %d | Rating: %.1f | Genre: %s | Duration: %d min | Director: %s | Personal Rating: %d",
            getId(),        // %d → inteiro (ID vem da superclasse)
            getTitle(),     // %s → string
            getYear(),      // %d → inteiro
            getRating(),    // %.1f → float com 1 casa decimal
            getGender(),    // %s → string
            getDuration(),  // %d → inteiro
            getDirector(),  // %s → toString() de Director
            personalRating  // %d → inteiro
        );
    }
    
    
    
}
