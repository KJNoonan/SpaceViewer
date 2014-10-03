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
public class ShipDelegateImplFactory {
    public static ShipDelegate createship(String id, String clrStr, Point3D loc, Point3D dest, double mStrng, double spd){
        return new ShipDelegateImpl(id,clrStr,loc,dest,mStrng,spd);
    }
}
