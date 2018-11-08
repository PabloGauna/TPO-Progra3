package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tablero implements Serializable {
    int alto;
    int ancho;
    int[][] celdas;

    public Tablero(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;

        celdas = new int[alto][ancho];
    }

    public Tablero ObtenerCopia() {
        Tablero copia = new Tablero(this.alto, this.ancho);

        for (int i=0; i < this.alto; i++){
            for (int j=0; j < this.ancho; j++) {
                copia.celdas[i][j] = this.celdas[i][j];
            }
        }

        return copia;
    }

    public boolean SePuedeAgregar(Ficha ficha, int posicionAlto, int posicionAncho){
        if (posicionAlto + ficha.alto > this.alto)
            return false;
        if (posicionAncho + ficha.ancho > this.ancho)
            return false;

        boolean canAddFicha = true;

        int i = 0, j = 0;
        while (canAddFicha && i < ficha.alto) {
            canAddFicha = !( (celdas[posicionAlto + i][posicionAncho + j] > 0) && ficha.forma[i][j] );

            j++;
            i = (i * ficha.ancho + j) / ficha.ancho;
            j %= ficha.ancho;
        }

        return canAddFicha;
    }

    public boolean EstaCompleto(){
        boolean completo = true;

        for (int i=0 ; i < this.alto; i++){
            for (int j=0; j < this.ancho; j++){
                completo &= celdas[i][j] > 0;
            }
        }

        return completo;
    }

    public void AgregarFicha(Ficha ficha, int posicionAlto, int posicionAncho){
        for (int i=0 ; i < ficha.alto; i++){
            for (int j=0; j < ficha.ancho; j++){
                if (ficha.forma[i][j]) {
                    celdas[posicionAlto + i][posicionAncho + j] = 1;
                }
            }
        }
    }
}
