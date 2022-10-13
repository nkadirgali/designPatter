package DesignPattern.Project.Factory;

import DesignPattern.Project.Strategy.Plane.Plane;
import DesignPattern.Project.Strategy.Transport;

public class TransportFactory {
    public Transport createTransport(boolean isCar){

        if (isCar) return new Transport(CarFactory.createCar(),null);
        else return new Transport(null, PlaneFactory.createPlane());
    }
}
