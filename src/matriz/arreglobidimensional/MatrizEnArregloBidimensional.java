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
package matriz.arreglobidimensional;

/**
 *
 * @author Usuario
 */
public class MatrizEnArregloBidimensional {

    private final double[][] matriz;

    public MatrizEnArregloBidimensional(double[][] matriz) {
        this.matriz = matriz;
    }

    public MatrizEnArregloBidimensional(int filas, int columnas) {
        matriz = new double[filas][columnas];
    }

    public double getCelda(int f, int c) {
        return matriz[f][c];
    }

    public void setCelda(int i, int j, double d) throws Exception {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas < i || columnas < j) {
            throw new Exception("Esta fuera de los limites de la matriz");
        }

        matriz[i][j] = d;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            double[] fila = matriz[i];
            for (int j = 0; j < fila.length; j++) {
                double d = fila[j];
                cadena.append(" " + d + " ");
            }
            cadena.append("\n");
        }
        return cadena.toString();
    }

}
