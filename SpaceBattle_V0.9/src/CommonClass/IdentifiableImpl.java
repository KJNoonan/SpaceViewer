/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;

import java.awt.Color;
import utils.ColorMaker;

/**
 *
 * @author Kevin
 */
public class IdentifiableImpl implements Identifiable {

    private String identifier;
    private Color color;

    public IdentifiableImpl(String id, String clrStr) {
        setIdentifier(id);
        setColor(clrStr);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String id) {
        identifier = id;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(String clrStr) {
        color = ColorMaker.makeColor(clrStr);
    }
    
    @Override
    public void setColor(Color c) {
        color = c;
    }
}
