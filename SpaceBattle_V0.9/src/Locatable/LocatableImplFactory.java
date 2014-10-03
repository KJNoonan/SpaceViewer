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
public class LocatableImplFactory {
    public static Locatable createLocatable(Point3D loc) throws NullParamException{
        return new LocatableImpl(loc);
    }
}
