package com.company;

import java.util.*;
import static java.lang.Math.pow;
public class Auxiliar {

    public static ArrayList<Matriz> matrices = new ArrayList<Matriz>();

    public ArrayList<Matriz> get() {
        return matrices;
    }

    public static int contador = 0;

    public static int[][] e = new int[10][10];

    public static Matriz matriz_aux = new Matriz("auxiliar", e);

    public static int[][] suma(int[][] m1, int[][] m2) {
        int[][] resultado = new int[m1.length][m1[0].length];

        if (m1.length == m2.length & m1[0].length == m2[0].length) {
            int i, j;
            int row = m1.length;
            int column = m2.length;

            for (i = 0; i < row; i++)

            {

                for (j = 0; j < column; j++)

                {
                    resultado[i][j] = m1[i][j] + m2[i][j];
                }
            }
        }
        else
            {
                System.out.println("No se puede operar, asegurese de que las matrices cumplen con las condiciones" +
                        "de dimensiones requeridas para esta operacion");
            }
        return resultado;
    }

    public static int[][] resta(int[][] m1, int[][] m2) {
        int[][] resultado = new int[m1.length][m1[0].length];

        if (m1.length == m2.length & m1[0].length == m2[0].length) {
            int i, j;
            int row = m1.length;
            int column = m2.length;

            for (i = 0; i < row; i++)

            {

                for (j = 0; j < column; j++)

                {
                    resultado[i][j] = m1[i][j] - m2[i][j];
                }
            }
        }
        else
        {
            System.out.println("No se puede operar, asegurese de que las matrices cumplen con las condiciones" +
                    "de dimensiones requeridas para esta operacion");
        }
        return resultado;
    }

    public static int[][] multi(int[][] m1, int[][] m2) {
        int[][] resultado = new int[m1.length][m2[0].length];

        if (m1[0].length == m2.length) {
            int i, j;
            for (i = 0; i < m1.length; i++) {
                for (j = 0; j < m2[0].length; j++) {
                    for (int k = 0; k < m1[0].length; k++) {
                        resultado[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
        }
        else
        {
            System.out.println("No se puede operar, asegurese de que las matrices cumplen con las condiciones" +
                    "de dimensiones requeridas para esta operacion");
        }
        return resultado;
    }

    public static int[][] potencia(int[][] m1, int[][] m2) {
        int[][] resultado = new int[m1.length][m1[0].length];

        if (m1.length == m2.length & m1[0].length == m2[0].length) {
            int i, j;
            int row = m1.length;
            int column = m2.length;

            for (i = 0; i < row; i++)

            {

                for (j = 0; j < column; j++)

                {
                    double pot = pow(m1[i][j], m2[i][j]);
                    resultado[i][j] = (int) pot;
                }
            }
        }
        else
        {
            System.out.println("No se puede operar, asegurese de que las matrices cumplen con las condiciones" +
                    "de dimensiones requeridas para esta operacion");
        }
        return resultado;
    }
    public static ArrayList<Integer> orden(String op, int in, int fin){
        int a = 0;
        int b = 0;
        int largo= op.length();
        ArrayList<Integer> def= new ArrayList<>();
        while(b < largo+1){
            Character caracter= op.charAt(b);
            if (caracter.equals('(')){
                if(a == 0){
                    in= b;
                }
                a += 1;
            }
            if (caracter.equals(')')){
                a -= 1;
                if(a == 0){
                    fin = b;
                    break;
                }
            }
            b = b + 1;
        }
        def.add(in);
        def.add(fin);
        return def;
    }

    public static String normalizar(String op) {
        int a = 0;
        int b = 1;
        while (b < op.length()) {
            Character letra1 = op.charAt(a);
            Character letra2 = op.charAt(b);
            if (letra1.equals(letra2) && letra1.equals('*')) {
                String c = op.substring(0, a);
                String d = op.substring(b + 1, op.length());
                op = c + '^' + d;
                b = op.length();
            }
            a = a + 1;
            b = b + 1;
        }
        return op;
    }
    public static int cantidad(String op, char x){
        int cant = 0;
        for (int i=0; i < op.length(); i++)
        {
            if (op.charAt(i) == x)
            {
                cant++;
            }
        }
        return cant;
    }
    public static boolean parentesis1(String op){
        char s1 = 'x';
        char s2 = 'x';
        for (int i=0; i< op.length(); i++){
            Character actual= op.charAt(i);
            if (actual.equals('(')){
                s1= actual;
            }
            if(actual.equals(')')){
                s2= actual;
            }
        }
        if(s1 == '(' && s2 == ')'){
            return true;
        }
        else{
            return false;
        }
    }

    public static String quitarparfin(String op){
        StringBuffer ultimo= new StringBuffer();
        Character caracter0= op.charAt(0);
        int ultimocar= op.length() - 1;
        Character ulti= op.charAt(ultimocar);
        if (caracter0.equals('(') && ulti.equals(')')){
            for (int i=1; i< op.substring(1, ultimocar + 1).length(); i++){
                ultimo= ultimo.append(op.charAt(i));
            }

            return ultimo.toString();
        }
        return op;
    }
    public static boolean operacionesVal(String op){
        for (int i=0; i< op.length(); i++){
            Character actual= op.charAt(i);
            if(actual == '+' || actual == '-' || actual == '*' || actual == '^'){
                return true;
            }
        }
        return false;
    }
    public static Precedencia operar(String op) {
        int fin = 0;
        int in = 0;
        op = normalizar(op);
        op = quitarparfin(op);
        if (!operacionesVal(op)) {
            return new Precedencia(null, null, op);
        }
        if (parentesis1(op)) {
            ArrayList<Integer> orden = orden(op, in, fin);
            in = orden.get(0);
            fin = orden.get(1);
            try {
                if (op.charAt(fin + 1) == '+') {
                    Precedencia p1 = operar(op.substring(0, fin + 1));
                    Precedencia p2 = operar(op.substring(fin + 2, op.length()));
                    return new Precedencia(p1, p2, "+");
                }
                if (op.charAt(fin + 1) == '-') {
                    Precedencia p1 = operar(op.substring(0, fin + 1));
                    Precedencia p2 = operar(op.substring(fin + 2, op.length()));
                    return new Precedencia(p1, p2, "-");
                }
                if (op.charAt(fin + 1) == '*') {
                    Precedencia p1 = operar(op.substring(0, fin + 1));
                    Precedencia p2 = operar(op.substring(fin + 2, op.length()));
                    return new Precedencia(p1, p2, "*");
                }
                if (op.charAt(fin + 1) == '^') {
                    Precedencia p1 = operar(op.substring(0, fin + 1));
                    Precedencia p2 = operar(op.substring(fin + 2, op.length()));
                    return new Precedencia(p1, p2, "^");
                }
            } catch (Exception e) {
                if (op.charAt(in - 1) == '+') {
                    Precedencia p1 = operar(op.substring(0, in - 1));
                    Precedencia p2 = operar(op.substring(in, op.length()));
                    return new Precedencia(p1, p2, "+");
                }
                if (op.charAt(in - 1) == '-') {
                    Precedencia p1 = operar(op.substring(0, in - 1));
                    Precedencia p2 = operar(op.substring(in, op.length()));
                    return new Precedencia(p1, p2, "-");
                }
                if (op.charAt(in - 1) == '*') {
                    Precedencia p1 = operar(op.substring(0, in - 1));
                    Precedencia p2 = operar(op.substring(in, op.length()));
                    return new Precedencia(p1, p2, "*");
                }
            if (op.charAt(in - 1) == '^') {
                Precedencia p1 = operar(op.substring(0, in - 1));
                Precedencia p2 = operar(op.substring(in, op.length()));
                return new Precedencia(p1, p2, "^");
            }
        }
    }
        if (cantidad(op, '+') > 0) {
            Precedencia p1 = operar(op.substring(0, op.indexOf('+')));
            Precedencia p2 = operar(op.substring(op.indexOf('+') + 1, op.length()));
            return new Precedencia(p1, p2, "+");
        }
        if (cantidad(op, '-') > 0) {
            Precedencia p1 = operar(op.substring(0, op.indexOf('-')));
            Precedencia p2 = operar(op.substring(op.indexOf('-') + 1, op.length()));
            return new Precedencia(p1, p2, "-");
        }
        if (cantidad(op, '*') > 0) {
            Precedencia p1 = operar(op.substring(0, op.indexOf('*')));
            Precedencia p2 = operar(op.substring(op.indexOf('*') + 1, op.length()));
            return new Precedencia(p1, p2, "*");
        }
        if (cantidad(op, '^') > 0) {
            Precedencia p1 = operar(op.substring(0, op.indexOf('^')));
            Precedencia p2 = operar(op.substring(op.indexOf('^') + 1, op.length()));
            return new Precedencia(p1, p2, "^");
        }
        return new Precedencia(null, null, op);
    }
}
