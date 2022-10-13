package DesignPattern.Project.Factory;

import DesignPattern.Project.Strategy.Plane.Plane;

public class PlaneFactory extends TransportFactory{
    public static Plane createPlane(){
        return new Plane();
    }
}
