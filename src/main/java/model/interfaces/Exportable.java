/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.interfaces;

import java.io.IOException;
import java.util.List;
import model.entities.Movie;

/**
 *
 * @author dg
 */
public interface Exportable {
    void export(List<Movie> movie) throws IOException;
}
