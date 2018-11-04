package com.company;
import TDA.VectorTDA;

public class Rompecabezas {
    int filas;
    int columnas;
    int cantidadFichas;

    Tablero tablero;
    VectorTDA<Ficha> fichasDisponibles = new Implementaciones.Vector<Ficha>();

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

        fichasDisponibles.inicializarVector(FichasStr.length);

        try {
            for (int i = 0; i < FichasStr.length; i++) {
                fichasDisponibles.agregarElemento(i, new Ficha(FichasStr[i]));
            }
        }catch (Exception e){

        }
    }

    public void Resolver(int posicionAlto, int posicionAncho, int indiceFicha) {
        try {
            while (posicionAlto < tablero.alto && posicionAncho < tablero.ancho) {
                Ficha fichaActual = (Ficha) fichasDisponibles.recuperarElemento(indiceFicha);

                if (tablero.SePuedeAgregar(fichaActual, posicionAlto, posicionAncho)) {
                    tablero.AgregarFicha(fichaActual, posicionAlto, posicionAncho);
                    Resolver(0, 0, indiceFicha + 1);
                } else {
                    posicionAncho++;
                    posicionAlto = (posicionAlto * tablero.ancho + posicionAncho) / tablero.ancho;
                    posicionAncho %= tablero.ancho;
                }

            }
        } catch (Exception e) {

        }
    }
}
