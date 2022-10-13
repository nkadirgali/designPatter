package DesignPattern.Project.Factory;

import DesignPattern.Project.Strategy.Car.*;

import java.util.Scanner;

public class CarFactory extends TransportFactory{
    public static Car createCar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to customize or straight to the point:");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("\nEnter option (1-2): ");
        Car car = new Car();
        int option = sc.nextInt();
        switch (option) {
            case 1:
                car = startFactory();
                break;
            case 2:
                break;
            default:
                System.out.println("\nInput number invalid");
                break;
        }
        return car;
    }
    private static Car startFactory(){
        Car car;
        System.out.println("Choose body type of car");
        car = carBodyTypes();
        System.out.println("Choose fuel type of car");
        car = carFuelTypes(car);
        return car;
    }
    private static Car carBodyTypes(){
        System.out.println("Enter number:");
        System.out.println("1) Default");
        System.out.println("2) Hatchback");
        System.out.println("3) SUV");
        System.out.println("4) SportCar");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 && type>4){
            System.out.println("Please type number between 1 and 4");
            System.out.println("1) Default");
            System.out.println("2) Hatchback");
            System.out.println("3) SUV");
            System.out.println("4) SportCar");
            type=sc.nextInt();
        }
        return carBodyType(type);
    }
    private static Car carBodyType(int type){
        if(type==1) return new Car();
        else if(type==2) return new Hatchback(new Car());
        else if(type==3) return new SUV(new Car());
        else if(type==4) return new SportCar(new Car());
        else return null;
    }
    private static Car carFuelTypes(Car car){
        System.out.println("1) Default");
        System.out.println("2) Diesel");
        System.out.println("3) Electricity");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 && type>3){
            System.out.println("Please type number between 1 and 3");
            System.out.println("1) Default");
            System.out.println("2) Diesel");
            System.out.println("3) Electricity");
            type=sc.nextInt();
        }
        return carFuelType(type,car);
    }
    private static Car carFuelType(int type,Car car){
        if(type==1){
//            carDecorator=car.getDecorator();
            return carBodyType(car.getDecorator().charAt(0));
        }
        else if(type==2) return new Diesel(car);
        else if(type==3) return new Electricity(car);
        else return null;
    }
}