/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.interfaces.Exportable;

/**
 *
 * @author dg
 */
public class TxtExporter implements Exportable{
    
    private  String  path;
    
    public TxtExporter(String path) {
        this.path = path;
    }
    
    @Override
    public void export(List<Movie> list) throws IOException {
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path,true))) {
            for(Movie x : list) {
                br.write(x.toString());
                br.newLine();
            }
        }
    }
    
}
