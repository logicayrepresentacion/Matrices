/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz.util;

/**
 *
 * @author Alejandro Escobar
 */
public class NodoCabeza extends NodoDoble{

    NodoCabeza liga;
    
    public NodoCabeza(Tripleta t) {
        super(t);
    }

    public NodoCabeza getLiga() {
        return liga;
    }

    public void setLiga(NodoCabeza liga) {
        this.liga = liga;
    }

    
}
