/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movable;

import Exceptions.InvalidParamException;
import Exceptions.NullParamException;
import Movable.Movable;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class MovableImpl implements Movable {
    private Point3D location;
    private Point3D destination;
    private double angle;
    private double speed;
        
    public MovableImpl(Point3D dest, double angle, double spd)throws InvalidParamException, NullParamException {
    setDestination(dest);
    setAngle(angle);
    setSpeed(spd);
    }

    @Override
    public double getAngle() {return angle;}
    @Override
    public double getSpeed() {return speed;}
    @Override
    public Point3D getDestination() {return destination;}
   

    @Override
    public void setAngle(double ang)throws InvalidParamException{
        if (ang < 0)throw new InvalidParamException("Angle cannot be negative.");
        angle = ang;
    }

    @Override
    public void setSpeed(double spd)throws InvalidParamException{
        if(spd < 0)throw new InvalidParamException("Speed cannot be negative.");
        speed = spd;
    }

    @Override
    public void setDestination(Point3D dest)throws NullParamException{
        if (dest == null) throw new NullParamException("Destination cannot be null.");
        destination = dest;
    }
   
}
