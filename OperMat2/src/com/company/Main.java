package com.company;

import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Map<String,String> matrices = new HashMap<String,String>();
        Scanner scan = new Scanner(System.in);
        boolean ciclo = true;
        System.out.println("OperMat v.2.0. Angelo Ramírez 2017080055");

        while (ciclo) {

            System.out.print(">>> ");
            String comando = scan.nextLine();
            comando = comando.toLowerCase();

            switch (comando) {
                case "fin":
                    System.out.println(comando);
                    ciclo = false;
                    break;

                case "ayuda":
                    System.out.println(comando);
                    ciclo = false;
                    break;

                case "acercade":
                    System.out.println(comando);
                    ciclo = false;
                    break;

                case "ace":
                    System.out.println(comando);
                    ciclo = false;
                    break;

                default:
                    System.out.println("Comando invalido," + " '" + comando
                            + "' " + "por favor intente de"
                            + " nuevo o utilice 'ayuda' para ayuda");
            }
        }
    }
}