/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

/**
 *
 * @author admin
 */
public class Nodo<T> {
    
    
    private T dato;
    private Nodo<T> siguiente;
    
    public Nodo(T dato)
    {
        this.dato=dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
