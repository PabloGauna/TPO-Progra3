package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String data = Utils.ReadFile("data.txt");

        Rompecabezas r = new Rompecabezas(data);
    }
}
