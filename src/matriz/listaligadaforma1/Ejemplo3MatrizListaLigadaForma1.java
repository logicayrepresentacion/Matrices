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
package matriz.listaligadaforma1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import matriz.util.Tripleta;
import matriz.util.MatrizTexto;

/**
 *
 * @author Alejandro Escobar
 */
public class Ejemplo3MatrizListaLigadaForma1 {

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
        while ((t = MatrizTexto.ingresarTripletaPorPantalla()) != null) {
            matriz.setCelda(t);
        }

        mostrarMatriz(matriz);

    }

    private static Tripleta ingresarTripletaPorArchivo(String fileName) throws FileNotFoundException {
        System.out.println("Abriendo el archivo");
        Scanner entrada = new Scanner(new File(fileName));
        System.out.println("Leyendo primera linea de configuración de la matriz");
        String datos[];
        datos = entrada.nextLine().split(",");
        int f = Integer.valueOf(datos[0]);
        int c = Integer.valueOf(datos[1]);

        Tripleta t = null;

        for (int i = 1; i <= f; i++) {
            datos = entrada.nextLine().split(",");
            for (int j = 1; j <= c && datos.length >= j; j++) {
                int v = Integer.valueOf(datos[j - 1]);
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
        System.out.println(matriz);
    }

    public static MatrizEnListaLigadaForma1 crearMatrizDesdeArchivo(String fname) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fname));
        String lineaConfiguracion = s.nextLine();
        String[] configuracion = lineaConfiguracion.split(" ");
        int filas = Integer.parseInt(configuracion[0]);
        int columnas = Integer.parseInt(configuracion[1]);
        MatrizEnListaLigadaForma1 mellf = new MatrizEnListaLigadaForma1(filas, columnas);

        for (int i = 0; i < filas; i++) {
            String lineaFila = s.nextLine();
            for (int j = 0; j < columnas; j++) {
                int f = i + 1;
                int c = j + 1;
                int v = Integer.parseInt("" + lineaFila.charAt(j));
                if (v == 0) {
                    mellf.setCelda(new Tripleta(f, c, v));
                }
            }
        }
        return mellf;

    }

}
