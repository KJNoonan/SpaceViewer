/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locatable;

import Exceptions.NullParamException;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class LocatableImpl implements Locatable{
    private Point3D location;           
    
    public LocatableImpl(Point3D loc) throws NullParamException{
        setLocation(loc);
    }
    
    @Override
    public Point3D getLocation() {return location;}

    @Override
    public void setLocation(Point3D loc)throws NullParamException {
        if (loc == null) throw new NullParamException("Location cannot be null.");
        location = loc;
    }
}
