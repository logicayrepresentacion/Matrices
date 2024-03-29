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
package matriz.util;

import java.util.Scanner;
import matriz.tripleta.MatrizEnTripleta;

public class MatrizTexto {

    public static final String MATRIZTEXTO2 = "00101000000000000001000\n"
            + "00001000000000000100011\n"
            + "00101010000000000100010\n"
            + "01001000000000000011111\n"
            + "01101000000000000111111\n"
            + "00101010000000000110101\n"
            + "00001000000000000101101\n"
            + "00100010000000000110101\n"
            + "00100000000000000100000\n"
            + "00100010000000000101011\n"
            + "00000000000000000110000\n"
            + "01000110000000000100011\n"
            + "00000010000000000111001\n"
            + "00001110000000000101001\n"
            + "00000110000000000101010\n"
            + "00000110000000001111011\n"
            + "00000110000000001000010\n"
            + "00000010000000000001011\n"
            + "00000010000000000111011\n"
            + "00010000000000001101100\n"
            + "00010110000000000100000\n"
            + "00110100000000001101000\n"
            + "00010010000000000001000\n"
            + "00101100000000000100000\n"
            + "01011010000000000010000\n"
            + "00011110000000001101000\n"
            + "00110000000000000111000\n"
            + "01111000000000000101000\n"
            + "10011010000000000010000\n"
            + "01100110000000001011000\n"
            + "11011110000000000100100\n"
            + "11100100000000001111111\n"
            + "10010110000000000000001\n"
            + "10100100000000001000011\n"
            + "11011110000000000000010\n"
            + "11101010000000001000000\n"
            + "11101110000000000000011\n"
            + "10010101011100010000010\n"
            + "10011000001001010000010\n"
            + "11010011001000110000000\n"
            + "11011000000001110000010\n"
            + "10001001001000000000011\n"
            + "11011000001101100000011\n"
            + "10011000001100110000010\n"
            + "10010010001001100001111\n"
            + "10000011001000100101001\n"
            + "10000000000001110000100\n"
            + "10000011000101100101000\n"
            + "10000011000000100110110\n"
            + "10000111011001100001001\n"
            + "10000110000000100100010\n"
            + "10001110000000100100000\n"
            + "00000010011100100001000\n"
            + "00001110001100100100001\n"
            + "00000001001100000000000\n"
            + "00000101000000001110010\n"
            + "00001010010100100100111\n"
            + "00101101011101000011010\n"
            + "00000110011001100100010\n"
            + "00100010010000100111100\n"
            + "00110000011101101011110\n"
            + "00101011010101100011110\n"
            + "01100001010101100110010\n"
            + "01011001000000110010000\n"
            + "00110010100000000111000\n"
            + "00101011010000100110010\n"
            + "10110101110000110001010\n"
            + "11011001111100111111110\n"
            + "10011011100000111000010\n"
            + "11111010101100110101010\n"
            + "10100010110101110111111\n"
            + "11000011111101111011101\n"
            + "01010100010100111000100\n"
            + "01001000101101111110101\n"
            + "11100100001101100111100\n"
            + "00010001000010100011001\n"
            + "10001011001100000001110\n"
            + "11000010001110010101101\n"
            + "01001010001100010100001\n"
            + "10001010001100010010010\n"
            + "11001011001110000100110\n"
            + "10001011001110000110001\n"
            + "10110010001100010110010\n"
            + "10000010001110010111111\n"
            + "10000010001100000110110\n"
            + "10000011001100000100010\n"
            + "10000010001110000110011\n"
            + "11000111011101000111001\n"
            + "10000111011101000110100\n"
            + "10000010011100000111011\n"
            + "10000101011111001111001\n"
            + "00000000001100000100110\n"
            + "00000100011110000001000\n"
            + "00000101011110001001010\n"
            + "00000101010010000100010\n"
            + "00100100011000000001000\n"
            + "00100101011101000101010\n"
            + "00101101011110000000000\n"
            + "00010101011101001011000\n"
            + "00110101011101000001000\n"
            + "01001101000101001110010\n"
            + "01000101000101010101000\n"
            + "00001101011100100010010\n"
            + "01001000101001110000010\n"
            + "10011101001001101001000\n"
            + "11110101001001101101000\n"
            + "10010000100011000000100\n"
            + "11001000110011011100111\n"
            + "11101101111011101000001\n"
            + "11001100101011101000011\n"
            + "11011101111001100000001\n"
            + "11001101110001110000011\n"
            + "01111100011001110000001\n"
            + "01010101001011000000011\n"
            + "01010001010000110000000\n"
            + "11001001001001100000011\n"
            + "01001001101000100000000\n"
            + "11000101110001100000001\n"
            + "01011101000011110000011\n"
            + "00001001010011110000011\n"
            + "11001001010001110010011\n"
            + "11010001100001110001011\n"
            + "10001101000010110010110\n"
            + "11000101001000100010000\n"
            + "00001001101000110010100\n"
            + "00000001011000100001010\n"
            + "00000001000000100111111\n"
            + "00000101010000100010011\n"
            + "00001100010000100001101\n"
            + "00001001001000101100001\n"
            + "00000000011000101101010\n"
            + "00000100010000101011111\n"
            + "00001001000000101111100\n"
            + "00100001010001101001100\n"
            + "00000101000000100111000\n"
            + "01111101001001101001100\n"
            + "01100101001001101100100\n"
            + "01110000010001100110100\n"
            + "00001000011001001011100\n"
            + "00011000001000001000100\n"
            + "00011101011001110011000\n"
            + "00111000011001010011100\n"
            + "11000100001001001101100\n"
            + "10010100001001111111100\n"
            + "10101001011000111011100\n"
            + "10010000001000010111110\n"
            + "01000100000001101101111\n"
            + "00101000000001010111111\n"
            + "00000011001001001011101\n"
            + "11010111000001001111111\n"
            + "01110010111001110011111\n"
            + "01100110110000010101100\n"
            + "01000010100001000011001\n"
            + "01001010101011000110111\n"
            + "11101000001001000000001\n"
            + "00001000000011000000111\n"
            + "10000000000001000000111\n"
            + "00000000000001000000101\n"
            + "00001000000111000000101\n"
            + "00000000000111000000101\n"
            + "00000000000111000000001\n"
            + "00000000000111000000001\n"
            + "10000000000111000000011\n"
            + "11000100010111000000011\n"
            + "00000000010111000000111\n"
            + "00001000010111000000111\n"
            + "00000110111001000000111\n"
            + "00000011100111000101111\n"
            + "00000100010011000011011\n"
            + "00000010110101000000111\n"
            + "00000000111101000110010\n"
            + "00000010100000001111000\n"
            + "00000101110000000010000\n"
            + "00000001000000000001010\n"
            + "00000001110000001001010\n"
            + "00000001111000001001010\n"
            + "01000001110000001001010\n"
            + "01000001010000001101000\n"
            + "01000001100000000000010\n"
            + "00000001001000011001010\n"
            + "11000001111000011111010\n"
            + "01000001110000011000001\n"
            + "10000001110000011100110\n"
            + "00000001110101111100011\n"
            + "11000001100000101000011\n"
            + "10010100110011101000000\n"
            + "00000101100011001000011\n"
            + "10011101110100111000001\n"
            + "11001101101111011000001\n"
            + "10000001101110011000001\n"
            + "11001000111001110000010\n"
            + "10000001111011010000011\n"
            + "10001100111011010000011\n"
            + "11000000110011100000011\n"
            + "00001100110110100000010\n"
            + "10000110110010100000001\n"
            + "10001101110011110010100\n"
            + "11000101110111000100100\n"
            + "10000101110010000010100\n"
            + "11000101110010010110100\n"
            + "11000101110110010000100\n"
            + "11000001110010100110100\n"
            + "11000001110110110100100\n"
            + "11001001110010010100100\n"
            + "11000000011010101000100\n"
            + "10000100000000111000100\n"
            + "11000100011010010010100\n"
            + "11000000010100111000100\n"
            + "10000100000000100010100\n"
            + "10000111111111110111100\n"
            + "00000000000000000000000\n"
            + "01000010000000000000001\n"
            + "00100000000000100000000\n"
            + "00000000101000010100000\n"
            + "00000000000100001000000\n"
            + "01010100001011000100001\n"
            + "00100000000000000000000\n"
            + "00010010001001010101000\n"
            + "10000100000010000000000\n"
            + "10000100000010000000010\n"
            + "00000010000001000000000\n"
            + "00100000101000100001000\n"
            + "00010000100000000101000\n"
            + "00001000010100001000100\n"
            + "00010000000000000101000\n"
            + "00100000000000001010000\n"
            + "01000000000000000000000\n"
            + "00001100000110001000100\n"
            + "01000000000000000000001\n"
            + "10000000000100010001100\n";

    public static final String MATRIZTEXTO = "00101000000000000001000\n"
            + "00001000000000000100011\n"
            + "00101010000000000100010\n"
            + "01001000000000000011111\n"
            + "01101000000000000111111\n"
            + "00101010000000000110101\n"
            + "00001000000000000101101\n";

    public static Tripleta ingresarTripletaPorPantalla() {
        Scanner sc;
        sc = new Scanner(System.in);

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

}
