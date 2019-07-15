/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz.listaligadaforma2;

import static matriz.Matriz.MATRIZTEXTO;
import matriz.util.NodoDoble;
import matriz.util.Tripleta;

/**
 *
 * @author alejandroescobar
 */
public class MatrizEnListaLigadaForma2 {

    NodoDoble conf; // en el libro se llama mat

    public MatrizEnListaLigadaForma2(int f, int c) {
        Tripleta t = new Tripleta(f, c, 0);
        conf = new NodoDoble(t);

        //Creo el Nodo cabeza y lo configuro para que sea lista ligada circular
        NodoDoble cabeza = new NodoDoble(null);
        cabeza.setLigaC(cabeza);
        cabeza.setLigaF(cabeza);

        // conecto con el nodo de configuración
        conf.setLigaC(cabeza);
        conf.setLigaF(cabeza);

    }

    public void insertar(Tripleta t) {
        System.out.print("  inicio insertar ");
        NodoDoble nuevoNodo = new NodoDoble(t);
        conectarFilas(nuevoNodo);
        conectarColumnas(nuevoNodo);
        int c = (Integer) conf.getT().getV();
        conf.getT().setV(c++);
        System.out.println("  fin insertar ");
    }

    private void conectarFilas(NodoDoble nuevoNodo) {
        System.out.print(" - conectar Columnas - ");
        // datos para la comparación
        int fNuevoNodo = nuevoNodo.getT().getF();
        int cNuevoNodo = nuevoNodo.getT().getC();

        // nodos para el recorrido
        NodoDoble cabeza = getCabeza();
        NodoDoble ultimo = cabeza;
        NodoDoble r = cabeza.getLigaF();

        while (r != cabeza && r.getT().getF() < fNuevoNodo) {
            ultimo = r;
            r = r.getLigaF();
        }

        while (r != cabeza && r.getT().getF() == fNuevoNodo && r.getT().getC() < cNuevoNodo) {
            ultimo = r;
            r = r.getLigaF();
        }

        ultimo.setLigaF(nuevoNodo);
        nuevoNodo.setLigaF(r);

    }

    private void conectarColumnas(NodoDoble nuevoNodo) {
        System.out.print(" - conectar Columnas - ");
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
        return conf.getLigaC();
    }

    public static MatrizEnListaLigadaForma2 entregarMatrizRelacion() {

        String[] filas = MATRIZTEXTO.split("\n");
        int cpc = filas[0].length();
        int cln = filas.length;
        System.out.println("Filas " + cln);
        System.out.println("Columnas " + cpc);

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
                        System.out.println("Adicionando valor en [" + i + "," + j + "]");
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

}
