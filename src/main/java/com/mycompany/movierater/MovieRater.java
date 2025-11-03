/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.movierater;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.AwfulMovies;
import model.entities.Director;
import model.entities.FavoriteMovies;
import model.entities.Movie;
import model.interfaces.Insertable;

/**
 *
 * @author dg
 */
public class MovieRater {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String path = "/home/dg/NetBeansProjects/movieRater/movieslist.csv";
        
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path, true))){
           int choice;
           List<Movie> list = new ArrayList<>();
           Insertable movie;
            do {
                
                System.out.println("[1] add a movie");
                System.out.println("[2] remove a movie:");
                System.out.println("[3] show list");
                System.out.println("[4] move to spread sheet");
                System.out.println("[5] exit");
                
                System.out.println("Select a option: ");
                choice = sc.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("Enter movie title: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.println("Enter movie year: ");
                        Integer year = sc.nextInt();
                        System.out.println("Enter movie rating: ");
                        double rating = sc.nextDouble();
                        System.out.println("Enter movie gender: ");
                        sc.nextLine();
                        String gender = sc.nextLine();
                        System.out.println("Enter movies's duration: ");
                        int duration = sc.nextInt();
                        System.out.println("Enter movies's director: ");
                        sc.nextLine();
                        String director = sc.nextLine();
                        System.out.println("Enter your personal rating: ");
                        int personalRating = sc.nextInt();
                        System.out.println("Enter personal classification (A - Awful/ F - favorite)");
                        char newChoice = sc.next().toLowerCase().charAt(0);
                        if(newChoice == 'f') {
                            movie = new FavoriteMovies(title, year, rating, gender, duration, new Director(director), personalRating);
                            movie.insert(list);
                        }
                        else{
                            movie = new AwfulMovies(title,year,rating,gender,duration, new Director(director), personalRating);
                            movie.insert(list);
                        }
                        break;
                    case 2:
                        System.out.println("Enter a id to search: ");
                        int id = sc.nextInt();
                        boolean removed = list.removeIf(x -> x.getId() == id);
                        if(removed) {
                            System.out.println("Removed movie with id " + id);
                        }
                        else {
                            System.out.println("No movie found with this id.");
                        }
                        break;
                    case 3:
                        for(Movie x : list) {
                            System.out.println(x);
                        }
                        break;
                    case 4:
                        for(Movie x : list) {
                            br.write(x.toString());
                            br.newLine();
                            System.out.println("moving...");
                        }
                        
                        
                        break;
                }
            } while (choice != 5);
            
        }
        catch(IllegalArgumentException e) {
            System.out.println("Invalid argument");
            e.printStackTrace();
        }
        catch(IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
        
    }
}
