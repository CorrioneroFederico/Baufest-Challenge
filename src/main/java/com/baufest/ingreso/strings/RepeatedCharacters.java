package com.baufest.ingreso.strings;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     *     Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     *     Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {

        if(cadena == null || cadena.isEmpty()) return false;

        List<Integer> cantRepetidos = new ArrayList<>();
        cadena = cadena.trim();
        List<Character> arr = cadena.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        arr = arr.stream().sorted().collect(Collectors.toList());

        while(!arr.isEmpty()){
            cantRepetidos.add(Collections.frequency(arr, arr.get(0)));
            char elemento = arr.get(0);
            arr.removeIf(x -> x==elemento);
        }
        return cantRepetidos.size() == 1 || cantRepetidos.stream().distinct().count() < 3;
    }
}
