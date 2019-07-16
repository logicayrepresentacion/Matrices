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
package matriz.listaligadaforma2;

import static matriz.Matriz.MATRIZTEXTO;
import matriz.util.NodoDoble;
import matriz.util.Tripleta;

public class MatrizEnListaLigadaForma2 {

    NodoDoble nodoConfiguracion; // en el libro se llama mat

    public MatrizEnListaLigadaForma2(int numeroFilas, int numeroColumnas) {
        construirNodosCabeza(numeroFilas, numeroColumnas);
    }

    /**
     * Métdo que construye el nodo configuración y nodo cabeza
     *
     * @param numeroFilas
     * @param numeroColumnas
     */
    private void construirNodosCabeza(int numeroFilas, int numeroColumnas) {
        Tripleta t = new Tripleta(numeroFilas, numeroColumnas, 0);
        nodoConfiguracion = new NodoDoble(t);

        //Creo el Nodo cabeza y lo configuro para que sea lista ligada circular
        NodoDoble cabeza = new NodoDoble(null);
        // Referencia circular por la liga filas y la liga columnas
        cabeza.setLigaC(cabeza);
        cabeza.setLigaF(cabeza);

        // conecto con el nodo de configuración
        nodoConfiguracion.setLigaC(cabeza);
        nodoConfiguracion.setLigaF(cabeza);
    }

    /**
     * Método para ingresar los datos de un nuevo registro e insertarlos en la
     * matriz
     *
     * @param fila fila donde se encuentra el dato
     * @param columna columnas donde se encuentra el dato
     * @param valor valor
     */
    public void insertar(int fila, int columna, int valor) {
        Tripleta nuevoTripletaRegistro = new Tripleta(fila, columna, valor);
        insertar(nuevoTripletaRegistro);
    }

    /**
     * Método para ingresar los datos de un nuevo registro e insertarlos en la
     * matriz
     *
     * @param t
     */
    public void insertar(Tripleta t) {
        NodoDoble nuevoNodo = new NodoDoble(t);
        conectarFilas(nuevoNodo);
        conectarColumnas(nuevoNodo);
        int c = (Integer) nodoConfiguracion.getT().getV();
        nodoConfiguracion.getT().setV(c++);
    }

    /**
     * Método que ingresa un nodo recorriendo la lista de las filas
     *
     * @param nuevoNodo
     */
    private void conectarFilas(NodoDoble nuevoNodo) {
        // datos para la comparación
        int filaNuevoNodo = nuevoNodo.getT().getF();
        int columnaNuevoNodo = nuevoNodo.getT().getC();

        // nodos para el recorrido
        NodoDoble cabeza = getCabeza();
        NodoDoble ultimo = cabeza;
        NodoDoble nodoRecorrido = cabeza.getLigaF();

        // Permite posicionar el nodoRecorrido en la fila correcta para ingresar 
        while (nodoRecorrido != cabeza && nodoRecorrido.getT().getF() < filaNuevoNodo) {
            ultimo = nodoRecorrido;
            nodoRecorrido = nodoRecorrido.getLigaF();
        }

        while (nodoRecorrido != cabeza && nodoRecorrido.getT().getF() == filaNuevoNodo && nodoRecorrido.getT().getC() < columnaNuevoNodo) {
            ultimo = nodoRecorrido;
            nodoRecorrido = nodoRecorrido.getLigaF();
        }

        ultimo.setLigaF(nuevoNodo);
        nuevoNodo.setLigaF(nodoRecorrido);
    }

    /**
     * Método que ingresa un nodo recorriendo la lista de las columnas
     *
     * @param nuevoNodo
     */
    private void conectarColumnas(NodoDoble nuevoNodo) {
        // datos para la comparación
        int fNuevoNodo = nuevoNodo.getT().getF();
        int cNuevoNodo = nuevoNodo.getT().getC();

        // nodos para el recorrido
        NodoDoble cabeza = getCabeza();
        NodoDoble ultimo = cabeza;
        NodoDoble r = cabeza.getLigaC();

        while (r != cabeza && r.getT().getC() < cNuevoNodo) {
            ultimo = r;
            r = r.getLigaC();
        }

        while (r != cabeza && r.getT().getC() == cNuevoNodo && r.getT().getF() < fNuevoNodo) {
            ultimo = r;
            r = r.getLigaC();
        }

        ultimo.setLigaC(nuevoNodo);
        nuevoNodo.setLigaC(r);

    }

    private NodoDoble getCabeza() {
        return nodoConfiguracion.getLigaC();
    }

    public static MatrizEnListaLigadaForma2 entregarMatrizRelacion() {

        String[] filas = MATRIZTEXTO.split("\n");
        int cpc = filas[0].length();
        int cln = filas.length;

        MatrizEnListaLigadaForma2 matrizEnListaLigadaForma2 = new MatrizEnListaLigadaForma2(cln, cpc);

        int i = 1;
        int j = 1;
        for (int x = 0; x < MATRIZTEXTO.length(); x++) {
            switch (MATRIZTEXTO.charAt(x)) {
                case '\n':
                    j = 1;
                    i++;
                    break;
                case '1':
                case '0':
                    int v = Integer.parseInt(x + "");
                    if (v != 0) {
                        matrizEnListaLigadaForma2.insertar(new Tripleta(i, j, v));
                    }
                    j++;
                    break;
                default:
                    System.out.println("Extraño " + (int) MATRIZTEXTO.charAt(x));
            }
        }

        return matrizEnListaLigadaForma2;
    }

    void mostrarMatrizEnTripletaPorPantallaTexto() {
        // Obtengo la configuración de la matriz, fr y cr y la cantidadValores
        Tripleta configuracion = nodoConfiguracion.getT();
        int fr = configuracion.getF();
        int cr = configuracion.getC();
        // Imprimir una línea con encabezado de las columnas
        System.out.print("\t");
        for (int i = 1; i <= cr; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("");

        NodoDoble nodoCabeza = nodoConfiguracion.getLigaF();
        NodoDoble nodoRecorrido = nodoCabeza.getLigaF();
        // Recorrido por una matriz virtual m x n
        for (int fv = 1; fv <= fr; fv++) {
            System.out.print(fv + "\t");
            for (int cv = 1; cv <= cr; cv++) {
                if (nodoRecorrido != null && nodoRecorrido != nodoCabeza) {
                    Tripleta triMo = nodoRecorrido.getT();
                    int ft = triMo.getF();
                    int ct = triMo.getC();
                    if (fv == ft) {
                        if (cv < ct) {
                            System.out.print("0\t");
                        } else if (cv == ct) {
                            Object vt = triMo.getV();
                            if (vt != null) {
                                System.out.print(vt + "\t");
                            } else {
                                System.out.print("ERROR x COLUMNAS!!!!");
                            }
                            nodoRecorrido = nodoRecorrido.getLigaF();
                        } else {
                            System.out.print("ERROR x COLUMNAS se paso!!!!");
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
