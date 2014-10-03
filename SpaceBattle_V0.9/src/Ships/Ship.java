/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ships;

import Exceptions.InvalidParamException;
import Exceptions.NullParamException;
import Health.Health;
import Locatable.Locatable;
import Movable.Movable;
import identification.Identifiable;
import utils.PolygonPlus;

/**
 *
 * @author Kevin
 */
public interface Ship extends Health, Movable, Identifiable, Locatable{
    abstract void setShape();
    abstract PolygonPlus getShape();
    abstract void move(int cycles)throws NullParamException, InvalidParamException;
}
