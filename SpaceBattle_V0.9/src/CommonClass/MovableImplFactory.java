/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;

import CommonClass.MovableImpl;
import CommonClass.Movable;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class MovableImplFactory {
   public static Movable createMovable(Point3D dest, double spd){
       return new MovableImpl(dest,spd);
   }
}
