/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.MovableImpl;
import classes.Movable;
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
