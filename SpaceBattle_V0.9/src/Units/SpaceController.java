/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;

import Exceptions.InvalidParamException;
import Exceptions.NullParamException;
import Ship.Ship;
import java.util.HashMap;
import java.util.Iterator;
import utils.Point3D;

/**
 *
 * @author knoonan8
 */
public class SpaceController {
    public static int xSize;//800
    public static int ySize;//900
    public static int zSize;//700
    private volatile static SpaceController instance;
    private static boolean setup = false;
    private static HashMap<String,Ship> allShips;
    private static HashMap<String,DebrisCloud> allClouds;
    
    public static SpaceController getInstance(){
        if (!setup){
            System.err.println("SpaceController 'setup' must be called before invoking the SpaceController");
        }
        if(instance == null){
            synchronized (SpaceController.class){
                if (instance == null){
                    instance = new SpaceController();
                }
            }
        }
        return instance;    
    }
    
    public static void setup(int x, int y, int z){
        if(!setup){
            xSize = x;
            ySize = y;
            zSize = z;
            setup = true;
        }
    }
    
    
    public static void addShip(Ship s) throws NullParamException{
        if (s == null){
            throw new NullParamException("Ship cannot be null");
        }
        allShips.put(s.getIdentifier(), s);
    }
    public static void removeShip(String ID) throws NullParamException{
        if (ID == null){
            throw new NullParamException("removeShip must recieve a non null ID");
        }
        allShips.remove(ID);
    }
    
    public static void addCloud(DebrisCloud d) throws NullParamException{
        if (d == null){
            throw new NullParamException("Debris Cloud cannot be null");
        }
        allClouds.put(d.getIdentifier(), d);
    }
    public static void removeCloud(String ID) throws NullParamException{
        if (ID == null){
           throw new NullParamException("Debris Cloud id cannot be null");
        }
        allClouds.remove(ID);
    }
    public static Point3D makePoint(){
        int xCoord = (int) (Math.random() * xSize);
        int yCoord = (int) (Math.random() * ySize);
        int zCoord = (int) (Math.random() * zSize);
        return new Point3D(xCoord, yCoord, zCoord);
    }
    
    public static Point3D makePointNear(Point3D p, double per) throws NullParamException, InvalidParamException{
        if (p == null) throw new NullParamException("MakePointNear must recieve a nonnull point");
        if (per <= 0) throw new InvalidParamException("MakePointNear must recieve a positive percentage");
        int xVar = (int) (SpaceController.xSize * per); 
        int yVar = (int) (SpaceController.ySize * per); 
        int zVar = (int) (SpaceController.zSize * per); 
        int xCoord = (int) (p.getX() * (1-(per/2))) + (int) (Math.random() * xVar); 
        int yCoord = (int) (p.getY() * (1-(per/2))) + (int) (Math.random() * yVar); 
        int zCoord = (int) (p.getZ() * (1-(per/2))) + (int) (Math.random() * zVar); 
        return new Point3D(xCoord, yCoord, zCoord);
    }
    
    public static void processDetonation(String id, Point3D location, double detonationRange, double damageMax) throws NullParamException, InvalidParamException{
        if (location == null) throw new NullParamException("ProcessDetonation must recieve a nonnull point");
        if (id == null) throw new NullParamException("ProcessDetonation must recieve a nonnull id");
        if (detonationRange <= 0) throw new InvalidParamException("ProcessDetonation must recieve a positive Detonation Range");
        if (damageMax <= 0) throw new InvalidParamException("ProcessDetonation must recieve a positive Max Damage");
     Iterator it = allShips.entrySet().iterator();
     while(it.hasNext()){
         HashMap.Entry pair = (HashMap.Entry)it.next();
         Ship s = (Ship)pair.getValue();
         it.remove();
         double d;
         d = location.distance(s.getLocation());
         if(d <= detonationRange){
             if(id.equals(s.getIdentifier())){
                 double damagePercent;
                 if(d > 0.0) damagePercent = (detonationRange-d)/detonationRange;
                 else damagePercent = 1.0;
                 
                 double damage = (0.5*damageMax)+(Math.random()*0.5*damageMax);
                 damage = damage*damagePercent;
                 
                 //Need to apply the damage to the ship
             }
         }
     }
    }
}
