package com.baufest.ingreso.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por
     * nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {

        if(jugadores==null) return jugadores;
        Comparator<Jugador> comparador = new Comparator<Jugador>() {
            @Override
            public int compare(Jugador a, Jugador b) {
                int resultado = Integer.compare(b.getPuntuacion(), a.getPuntuacion());
                if (resultado != 0) {
                    return resultado;
                }
                resultado = a.getNombre().compareTo(b.getNombre());
                return resultado;
            }
        };
        Collections.sort(jugadores,  comparador );
        return jugadores;
    }

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2
     * jugadores tienen igual cantidad de puntos, el que tiene menos perdidas se
     * lo considerara el mayor. Luego a igual puntos y perdidas se seguirá
     * usando el nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {
        Comparator<Jugador> comparador = new Comparator<Jugador>() {
            public int compare(Jugador a, Jugador b) {
                int resultado = Integer.compare(b.getPuntuacion(), a.getPuntuacion());
                if (resultado != 0) {
                    return resultado;
                }
                resultado = Integer.compare(a.getPerdidas(), b.getPerdidas());
                if (resultado != 0) {
                    return resultado;
                }
                resultado = a.getNombre().compareTo(b.getNombre());
                return resultado;
            }
        };
        Collections.sort(jugadores,  comparador );
        return jugadores;
    }
}
