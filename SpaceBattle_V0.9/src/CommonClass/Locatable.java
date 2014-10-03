/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public interface Locatable {
    Point3D getLocation();
    
    void setLocation(Point3D loc);
}
