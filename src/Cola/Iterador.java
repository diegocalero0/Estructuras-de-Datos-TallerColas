/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;


import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Iterador<T> implements Iterator{

    private Colasimple <T> cola;
    
    
    public Iterador( Colasimple cola)
    {
        this.cola=cola;
        
    }
    
    
    @Override
    public boolean hasNext() {
       return cola.size()>0;
    }

    @Override
    public Object next() {

        Object o=null;
        if(cola.size()>0)
        {
            o=cola.desencolar();
        }
        return o;
    }
    
}
