package com.company;

import java.util.*;

public class Precedencia {
    public String raiz;
    public Precedencia izquierda;
    public Precedencia derecha;

    public Precedencia(Precedencia i, Precedencia d, String r) {
        this.raiz = r;
        this.izquierda = i;
        this.derecha = d;
    }

    String operacion() {
        if ("+".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            int[][] m1 = Matriz.getMatriz(n1).getValor();
            int[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "r" + Auxiliar.contador;
            Auxiliar.contador = Auxiliar.contador + 1;
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.suma(m1, m2));
            Auxiliar.matrices.add(auxV);
            Auxiliar.matriz_aux = Auxiliar.matrices.get(Auxiliar.matrices.size() - 1);
        }
        if ("-".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            int[][] m1 = Matriz.getMatriz(n1).getValor();
            int[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "r" + Auxiliar.contador;
            Auxiliar.contador = Auxiliar.contador + 1;
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.resta(m1, m2));
            Auxiliar.matrices.add(auxV);
            Auxiliar.matriz_aux = Auxiliar.matrices.get(Auxiliar.matrices.size() - 1);
        }
        if ("*".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            int[][] m1 = Matriz.getMatriz(n1).getValor();
            int[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "r" + Auxiliar.contador;
            Auxiliar.contador = Auxiliar.contador + 1;
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.multi(m1, m2));
            Auxiliar.matrices.add(auxV);
            Auxiliar.matriz_aux = Auxiliar.matrices.get(Auxiliar.matrices.size() - 1);
        }
        if ("^".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            int[][] m1 = Matriz.getMatriz(n1).getValor();
            int[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "r" + Auxiliar.contador;
            Auxiliar.contador = Auxiliar.contador + 1;
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.potencia(m1, m2));
            Auxiliar.matrices.add(auxV);
            Auxiliar.matriz_aux = Auxiliar.matrices.get(Auxiliar.matrices.size() - 1);
        }
        return this.raiz;
    }
}