/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import utils.Point3D;

/**
 *
 * @author Kevin
 */
public interface Movable {
    double getSpeed();
    Point3D getDestination();
    
    void setSpeed(double speed);
    void setDestination(Point3D dest);
}
