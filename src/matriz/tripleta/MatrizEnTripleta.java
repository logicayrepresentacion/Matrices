/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package matriz.tripleta;

import matriz.util.Tripleta;
import java.util.Scanner;


public class MatrizEnTripleta {

    protected Tripleta[] tripletas;

    /**
     * Construye una matriz en tripleta vacia, con un tamaño de arreglo del peor
     * caso y este es que la todas las posiciones esten llenas en tamaño del
     * arreglo es de f x c + 2 f x c representa los datos de la matriz posición
     * 0 es la tripleta de configuración ultima posición se deja reservada para
     * operaciones.
     *
     * @param f
     * @param c
     */
    public MatrizEnTripleta(int f, int c) {
        this.tripletas = new Tripleta[f * c + 2];
    }

    /**
     * Esta función permite crear una matriz en tripleta desde datos ingresados
     * por teclado y pantalla de texto.
     *
     * @return
     */
    public static MatrizEnTripleta contruirMatrizEnTripletaDesdePantalla() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cantidad de Filas ");
        int m = sc.nextInt();
        System.out.println("Cantidad de Columnas ");
        int n = sc.nextInt();
        MatrizEnTripleta matrizR = new MatrizEnTripleta(m, n);
        int cantidadValores = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                Object v = pedirDatoxPantalla(i, j);
                if (v != null) {
                    cantidadValores++;
                    Tripleta t = new Tripleta(i, j, v);
                    matrizR.setTripleta(cantidadValores, t);
                }
            }
        }

        Tripleta configuracion = new Tripleta(m, n, cantidadValores);
        matrizR.setTripleta(0, configuracion);
        return matrizR;
    }

    /**
     * Para pedir datos por pantalla, ejemplos de matriz de numeros incluyendo
     * los reales
     *
     * @param i
     * @param j
     * @return
     */
    private static Object pedirDatoxPantalla(int i, int j) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dato o numero de la fila:" + i + " columna: " + j);
        Double dato = Double.parseDouble(sc.nextLine());
        if (dato == 0) {
            return null;
        }
        return dato;
    }

    public void setTripleta(int cv, Tripleta t) {
        tripletas[cv] = t;
    }

    /**
     * Método para imprimir una MatrizEnTripleta por pantalla tipo texto, con
     * encabezados de columna y filas
     *
     */
    public void MostrarMatrizEnTripletaPorPantallaTexto() {
        // Obtengo la configuración de la matriz, fr y cr y la cantidadValores
        Tripleta configuracion = this.tripletas[0];
        int fr = configuracion.getF();
        int cr = configuracion.getC();
        int vr = (Integer) configuracion.getV();
        // Imprimir una línea con encabezado de las columnas
        System.out.print("\t");
        for (int i = 1; i <= cr; i++) {
            System.out.print(i + "\t");
        }

        System.out.println("");
        int posicionArreglo = 1;

        // Recorrido por una matriz virtual m x n
        for (int fv = 1; fv <= fr; fv++) {
            System.out.print(fv + "\t");
            for (int cv = 1; cv <= cr; cv++) {
                if (posicionArreglo <= vr) {
                    Tripleta triMo = tripletas[posicionArreglo];
                    int ft = triMo.getF();
                    int ct = triMo.getC();
                    if (fv == ft) {
                        if (cv == ct) {
                            Object vt = triMo.getV();
                            if (vt != null) {
                                System.out.print(vt + "\t");
                            } else {
                                System.out.print("0\t");
                            }
                        }
                    } else {
                        System.out.print("0\t");
                    }
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println("");
        }
    }

}
