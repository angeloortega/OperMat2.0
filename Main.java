package com.company;

import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean ciclo = true;
        System.out.println("OperMat v.2.0. Angelo Ramírez 2017080055");

        while (ciclo) {

            System.out.print(">>> ");
            String c = scan.nextLine();
            c = c.toLowerCase();
            c = c.trim();
            List<String> comando = new ArrayList<String>(Arrays.asList(c.split(" ")));
            String[] arrcom = c.split(" ");
            String[] op = normalizar(arrcom);
            if(comando.size() == 1 & comando.get(0).equals("")) {
                c = scan.nextLine();
                c = c.toLowerCase();
                c = c.trim();
                comando = new ArrayList<String>(Arrays.asList(c.split(" ")));
            }

            if (comando.size() == 1) {
                switch (comando.get(0)) {
                    case "fin":
                        System.out.println(comando.get(0));
                        ciclo = false;
                        break;

                    case "ayuda":
                        System.out.println(comando);

                        break;

                    case "acercade":
                        System.out.println("Acerca De:\nOperMat v. 1.0.\n05/31/2017\n" +
                                "Angelo Ramírez Ortega\n2017080055\n");
                        break;

                    case "ace":
                        System.out.println("Acerca De:\nOperMat v. 1.0.\n05/31/2017\n" +
                                "Angelo Ramírez Ortega\n2017080055\n");
                        break;

                    case "imprimir":
                        for(Matriz m : Auxiliar.matrices) {
                            int i, j;
                            System.out.println(m.getName() + ":");
                            int row = m.getValor().length;
                            int column = m.getValor()[0].length;
                            for (i = 0; i < row; i++) {

                                System.out.print("[");
                                for (j = 0; j < column; j++)

                                {
                                    if (j > 0) {
                                        System.out.print(",");
                                    }
                                    System.out.print(m.getValor()[i][j]);

                                }
                                System.out.print("]");

                                System.out.println(" ");
                            }
                        }
                        break;
                    default:
                        if(Existen(op)){
                        for(String s : op){

                            System.out.println(Matriz.getMatriz(s).getName() + ":");
                            int row = Matriz.getMatriz(s).getValor().length;
                            int column = Matriz.getMatriz(s).getValor()[0].length;
                            for (int i = 0; i < row; i++)

                            {

                                System.out.print("[");
                                for (int j = 0; j < column; j++)

                                {
                                    if (j > 0) {
                                        System.out.print(",");
                                    }
                                    System.out.print(Matriz.getMatriz(s).getValor()[i][j]);

                                }
                                System.out.print("]");

                                System.out.println(" ");
                            }
                        }
                        continue;
                        }
                        System.out.println("Comando invalido," + " '" + c
                                + "' " + "por favor intente de"
                                + " nuevo o utilice 'ayuda' para ayuda");
                        break;
                }
            } else if (comando.size() == 2) {
                switch (comando.get(0)) {
                    case "lee":
                        try {
                            int i, j;

                            System.out.print("Coloque la cantidad de filas y columnas: ");
                            String x = scan.nextLine();
                            List<String> sinx = new ArrayList<String>(Arrays.asList(x.split("x")));
                            if(x.indexOf('x')>-1){
                                sinx = new ArrayList<String>(Arrays.asList(x.split("x")));
                            }
                            else
                                {
                                    sinx = new ArrayList<String>(Arrays.asList(x.split(" ")));
                                }
                            int row = Integer.parseInt(sinx.get(0));
                            int column = Integer.parseInt(sinx.get(1));
                            int matriz[][] = new int[row][column];

                            for (i = 0; i < row; i++)

                            {

                                for (j = 0; j < column; j++)

                                {
                                    System.out.print("Fila " + Integer.toString(i + 1) + " Columna "
                                            + Integer.toString(j + 1) + ": ");
                                    matriz[i][j] = scan.nextInt();

                                }
                            }

                            System.out.println(comando.get(1) + ":");

                            for (i = 0; i < row; i++)

                            {

                                System.out.print("[");
                                for (j = 0; j < column; j++)

                                {
                                    if (j > 0) {
                                        System.out.print(",");
                                    }
                                    System.out.print(matriz[i][j]);

                                }
                                System.out.print("]");

                                System.out.println(" ");
                            }
                        Auxiliar.matrices.add(new Matriz(comando.get(1), matriz));
                        }
                        catch(Exception e){System.out.println("Ha ocurrido un error al insertar su matriz");}
                        break;

                    default:
                        if(Existen(op)){
                            for(String s : op){

                                System.out.println(Matriz.getMatriz(s).getName() + ":");
                                int row = Matriz.getMatriz(s).getValor().length;
                                int column = Matriz.getMatriz(s).getValor()[0].length;
                                for (int i = 0; i < row; i++)

                                {

                                    System.out.print("[");
                                    for (int j = 0; j < column; j++)

                                    {
                                        if (j > 0) {
                                            System.out.print(",");
                                        }
                                        System.out.print(Matriz.getMatriz(s).getValor()[i][j]);

                                    }
                                    System.out.print("]");

                                    System.out.println(" ");
                                }
                            }
                            continue;
                        }
                        System.out.println("Comando invalido," + " '" + c
                                + "' " + "por favor intente de"
                                + " nuevo o utilice 'ayuda' para ayuda");
                        break;
                }
            }


            else if(c.indexOf('+')>-1 | c.indexOf('-')>-1 | c.indexOf('*')>-1 | c.contains("**")){

                if(Existen(op)){
                    try {
                        String orden = sinEspacios(c);
                        Auxiliar.operar(orden).operacion();
                        Matriz resultado = Auxiliar.matrices.get(Auxiliar.matrices.size() - 1);
                        int i,j;
                        int row = resultado.getValor().length;
                        int column = resultado.getValor()[0].length;
                        System.out.print(c + ":");
                        System.out.println("");
                        for (i = 0; i < row; i++)

                        {

                            System.out.print("[");
                            for (j = 0; j < column; j++)


                            {
                                if (j > 0) {
                                    System.out.print(",");
                                }
                                System.out.print(resultado.getValor()[i][j]);

                            }
                            System.out.print("]");

                            System.out.println(" ");
                        }
                    }
                    catch (Exception e){
                        System.out.println("Ha ocurrido un error al operar sus matrices, asegurese de que sus parentesis" +
                                " esten completos");
                        continue;
                    }
                }
                else{
                    System.out.println("Ha ocurrido un error al procesar su operación, asegurese de que las matrices" +
                            " existan e intente de nuevo");
                    continue;
                }
            }
            else if(Existen(op)) {
                for (String s : op) {

                    System.out.println(Matriz.getMatriz(s).getName() + ":");
                    int row = Matriz.getMatriz(s).getValor().length;
                    int column = Matriz.getMatriz(s).getValor()[0].length;
                    for (int i = 0; i < row; i++)

                    {

                        System.out.print("[");
                        for (int j = 0; j < column; j++)

                        {
                            if (j > 0) {
                                System.out.print(",");
                            }
                            System.out.print(Matriz.getMatriz(s).getValor()[i][j]);

                        }
                        System.out.print("]");

                        System.out.println(" ");
                    }
                }
                continue;
            }
        }
    }
    public static boolean Existen(String[] operacion){
        for(String s : operacion){
            if(!s.equals("*")&!s.equals("+")&!s.equals("**")&!s.equals("-")
            &!s.equals("(")&!s.equals(")")& !Matriz.existe(s)){
                return false;
            }
        }
        return true;
    }
    public static String[] normalizar (String[] op){
        ArrayList<String> nuevo= new ArrayList<>();
        ArrayList<String> nuevo2= new ArrayList<>();
        for(String a:op){
            for (int i=0; i< a.length(); i++){
                Character c= a.charAt(i);
                if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('=') || c.equals('(') || c.equals(')')){
                    a = a.replace(c, ' ');
                }
            }
            if(a.length() >= 1){
                if(a.length()==1){
                    if(!Character.isDigit(a.charAt(0))){
                        nuevo.add(a);
                    }
                }
                else{
                    nuevo.add(a);
                }
            }
        }
        int cont = 0;
        for(String a : nuevo) {
            String[] nuevo3 = nuevo.get(cont).split(" ");
            cont++;
            for (String b : nuevo3) {
                for (int i = 0; i < b.length(); i++) {
                    Character c = b.charAt(i);
                    if (c.equals(' ')) {
                        b = b.replace(" ", "");
                    }
                }
                if (b.length() >= 1) {
                    if (b.length() == 1) {
                        if (!Character.isDigit(b.charAt(0))) {
                            nuevo2.add(b);
                        }
                    } else {
                        nuevo2.add(b);
                    }
                }
            }
        }
        return nuevo2.toArray(new String[nuevo2.size()]);
    }
    public boolean Operandos(String[] c){
        for(String i:c){
            for (int j=0; j< i.length(); j++){
                Character letra= i.charAt(j);
                if (letra.equals('+') || letra.equals('-') || letra.equals('*') || letra.equals('=')){
                    return true;
                }
            }
        }
        return false;
    }
    public static String sinEspacios(String c){

        StringBuffer nuevo= new StringBuffer();
        for (int i=0; i< c.length(); i++){
            Character caracter= c.charAt(i);
            if (caracter.equals(' ')){
                nuevo= nuevo.append("");
            }
            else{
                nuevo= nuevo.append(caracter);
            }
        }
        return nuevo.toString();
    }
}