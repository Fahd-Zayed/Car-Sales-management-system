/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class add_cars
{

    public add_cars() 
    {
        
    }
    
     public void save_add(String model, String price, String year, String color, String speed, String car_num, ImageIcon image) throws IOException
     {
        File f = new File("savedCars.txt");
        FileWriter addcar = new FileWriter(f, true);
        try (PrintWriter p = new PrintWriter(addcar)) {
            p.println(model + "," + price + "," + color + "," + year + "," + speed + "," + car_num + "," + image + "\n");
        p.close();
        }
    }

    void save_add(String model, String year, String color, String distance, String car_num, ImageIcon image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
