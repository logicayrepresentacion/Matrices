/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda
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

import java.util.Scanner;
import matriz.util.MatrizTexto;
import matriz.util.Tripleta;

/**
 *
 * @author Usuario
 */
public class Ejemplo2MatrizListaLigadaForma2 {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Ingrese las filas:");
        int f = sc.nextInt();
        System.out.println("Ingrese las columnas:");
        int c = sc.nextInt();

        // Creo el objeto matriz
        MatrizEnListaLigadaForma2 matriz = new MatrizEnListaLigadaForma2(f, c);

        Tripleta t;
        while ((t = MatrizTexto.ingresarTripletaPorPantalla()) != null) {
            matriz.insertar(t);
        }

        matriz.mostrarMatrizEnTripletaPorPantallaTexto();

    }
}
