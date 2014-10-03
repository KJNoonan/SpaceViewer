/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identification;

import Exceptions.NullParamException;

/**
 *
 * @author Kevin
 */
public class IdentifiableImplFactory {
    public static Identifiable createIdentifiable(String id, String clrStr) throws NullParamException{
        return new IdentifiableImpl(id,clrStr);
    }
}
