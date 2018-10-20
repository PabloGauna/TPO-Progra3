package com.company;
import TDA.ConjuntoTDA;

public class Rompecabezas {
    int filas;
    int columnas;
    int cantidadFichas;

    Tablero tablero;
    ConjuntoTDA fichasDisponibles = new Implementaciones.Conjunto<Ficha>();

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
        cantidadFichas = Integer.parseInt(values[2]);

        _data = _data.substring(parts[0].length() + 1);
        String[] FichasStr = _data.split(" ");

        fichasDisponibles.inicializarConjunto();

        for (int i = 0; i < FichasStr.length; i++) {
            fichasDisponibles.agregar(new Ficha(FichasStr[i]));
        }
    }

    public void Resolver(){
        while (tablero.AgregarFicha( (Ficha) fichasDisponibles.elegir(), 0, 0)) {
            fichasDisponibles.sacar(fichasDisponibles.elegir());
        }

        System.out.println();
    }
}
