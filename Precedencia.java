package com.company;

import java.util.*;

public class Precedencia {
    public String raiz;
    public Precedencia izquierda;
    public Precedencia derecha;
    // Analiza la precedencia de un string, creando los subarboles hasta que solo queden hojas y procesandolos
    // respectivamente.
    public Precedencia(Precedencia i, Precedencia d, String r) {
        this.raiz = r;
        this.izquierda = i;
        this.derecha = d;
    }

    String operacion() {
        if ("+".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            double[][] m1 = Matriz.getMatriz(n1).getValor();
            double[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "aux";
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.suma(m1, m2));
            Auxiliar.matrices.add(auxV);
        }
        if ("-".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            double[][] m1 = Matriz.getMatriz(n1).getValor();
            double[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "aux";
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.resta(m1, m2));
            Auxiliar.matrices.add(auxV);
        }
        if ("*".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            double[][] m1 = Matriz.getMatriz(n1).getValor();
            double[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "aux";
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.multi(m1, m2));
            Auxiliar.matrices.add(auxV);
        }
        if ("^".equals(this.raiz)) {
            String n1 = (this.izquierda.operacion());
            String n2 = (this.derecha.operacion());
            double[][] m1 = Matriz.getMatriz(n1).getValor();
            double[][] m2 = Matriz.getMatriz(n2).getValor();
            String r = "aux";
            this.raiz = r;
            Matriz auxV = new Matriz(r, Auxiliar.potencia(m1, m2));
            Auxiliar.matrices.add(auxV);
        }
        return this.raiz;
    }
}