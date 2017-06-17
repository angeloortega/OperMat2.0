package com.company;

import java.util.*;

public class Matriz{

    int[][] valor;
    String nombre;

    public Matriz(String n, int[][] v) {
        int index = -1;
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

    public int[][] transpuesta()
    {
        return valor;
    }

    public int[][] suma(Matriz obj2) {
        return valor;
    }
    public int[][] getValor(){return valor;}
}
