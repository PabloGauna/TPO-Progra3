package com.company;

public class Ficha {
    public int alto;
    public int ancho;
    public boolean forma[][];
    byte rotacion;
    int id;

    public Ficha(String data, int id) {
        parseData(data);
        this.id = id;
    }

    public void parseData(String data){
        String _data = new String(data);
        _data = _data.replace("(", "");
        _data = _data.replace(")", "");

        String[] parts = _data.split("-");
        String[] values = parts[0].split(",");
        String[] formaStr = parts[1].split(",");

        alto = Integer.parseInt(values[0]);
        ancho = Integer.parseInt(values[1]);
        forma = new boolean[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                forma[i][j] = formaStr[i*ancho+j].equals("1");
            }
        }
    }

    public void RotarDerecha(){
        int _nuevoAlto = ancho;
        int _nuevoAncho = alto;
        boolean[][] _nuevaForma = new boolean[_nuevoAlto][_nuevoAncho];

        for (int i = 0; i < _nuevoAlto; i++) {
            for (int j = 0; j < _nuevoAncho; j++) {
                _nuevaForma[i][j] = forma[alto - j - 1][i];
            }
        }

        alto = _nuevoAlto;
        ancho = _nuevoAncho;
        forma = _nuevaForma;
        rotacion++;
    }

    public void RotarIzquierda(){
        int _nuevoAlto = ancho;
        int _nuevoAncho = alto;
        boolean[][] _nuevaForma = new boolean[_nuevoAlto][_nuevoAncho];

        for (int i = 0; i < _nuevoAlto; i++) {
            for (int j = 0; j < _nuevoAncho; j++) {
                _nuevaForma[i][j] = forma[j][ancho - i - 1];
            }
        }

        alto = _nuevoAlto;
        ancho = _nuevoAncho;
        forma = _nuevaForma;
        rotacion--;
    }
}
