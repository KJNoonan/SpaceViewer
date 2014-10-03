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
public class IdentifiableImpl implements Identifiable{
    private String identifier;
    private Color color;
    
    public IdentifiableImpl(String id, String clrStr)throws NullParamException{
    setIdentifier(id);
    setColor(clrStr);
    }

    
    @Override
    public String getIdentifier() {
        return identifier;
    }
    
    @Override
    public void setIdentifier(String id) throws NullParamException {
        if (id == null || id.length() == 0) {
            throw new NullParamException("Null or empty ID passed to identifier");
        }
        identifier = id;
    }

    @Override
    public Color getColor() {return color;}

    @Override
    public void setColor(String clrStr) throws NullParamException {
        if (clrStr == null || clrStr.length() == 0) {
            throw new NullParamException("Null or empty ID passed to color");
        }
        color = Color.getColor(clrStr);
    }
    }

