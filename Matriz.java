package com.company;

// Clase Matriz donde se crean las matrices y se verifica que si los nombres de las nuevas matrices existen, se reempla
//cen en memoria

public class Matriz{

    double[][] valor;
    String nombre;

    public Matriz(String n, double[][] v) {
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

    public void setName(String n) {this.nombre = n;}

    public static boolean existe(String n){
        n = n.trim();
        for (int i = 0; i < Auxiliar.matrices.size(); i++) {
            if (Auxiliar.matrices.get(i).getName().equals(n)) {
                return true;
            }
        }
        return false;
    }
    //Retorna el objeto matriz utilizando su nombre
    public static Matriz getMatriz(String n) {
        n = n.trim();
        for (int i = 0; i < Auxiliar.matrices.size(); i++) {
            if (Auxiliar.matrices.get(i).getName().equals(n)) {
                return Auxiliar.matrices.get(i);
            }
        }
        return null;
    }
    // Retorna el valor transpuesto de una matriz dada
    public static double[][] transpuesta(double[][] m)
    {
        double[][] resultado = new double[m[0].length][m.length];

        for(int i = 0; i < m.length; i++)

        {

            for(int j = 0; j < m[0].length; j++)

            {

                resultado[i][j] = m[j][i];
            }

        }
        return resultado;
    }
    public double[][] getValor(){return valor;}
}
