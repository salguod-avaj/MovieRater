/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.movierater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.AwfulMovies;
import model.entities.CsvExporter;
import model.entities.Director;
import model.entities.FavoriteMovies;
import model.entities.Movie;
import model.entities.TxtExporter;
import model.exceptions.IllegalNotesException;
import model.exceptions.IllegalYearException;
import model.interfaces.Exportable;
import model.interfaces.Insertable;

/**
 *
 * @author dg
 */
public class MovieRater {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String path = "/home/dg/NetBeansProjects/movieRater/movieslist";
        Exportable exporter;
        
        
        
        try{
           int choice;
           List<Movie> list = new ArrayList<>();
           Insertable movie;
            do {
                
                System.out.println("[1] Add a movie");
                System.out.println("[2] Remove a movie:");
                System.out.println("[3] Show list");
                System.out.println("[4] Export to CSV");
                System.out.println("[5] Export to TXT");
                System.out.println("[6] Exit");
                
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
                        double personalRating = sc.nextDouble();
                        System.out.println("Enter personal classification (A - Awful/ F - Favorite)");
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
                        try {
                            exporter = new CsvExporter(path + ".csv");
                            exporter.export(list);
                            System.out.println("Movies exported sucessfully");
                        }
                        catch(IOException e) {
                            System.out.println("Error exporting to CSV");
                        }
                        break;
                    case 5:
                        try {
                            exporter = new TxtExporter(path + ".txt");
                            exporter.export(list);
                            System.out.println("Movies exported sucessfully");
                        }
                        catch(IOException e) {
                            System.out.println("Error exporting to TXT");
                        }
                        break;
                    case 6:
                        System.out.println("Turning off...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } while (choice != 6);
            
        }
        catch(IllegalArgumentException e) {
            System.out.println("Invalid argument");
            e.printStackTrace();
        }
        catch(IllegalNotesException  e) {
            System.out.println(e);
        }
        catch(IllegalYearException e) {
            System.out.println(e);
        }
        finally{
            sc.close();
        }
        
    }
    
   
}
