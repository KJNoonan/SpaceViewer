/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;

import classes.SpaceController;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class LocatableImpl implements Locatable{
    private Point3D location;           
    
    public LocatableImpl(Point3D loc){
        setLocation(loc);
    }
    
    @Override
    public Point3D getLocation() {return location;}

    @Override
    public void setLocation(Point3D loc){
        
        location = loc;
    }
}
