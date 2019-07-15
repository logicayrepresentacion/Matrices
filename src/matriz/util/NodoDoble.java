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
public class NodoDoble {
    private final Tripleta t;
    private NodoDoble ligaF;
    private NodoDoble ligaC;

    public NodoDoble(Tripleta t) {
        this.t = t;
    }
    
    public NodoDoble getLigaC() {
        return ligaC;
    }

    public Tripleta getT() {
        return t;
    }

    public NodoDoble getLigaF() {
        return ligaF;
    }

    public void setLigaC(NodoDoble ligaC) {
        this.ligaC = ligaC;
    }

    public void setLigaF(NodoDoble ligaF) {
        this.ligaF = ligaF;
    }
    
    
}
