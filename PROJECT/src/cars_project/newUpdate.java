/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars_project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;

/**
 *
 * @author amr
 */
public abstract class newUpdate {

    //update fuction
    public static void update(String sModel, String model, String price, String year, String color, String speed, String carNumber, ImageIcon image) throws IOException {
        ArrayList<String> cars = storage("savedCars.txt");
        String[] carsArr;
        for (int i = 0; i < cars.size(); i++) {
            carsArr = cars.get(i).split(",");
            if (carsArr[0].equals(sModel)) {
                cars.set(i, model + "," + price + "," + color + "," + year + "," + speed + "," + carNumber + "," + image);
                write_to_file("savedCars.txt", cars);
            }
        }
    }

    //storage function
    public static ArrayList<String> storage(String file) {
        ArrayList<String> all_data = new ArrayList<>();
        String data;
        try {
            Scanner s = new Scanner(new File(file));
            while (s.hasNext()) {
                data = s.nextLine();
                all_data.add(data);
            }
            return all_data;
        } catch (IOException e) {

        }
        return null;
    }

    //write_to_file function
    public static void write_to_file(String filePath, ArrayList<String> cars) {
        try {
            FileWriter fw = new FileWriter(new File(filePath));
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (String x : cars) {
                    bw.write(x + "\r\n");
                }
            }
        } catch (IOException e) {

        }
    }
}
