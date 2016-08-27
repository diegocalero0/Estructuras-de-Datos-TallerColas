/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public class Colasimple <T> implements Iterable<T>{
    
    private Nodo<T> cabeza,cola;
    private int longitud;
    
    public Colasimple()
    {
        longitud=0;
        cabeza=cola=null;
    }
    
    
    public void encolar(T dato)
    {
        Nodo <T> aux=new Nodo<T>(dato);
        
        if(longitud==0){
            cabeza=aux;
            cola=aux;
        }
        else
        {
            cola.setSiguiente(aux);
            cola=aux;
        }
        longitud++;
    }
    
    public T desencolar()
    {
        T dato=null;
        
        if(longitud!=0)
        {
            dato=cabeza.getDato();
            cabeza=cabeza.getSiguiente();
            longitud--;
        }else
        {
            return null;
        }
        return dato;
    }
    
    public T verPrimero()
    {
        if(longitud!=0)
        {
            return cabeza.getDato();
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        Nodo<T> aux=cabeza;
        String res="[";
        while(aux!=null)
        {
            res+=aux.getDato().toString()+",";
            aux=aux.getSiguiente();
        }
        res+="]";
        return res;
    }
    
    public boolean contains(T dato)
    {
        Nodo<T> aux=cabeza;
        
        while(aux!=null)
        {
            if(aux.getDato().equals(dato))
            {
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    public int size()
    {
        return longitud;
    }


	@Override
	public Iterator<T> iterator() {
		return new Iterador(this);
	}
}
