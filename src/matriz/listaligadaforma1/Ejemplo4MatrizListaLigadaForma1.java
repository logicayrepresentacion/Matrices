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
public class Ejemplo4MatrizListaLigadaForma1 {

    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        String fname = "matriz.txt";
        MatrizEnListaLigadaForma1 matriz = crearMatrizDesdeArchivo(fname);
        System.out.println(matriz);
    }

    public static MatrizEnListaLigadaForma1 crearMatrizDesdeArchivo(String fname) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fname));
        String lineaConfiguracion = s.nextLine();
        String[] configuracion = lineaConfiguracion.split(" ");
        int filas = Integer.parseInt(configuracion[0]);
        int columnas = Integer.parseInt(configuracion[1]);
        MatrizEnListaLigadaForma1 mellf = new MatrizEnListaLigadaForma1(filas, columnas);

        while (s.hasNext()) {
            String lineaFila = s.nextLine();
            String[] lineaValores = lineaFila.split(" ");
            int i = Integer.parseInt("" + lineaValores[0]);
            int j = Integer.parseInt("" + lineaValores[1]);
            double v = Double.parseDouble("" + lineaValores[2]);
            mellf.setCelda(new Tripleta(i, j, v));
        }

        return mellf;

    }

}
