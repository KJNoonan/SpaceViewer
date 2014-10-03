/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identification;

import Exceptions.NullParamException;
import java.awt.Color;

/**
 *
 * @author Kevin
 */
public interface Identifiable {
    String getIdentifier();
    Color getColor();
    
    void setIdentifier(String id) throws NullParamException;
    void setColor(String clrStr) throws NullParamException;
}
