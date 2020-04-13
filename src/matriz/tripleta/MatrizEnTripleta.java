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
     * Construye una matriz en tripleta vacia, con un tamaño de arreglo del
     * unico caso y este es que la todas las posiciones esten llenas con cero
     *
     * @param f
     * @param c
     */
    public MatrizEnTripleta(int f, int c) {
        this.tripletas = new Tripleta[1];
        Tripleta configuracion = new Tripleta(f, c, (int) 0);
        tripletas[0] = configuracion;
    }

    /**
     * Fijar un valor diferente de Cero en una celda
     *
     * @param filaDestino
     * @param columnaDestino
     * @param datoDestino
     * @throws java.lang.Exception
     */
    public void setCelda(int filaDestino, int columnaDestino, double datoDestino) throws Exception {
        Tripleta configuracion = tripletas[0];

        /**
         * Valido limites
         */
        int filas = configuracion.getF();
        int columnas = configuracion.getC();

        if (filas <= filaDestino || columnas <= columnaDestino) {
            throw new Exception("Esta fuera de los limites de la matriz");
        }

        /**
         * Fijamos el valor
         */
        int cantidadDatos = (int) configuracion.getV();
        Tripleta celdaDestino = null;
        int posicionInsertar = cantidadDatos + 1;
        for (int r = 1; cantidadDatos >= r; r++) {
            Tripleta tripletaRecorrido = tripletas[r];
            int filaRecorrido = tripletaRecorrido.getF();
            if (filaDestino > filaRecorrido) {
                // No hago nada
            } else if (filaDestino == filaRecorrido) {
                int columnaRecorrido = tripletaRecorrido.getC();
                if (columnaDestino > columnaRecorrido) {
                    // No hago nada  
                } else if (columnaDestino == columnaRecorrido) {
                    celdaDestino = tripletaRecorrido;
                } else {
                    posicionInsertar = r;
                }
            } else {
                posicionInsertar = r;
            }
        }

        /**
         * Valido si encontre la celda en el arreglo
         */
        if (celdaDestino == null) {
            celdaDestino = new Tripleta(filaDestino, columnaDestino, datoDestino);
            Tripleta[] nuevasTripletas = new Tripleta[cantidadDatos + 1 + 1];
            configuracion.setV(cantidadDatos + 1);
            for (int i = 0; i < nuevasTripletas.length; i++) {
                if (i < posicionInsertar) {
                    nuevasTripletas[i] = tripletas[i];
                } else if (i == posicionInsertar) {
                    nuevasTripletas[i] = celdaDestino;
                } else {
                    nuevasTripletas[i] = tripletas[i - 1];
                }
            }
            tripletas = nuevasTripletas;
        } else {
            celdaDestino.setV(datoDestino);
        }
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

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        // Obtengo la configuración de la matriz, fr y cr y la cantidadValores
        Tripleta configuracion = this.tripletas[0];
        int cantidadFilasMatriz = configuracion.getF();
        int cantidadColumnasMatriz = configuracion.getC();
        int valoresDiferentesCero = (Integer) configuracion.getV();

        int posicionArreglo = 1;

        // Recorrido por una matriz virtual m x n
        for (int filasVirtuales = 0; filasVirtuales < cantidadFilasMatriz; filasVirtuales++) {
            for (int columnasVirtuales = 0; columnasVirtuales < cantidadColumnasMatriz; columnasVirtuales++) {
                if (posicionArreglo <= valoresDiferentesCero) {
                    // Estoy en una posicion valida en el arreglo
                    Tripleta posibleTripletaMostrar = tripletas[posicionArreglo];
                    int filaCeldaMostrar = posibleTripletaMostrar.getF();
                    int columnaCeldaMostrar = posibleTripletaMostrar.getC();
                    if (filasVirtuales == filaCeldaMostrar) {
                        if (columnasVirtuales == columnaCeldaMostrar) {
                            Object valorCeldaMostrar = posibleTripletaMostrar.getV();
                            if (valorCeldaMostrar != null) {
                                cadena.append(" " + valorCeldaMostrar + " ");
                            } else {
                                cadena.append(" 0.0 ");
                            }
                            posicionArreglo++;
                        } else {
                            cadena.append(" 0.0 ");
                        }
                    } else {
                        cadena.append(" 0.0 ");
                    }
                } else {
                    cadena.append(" 0.0 ");
                }
            }
            cadena.append("\n");
        }

        return cadena.toString();
    }

    public Tripleta[] getTripletas() {
        return tripletas;
    }

    public int getCantidadValores() {
        return (int) tripletas[0].getV();
    }

}
