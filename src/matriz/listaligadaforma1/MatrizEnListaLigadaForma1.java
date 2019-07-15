package matriz.listaligadaforma1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import matriz.Matriz;
import matriz.util.NodoDoble;
import matriz.util.NodoCabeza;
import matriz.util.Tripleta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alejandro Escobar
 */
public class MatrizEnListaLigadaForma1 {

    NodoCabeza nc;

    public NodoCabeza getNc() {
        return nc;
    }    
    
    MatrizEnListaLigadaForma1(int f, int c) {
        Tripleta tripletaConfiguracion = new Tripleta(f, c, 0);
        nc = new NodoCabeza(tripletaConfiguracion);

        // Depende de las f y c
        int max = (f > c) ? f : c;

        // Creo los nodos Cabeza de las listas de filas y columas
        // Estas a su vez hacen parte de la lista circular de nodos cabeza
        NodoCabeza ultimo = nc;
        for (int i = 1; i <= max; i++) {
            NodoCabeza nca = new NodoCabeza(new Tripleta(i, i, 0));
            nca.setLigaC((NodoDoble) nca);
            nca.setLigaF((NodoDoble) nca);
            ultimo.setLiga(nca);
            ultimo = nca;
        }
        // Establezco la referencia de la lista circular
        ultimo.setLiga(nc);
    }

    private MatrizEnListaLigadaForma1(NodoCabeza nc) {
        this.nc = nc;
    }

    public void insertar(Tripleta t) {

        // Creo el NodoDoble con los valores a ingresar
        NodoDoble nnuevo = new NodoDoble(t);

        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        NodoCabeza nCDeRecorrido = nc.getLiga();

        // Buscar el nodo cabeza correspondiente a la Fila del registro que 
        // estamos insertando y cuando lo encuentra inserta el registro en la lista
        // de esa fila
        while (nCDeRecorrido != nc && nCDeRecorrido != null) {
            if (nCDeRecorrido.getT().getF() == t.getF()) {
                insertarEnFila(nCDeRecorrido, nnuevo);
                break;
            }
            nCDeRecorrido = nCDeRecorrido.getLiga();
        }

        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        nCDeRecorrido = nc.getLiga();
        // Buscar el nodo cabeza correspondiente a la Columna del registro que
        // estamos insertando y cuando lo encuentra inserta el registro en la lista
        // por columna
        while (nCDeRecorrido != nc && nCDeRecorrido != null) {
            if (nCDeRecorrido.getT().getC() == t.getC()) {
                insertarEnColumna(nCDeRecorrido, nnuevo);
                break;
            }
            nCDeRecorrido = nCDeRecorrido.getLiga();
        }
    }

    private void insertarEnFila(NodoCabeza nCDeRecorrido, NodoDoble nnuevo) {
        NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
        NodoDoble ultimoNodoDeFila = (NodoDoble) nCDeRecorrido;
        while (nodoRecorrido != null && nodoRecorrido != (NodoDoble) nCDeRecorrido) {
            if (nnuevo.getT().getC() > nodoRecorrido.getT().getC()) {
                ultimoNodoDeFila = nodoRecorrido;
                nodoRecorrido = nodoRecorrido.getLigaF();
            } else {
                break;
            }
        }
        nnuevo.setLigaF(nodoRecorrido);
        ultimoNodoDeFila.setLigaF(nnuevo);
    }

    private void insertarEnColumna(NodoCabeza nodoCDeRecorrido, NodoDoble nnuevo) {
        NodoDoble s = nodoCDeRecorrido.getLigaC();
        NodoDoble ultimoNodoDeColumna = (NodoDoble) nodoCDeRecorrido;
        while (s != null && s != (NodoDoble) nodoCDeRecorrido) {
            if (nnuevo.getT().getF() > s.getT().getF()) {
                ultimoNodoDeColumna = s;
                s = s.getLigaC();
            } else {
                break;
            }
        }

        nnuevo.setLigaC(s);
        ultimoNodoDeColumna.setLigaC(nnuevo);
    }

    void mostrar() {
        // Colocar acá la logica de impresion
    }

    public MatrizEnListaLigadaForma1 obtenerIdentidad() {
        Tripleta configuracion = nc.getT();
        int filas = configuracion.getF();
        int cols = configuracion.getC();
        MatrizEnListaLigadaForma1 mI = crearIdentidad(filas, cols);
        return mI;
    }

    public static MatrizEnListaLigadaForma1 crearIdentidad(int f, int c) {
        Tripleta tripletaConfiguracion = new Tripleta(f, c, f);
        NodoCabeza nc;
        nc = new NodoCabeza(tripletaConfiguracion);
        MatrizEnListaLigadaForma1 mI = new MatrizEnListaLigadaForma1(nc);

        // Creo los nodos Cabeza de las listas de filas y columnas
        // Estas a su vez hacen parte de la lista circular de nodos cabeza
        NodoCabeza ultimo = nc;
        for (int i = 1; i <= f; i++) {
            // Este es el nodo cabeza de la lista circular de fila y de columna
            NodoCabeza nca = new NodoCabeza(new Tripleta(i, i, 0));
            // Creo el NodoDoble con los valores 1 a ingresar
            NodoDoble nnuevo = new NodoDoble(new Tripleta(1, 1, 1));
            // Creo la lista circular tanto para la final como para la columna
            // Para la columna
            nca.setLigaC(nnuevo);
            nnuevo.setLigaC(nca);
            // Para la fila
            nca.setLigaF(nnuevo);
            nnuevo.setLigaF(nca);

            //Lista circular de cabezas
            ultimo.setLiga(nca);
            ultimo = nca;
        }
        // Establezco la referencia de la lista circular
        ultimo.setLiga(nc);
        return mI;
    }

    public int getFilas() {
        return nc.getT().getF();
    }

    /**
     * Busca el valor de una celda i,j de la matriz o 0 en caso contrario
     *
     * @param i
     * @param j
     * @return
     */
    public int getCelda(int i, int j) {
        int valor = 0;

        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        NodoCabeza nCDeRecorrido = nc.getLiga();

        /**
         * Buscar el nodo cabeza correspondiente a la Fila del registro que
         * estamos buscando y cuando lo encuentra buscar el registro en la lista
         * de columnas de esa fila
         */
        while (nCDeRecorrido != nc && nCDeRecorrido != null) {
            // Cuando localice la fila busco la columna
            if (nCDeRecorrido.getT().getF() == i) {
                NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
                NodoDoble cabezaRecorrido = (NodoDoble) nCDeRecorrido;
                while (nodoRecorrido != null && nodoRecorrido != cabezaRecorrido) {
                    if (j > nodoRecorrido.getT().getC()) {
                        nodoRecorrido = nodoRecorrido.getLigaF();
                    } else {
                        // Cuando no es mayor valido si estoy en la columna
                        if (j == nodoRecorrido.getT().getC()) {
                            valor = (int) nodoRecorrido.getT().getV();
                        }
                        break;
                    }
                }
            }
            nCDeRecorrido = nCDeRecorrido.getLiga();
        }

        return valor;

    }

    public int getColumnas() {
        return nc.getT().getC();
    }

    public static NodoCabeza getCopiaListaFila(NodoCabeza nCDeRecorrido) {

        NodoCabeza copiaFila = new NodoCabeza(nCDeRecorrido.getT().clonar());
        copiaFila.setLigaF(copiaFila);
        NodoDoble ultimoNodoDeFilaCopia = (NodoDoble) copiaFila;

        NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
        NodoDoble cabezaRecorrido = (NodoDoble) nCDeRecorrido;
        while (nodoRecorrido != null && nodoRecorrido != cabezaRecorrido) {
            Tripleta tripletaCopia = nodoRecorrido.getT().clonar();
            NodoDoble nuevoNodocopia = new NodoDoble(tripletaCopia);
            ultimoNodoDeFilaCopia.setLigaF(nuevoNodocopia);
            ultimoNodoDeFilaCopia = nuevoNodocopia;
            nodoRecorrido = nodoRecorrido.getLigaF();
        }
        return copiaFila;
    }

    public NodoCabeza getFila(int i) {
        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        NodoCabeza nCDeRecorrido = nc.getLiga();

        /**
         * Buscar el nodo cabeza correspondiente a la Fila del registro que
         * estamos buscando y cuando lo encuentra clonar
         */
        while (nCDeRecorrido != nc && nCDeRecorrido != null) {
            // Cuando localice la fila 
            if (nCDeRecorrido.getT().getF() == i) {
                return nCDeRecorrido;
            }
        }
        return nCDeRecorrido;
    }

    public static void multiplicarFila(int x, NodoCabeza nCDeRecorrido) {
        NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
        NodoDoble cabezaRecorrido = (NodoDoble) nCDeRecorrido;
        while (nodoRecorrido != null && nodoRecorrido != cabezaRecorrido) {
            Tripleta t = nodoRecorrido.getT();
            int nv = (int) t.getV() * x;
            t.setV(nv);
            nodoRecorrido = nodoRecorrido.getLigaF();
        }
    }

    public static MatrizEnListaLigadaForma1 entregarMatrizRelacion() {

        String[] filas = Matriz.MATRIZTEXTO.split("\n");
        int cpc = filas[0].length();
        int cln = filas.length;
        System.out.println("Filas " + cln);
        System.out.println("Columnas " + cpc);

        MatrizEnListaLigadaForma1 matrizEnListaLigadaForma1 = new MatrizEnListaLigadaForma1(cln, cpc);

        int i = 1;
        int j = 1;
        for (int x = 0; x < Matriz.MATRIZTEXTO.length(); x++) {
            switch (Matriz.MATRIZTEXTO.charAt(x)) {
                case '\n':
                    j = 1;
                    i++;
                    break;
                case '1':
                case '0':
                    int v = Integer.parseInt(x + "");
                    if (v != 0) {
                        System.out.println("Adicionando valor en [" + i + "," + j + "]");
                        matrizEnListaLigadaForma1.insertar(new Tripleta(i, j, v));
                    }
                    j++;
                    break;
                default:
                    System.out.println("Extraño " + (int) Matriz.MATRIZTEXTO.charAt(x));
            }
        }

        return matrizEnListaLigadaForma1;
    }
    
    public static MatrizEnListaLigadaForma1 crearMatrizDesdeArchivo( String fname) throws FileNotFoundException{
        Scanner s = new Scanner( new File(fname));
        String lineaConfiguracion = s.nextLine();
        String[] configuracion = lineaConfiguracion.split(" ");
        int filas = Integer.parseInt( configuracion[0] );
        int columnas = Integer.parseInt( configuracion[1] );
        MatrizEnListaLigadaForma1 mellf = new MatrizEnListaLigadaForma1(filas, columnas);
        
        for( int i = 0; i< filas; i++){
            String lineaFila = s.nextLine();
            for( int j = 0; j<columnas; j++ ){
                int f = i+1;
                int c = j+1;
                int v = Integer.parseInt(  "" + lineaFila.charAt(j));
                if( v == 0 ){
                    mellf.insertar(new Tripleta(f, c, v));
                }
            }
        }
        return mellf;
        
    }
    

}
