/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class LocatableImplFactory {
    public static Locatable createLocatable(Point3D loc){
            return new LocatableImpl(loc);
    }
}
