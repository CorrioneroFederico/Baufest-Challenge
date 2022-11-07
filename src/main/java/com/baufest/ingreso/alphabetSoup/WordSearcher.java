package com.baufest.ingreso.alphabetSoup;

import java.util.Objects;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]){
        this.soup = soup;
    }

    /**
     * El objetivo de este ejercicio es implementar una función que determine si una palabra está en una sopa de letras.
     *
     * ### Reglas
     * - Las palabras pueden estar dispuestas direcciones horizontal o vertical, _no_ en diagonal.
     * - Las palabras pueden estar orientadas en cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
     * para abajo o viceversa.
     * - El cambio de dirección puede estar a media palabra, de modo que, por ejemplo, parte de la palabra
     * esté horizontal y de izquierda a derecha, parte esté vertical y de arriba hacia abajo, y otra parte horizontal
     * de derecha a la izquierda.
     *
     * @param word	Palabra a buscar en la sopa de letras.
     *
     * @return {@link Boolean}	true si la palabra se encuentra
     * en la sopa de letras.
     * */
    public boolean isPresent(String word){
        String[] letras = word.split("");
        int totalFilas = letras.length;
        int totalColumnas = soup[0].length;
        int indiceLetra = 0;

        for (int fila = 0; fila < totalFilas; fila++) {
            for (int columna = 0; columna < totalColumnas; columna++) {
                boolean encontrada = buscarLetra(letras, indiceLetra, fila, columna);
                if (encontrada) {
                    return true;
                }
            }
        }
        return false;
    }



    public boolean buscarLetra(String[] letras, int indiceLetra, int fila, int columna){
        boolean encontrada = false;
        if (Objects.equals(letras[indiceLetra], Character.toString(soup[fila][columna]))) {
            if(indiceLetra == letras.length-1){
                return true;
            }
            indiceLetra++;

            int ultimaFila = soup.length - 1;
            int ultimaColumna = soup[0].length - 1;

            if (fila + 1 <= ultimaFila) {
                encontrada = buscarLetra(letras, indiceLetra, fila + 1, columna);
            }
            if (fila - 1 >= 0 && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila - 1, columna);
            }
            if (columna + 1 <= ultimaColumna && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila, columna + 1);
            }
            if (fila + 1 <= ultimaFila && columna + 1 <= ultimaColumna && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila + 1, columna + 1);
            }
            if (columna - 1 >= 0 && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila, columna - 1);
            }
            if (fila - 1 >= 0 && columna - 1 >= 0 && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila - 1, columna - 1);
            }
            if (fila + 1 <= ultimaFila && columna - 1 >= 0 && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila + 1, columna - 1);
            }
            if (fila - 1 >= 0 && columna + 1 <= ultimaColumna && !encontrada) {
                encontrada = buscarLetra(letras, indiceLetra, fila - 1, columna + 1);
            }
        }
        return encontrada;
    }
}