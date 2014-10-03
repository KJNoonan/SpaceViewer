/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;

import CommonClass.Movable;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class MovableImpl implements Movable {
    private Point3D destination;
    private double speed;
        
    public MovableImpl(Point3D dest, double spd){
    setDestination(dest);
    setSpeed(spd);
    }

    @Override
    public double getSpeed() {return speed;}
    @Override
    public Point3D getDestination() {return destination;}

    @Override
    public void setSpeed(double spd){
        speed = spd;
    }

    @Override
    public void setDestination(Point3D dest){
       destination = dest;
    }
   
}
