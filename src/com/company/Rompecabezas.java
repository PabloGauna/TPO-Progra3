package com.company;
import com.company.Ficha;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Rompecabezas {
    int filas;
    int columnas;

    Tablero tablero;
    Ficha[] fichas;

    public Rompecabezas(String data) {
        parseData(data);
    }

    private void parseData(String data) {
        String _data = new String(data);

        String[] parts = _data.split("-");
        String[] values = parts[0].split(",");

        filas = Integer.parseInt(values[0]);
        columnas = Integer.parseInt(values[1]);
        tablero = new Tablero(filas, columnas);

        fichas = new Ficha[Integer.parseInt(values[2])];

        _data = _data.substring(parts[0].length() + 1);
        String[] FichasStr = _data.split(" ");

        for (int i = 0; i < FichasStr.length; i++) {
            fichas[i] = new Ficha(FichasStr[i]);
        }
    }
}
