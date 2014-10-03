/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movable;

import Exceptions.InvalidParamException;
import Exceptions.NullParamException;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public interface Movable {
    double getAngle();
    double getSpeed();
    Point3D getDestination();
    
    
    void setAngle(double angle)throws InvalidParamException;
    void setSpeed(double speed)throws InvalidParamException;
    void setDestination(Point3D dest)throws NullParamException;
}
