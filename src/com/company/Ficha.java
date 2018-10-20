package com.company;

public class Ficha {
    public int alto;
    public int ancho;
    public Boolean forma[][];

    public Ficha(String data) {
        parseData(data);
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
        forma = new Boolean[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                forma[i][j] = formaStr[i*ancho+j].equals("1");
            }
        }
    }
}
