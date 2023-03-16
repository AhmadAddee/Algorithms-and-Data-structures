package com.example.algo_0.f9;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class NB_27 {
    public static void main(String[] args) throws IOException {
        /****
         * a) Sorterar bilar mha Arrays.sort efter bilmärke.
         */
        Car[] cars = new Car[18];
        String fileName = "src/main/java/com/example/algo_0/f9/cars.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int index = 0;
        while((line = bufferedReader.readLine()) != null) { //Läs in bilar från textfilen
            String[] carData = line.split(",");
            cars[index++] = new Car(carData[0], carData[1], Double.parseDouble(carData[2]));
        }

        Arrays.sort(cars); //Sortera bilarna med hjälp av Java API

        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("src/main/java/com/example/algo_0/f9/sorted_cars.txt");
            bw = new BufferedWriter(fw);
            for(Car car : cars) {
                bw.write(car.getBrand() + "," + car.getModel() + "," + car.getMil());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /****
         * b) Sorterar bilar mha Arrays.sort efter årsmodell.
         */
        Arrays.sort(cars, new CompareCar()); //Sortera bilarna med hjälp av Java API

        bw = null;
        try {
            FileWriter fw = new FileWriter("src/main/java/com/example/algo_0/f9/sorted_cars_by_yearModel.txt");
            bw = new BufferedWriter(fw);
            for(Car car : cars) {
                bw.write(car.getBrand() + "," + car.getModel() + "," + car.getMil());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
