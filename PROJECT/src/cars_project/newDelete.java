/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amr
 */
public abstract class newDelete {

    //delete fuction
    public static void delete(String model) throws IOException {
        ArrayList<String> cars = storage("savedCars.txt");
        String[] carsArr;
        for (int i = 0; i < cars.size(); i++) {
            carsArr = cars.get(i).split(",");
            if (carsArr[0].equals(model)) {
                cars.remove(i);
                write_to_file("savedCars.txt", cars);
            }
        }
    }

    //storage function
    public static ArrayList<String> storage(String file) {
        ArrayList<String> all_data = new ArrayList<>();
        String rowData;
        try {
            Scanner s = new Scanner(new File(file));
            while (s.hasNext()) {
                rowData = s.nextLine();
                all_data.add(rowData);
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
            for (String x : cars) {
                fw.write(x + "\r\n");
            }
            fw.close();
        } catch (IOException e) {

        }
    }
}
