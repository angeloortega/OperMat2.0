package com.company;

import java.util.*;

public class Matriz{

    int[][] valor;
    String nombre;

    public Matriz(String n, int[][] v) {
        int index = -1;
        if(n.equals("auxiliar"))
        {
            nombre = n;
            valor = v;
            return;
        }
        for(int i = 0; i < Auxiliar.matrices.size(); i++)
        {
            if(Auxiliar.matrices.get(i).getName().equals(n))
            {
                index = i;
                i = Auxiliar.matrices.size();
            }
        }

        if(index > -1)
        {
            Auxiliar.matrices.remove(index);
        }
        nombre = n;
        valor = v;
    }

    public String getName() {return nombre;}

    public static boolean existe(String n){
        n = n.trim();
        for (int i = 0; i < Auxiliar.matrices.size(); i++) {
            if (Auxiliar.matrices.get(i).getName().equals(n)) {
                return true;
            }
        }
        return false;
    }

    public static Matriz getMatriz(String n) {
        n = n.trim();
        for (int i = 0; i < Auxiliar.matrices.size(); i++) {
            if (Auxiliar.matrices.get(i).getName().equals(n)) {
                return Auxiliar.matrices.get(i);
            }
        }
        return null;
    }
    public static int[][] transpuesta(int[][] m)
    {
        int[][] resultado = new int[m[0].length][m.length];

        for(int i = 0; i < m.length; i++)

        {

            for(int j = 0; j < m[0].length; j++)

            {

                resultado[i][j] = m[j][i];
            }

        }
        return resultado;
    }
    public int[][] getValor(){return valor;}
}
