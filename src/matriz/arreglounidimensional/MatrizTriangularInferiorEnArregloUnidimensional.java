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
package matriz.arreglounidimensional;

/**
 *
 * @author Usuario
 */
public class MatrizTriangularInferiorEnArregloUnidimensional {

    private final double[] matriz;

    /**
     * Crea la representación de la matriz Tringular Inferior con Ceros
     *
     * @param filas
     * @param columnas
     */
    public MatrizTriangularInferiorEnArregloUnidimensional(int filas, int columnas) {
        int longitud = (filas * (filas - 1) / 2) + columnas;
        matriz = new double[longitud];
    }

    public void setCelda(int i, int j, double v) throws Exception {
        if (j <= i) {
            int posicion = (i * (i - 1) / 2) + j - 1;
            matriz[posicion] = v;
        } else {
            throw new Exception("La matriz representada es Triangular Inferior, no es posible almacenar en esta posición");
        }
    }

    public double getCelta(int i, int j) {
        if (j > i) {
            return 0;
        }
        int posicion = (i * (i - 1) / 2) + j - 1;
        return matriz[posicion];
    }

    @Override
    public String toString() {
        int l = matriz.length;
        int cantidadFilasMatriz = (int) ((Math.sqrt(1 + (8 * l)) - 1) / 2);
        int cantidadColumnasMatriz = cantidadFilasMatriz;

        StringBuilder cadena = new StringBuilder();

        // Imprimir una línea con encabezado de las columnas
        cadena.append("\t");
        for (int i = 1; i <= cantidadColumnasMatriz; i++) {
            cadena.append(i + "\t");
        }
        cadena.append("\n");

        for (int fv = 1; fv <= cantidadFilasMatriz; fv++) {
            cadena.append(fv + "\t");
            for (int cv = 1; cv <= cantidadColumnasMatriz; cv++) {
                double vt = getCelta(fv, cv);
                cadena.append(vt + "\t");
            }
            cadena.append("\n");
        }
        return cadena.toString();

    }

}
