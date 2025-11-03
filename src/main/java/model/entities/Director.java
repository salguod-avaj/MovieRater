/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

/**
 *
 * @author dg
 */
public class Director {
    private String director;
    
    public Director() {
    }
    
    public Director(String director) {
        this.director = director;
    }

    
    public String getDirector() {
        return director;
    }
    
    @Override
    public String toString() {
        return director;
    }
    
}
