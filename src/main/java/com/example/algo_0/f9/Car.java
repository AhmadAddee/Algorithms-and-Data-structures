package com.example.algo_0.f9;

public class Car implements Comparable<Car>{
    private String brand;
    private String model;
    private double mil;

    public Car(String brand, String model, double mil) {
        this.brand = brand;
        this.model = model;
        this.mil = mil;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMil() {
        return mil;
    }

    public void setMil(double mil) {
        this.mil = mil;
    }

    @Override
    public int compareTo(Car o) {
        return brand.toLowerCase().compareTo(o.getBrand().toLowerCase());
    }
}
