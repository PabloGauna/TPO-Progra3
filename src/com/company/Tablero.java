package com.company;

public class Tablero {
    int alto;
    int ancho;
    int[][] celdas;

    public Tablero(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;

        celdas = new int[alto][ancho];
    }

    // Devuelve true si se pudo agregar la ficha, y false si no se pudo agregar
    public Boolean AgregarFicha(Ficha ficha, int posicionAlto, int posicionAncho){
        if (posicionAlto + ficha.alto > this.alto)
            return false;
        if (posicionAncho + ficha.ancho > this.ancho)
            return false;

        Boolean canAddFicha = true;
        int[][] _nuevasCeldas = celdas.clone();

        int i = 0, j = 0;
        while (canAddFicha && i < ficha.alto) {
            _nuevasCeldas[i + posicionAlto][j + posicionAncho] += ficha.forma[i][j] ? 1 : 0;
            canAddFicha = _nuevasCeldas[i][j] <= 1;

            j++;
            i = (i * ficha.ancho + j) / ficha.ancho;
            j %= ficha.ancho;
        }

        if (canAddFicha)
            celdas = _nuevasCeldas;

        return canAddFicha;
    }
}
