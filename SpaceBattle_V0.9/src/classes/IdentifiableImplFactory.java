/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


/**
 *
 * @author Kevin
 */
public class IdentifiableImplFactory {
    static Identifiable createIdentifiable(String id, String clrStr){
        return new IdentifiableImpl(id,clrStr);
    }
}
