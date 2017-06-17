package com.company;

import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Map<String, Matriz> matrices = new HashMap<String, Matriz>();
        Scanner scan = new Scanner(System.in);
        boolean ciclo = true;
        System.out.println("OperMat v.2.0. Angelo Ramírez 2017080055");

        while (ciclo) {

            System.out.print(">>> ");
            String c = scan.nextLine();
            c = c.toLowerCase();
            c = c.trim();
            List<String> comando = new ArrayList<String>(Arrays.asList(c.split(" ")));

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

                            int row = scan.nextInt();

                            int column = scan.nextInt();

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

                    default:
                        System.out.println("Comando invalido," + " '" + c
                                + "' " + "por favor intente de"
                                + " nuevo o utilice 'ayuda' para ayuda");
                        break;
                }
            }
        }
    }
}