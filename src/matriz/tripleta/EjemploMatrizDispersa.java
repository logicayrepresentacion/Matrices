/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz.tripleta;

/**
 *
 * @author alejandroescobar
 */
public class EjemploMatrizDispersa {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Programa para manejo de matriz en memoria");
        MatrizEnTripleta miMatriz = MatrizEnTripleta.contruirMatrizEnTripletaDesdePantalla();
        miMatriz.MostrarMatrizEnTripletaPorPantallaTexto();
    }

}
