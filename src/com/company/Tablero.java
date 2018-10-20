package com.company;

import java.util.ArrayList;
import java.util.List;
import TDA.ConjuntoTDA;

public class Tablero {
    int alto;
    int ancho;
    boolean[][] celdas;

    ConjuntoTDA<Ficha> fichasAgregadas;

    public Tablero(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;

        celdas = new boolean[alto][ancho];
        fichasAgregadas = new Implementaciones.Conjunto<Ficha>();
        fichasAgregadas.inicializarConjunto();
    }

    public boolean SePuedeAgregar(Ficha ficha, int posicionAlto, int posicionAncho){
        if (posicionAlto + ficha.alto > this.alto)
            return false;
        if (posicionAncho + ficha.ancho > this.ancho)
            return false;

        boolean canAddFicha = true;

        int i = 0, j = 0;
        while (canAddFicha && i < ficha.alto) {
            canAddFicha = !( celdas[posicionAlto + i][posicionAncho + j] && ficha.forma[i][j] );

            j++;
            i = (i * ficha.ancho + j) / ficha.ancho;
            j %= ficha.ancho;
        }

        return canAddFicha;
    }

    public void AgregarFicha(Ficha ficha, int posicionAlto, int posicionAncho){
        for (int i=0 ; i < ficha.alto; i++){
            for (int j=0; j < ficha.ancho; j++){
                celdas[posicionAlto + i][posicionAncho + j] |= ficha.forma[i][j];
            }
        }
    }
}
