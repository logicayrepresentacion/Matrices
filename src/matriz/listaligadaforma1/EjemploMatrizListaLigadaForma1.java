/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz.listaligadaforma1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import matriz.util.Tripleta;


/**
 *
 * @author Alejandro Escobar
 */
public class EjemploMatrizListaLigadaForma1 {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Ingrese las filas:");
        int f = sc.nextInt();
        System.out.println("Ingrese las columnas:");
        int c = sc.nextInt();

        // Creo el objeto matriz
        MatrizEnListaLigadaForma1 matriz = new MatrizEnListaLigadaForma1(f, c);
        Tripleta t;
        while ((t = ingresarTripletaPorPantalla()) != null) {
            matriz.insertar(t);
        }

        mostrarMatriz(matriz);

    }

    private static Tripleta ingresarTripletaPorPantalla() {
        System.out.println("Ingrese la tripleta separada por (coma ,) [ Ejemplo: 2,3,5] :");
        String datos[] = sc.next().split(",");
        Tripleta t = null;
        int f = Integer.valueOf(datos[0]);
        int c = Integer.valueOf(datos[1]);
        int v = Integer.valueOf(datos[2]);
        if (!(f == 0 || c == 0 || v == 0)) {
            t = new Tripleta(f, c, v);
        }
        return t;
    }
    
    private static Tripleta ingresarTripletaPorArchivo(String fileName) throws FileNotFoundException {
        System.out.println("Abriendo el archivo");
        Scanner entrada = new Scanner( new File(fileName));
        System.out.println("Leyendo primera linea de configuración de la matriz");
        String datos[];
        datos = entrada.nextLine().split(",");
        int f = Integer.valueOf(datos[0]);
        int c = Integer.valueOf(datos[1]);

        Tripleta t = null;
        
        for( int i = 1; i<=f; i++){
            datos = entrada.nextLine().split(",");
            for(int j = 1; j<=c && datos.length >= j; j++){
                int v = Integer.valueOf(datos[j-1]);
                t = new Tripleta(i, j, v);
            }
        }
        
      //  int f = Integer.valueOf(datos[0]);
      //  int c = Integer.valueOf(datos[1]);
        
        /*if (!(f == 0 || c == 0 || v == 0)) {
            
        }*/
        return t;
    }

    private static void mostrarMatriz(MatrizEnListaLigadaForma1 matriz) {
        matriz.mostrar();
    }
}
