package com.company;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.Random;
import java.io.*;
//Creado por Angelo Ramírez Ortega//2017080055//20/06/2017//ITCR
/////////////main\\\\\\\\\\\\\\\\\
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean ciclo = true;
        System.out.println("OperMat v.2.0. Angelo Ramírez 2017080055");

        while (ciclo) { // Ciclo de entradas de usuario, se rompe mediante "cmd finalizar"

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
                        System.out.println("Gracias por utilizar OperMat 2017!");
                        ciclo = false;
                        continue;

                    case "finalizar":
                        System.out.println("Gracias por utilizar OperMat 2017!");
                        ciclo = false;
                        continue;

                    case "ayuda":
                        try {
                            if (Desktop.isDesktopSupported()) {
                                File file = new File("manual_de_usuario_opermat.pdf");
                                String path = file.getAbsolutePath();
                                File myFile = new File(path);
                                Desktop.getDesktop().open(myFile);
                            }
                        } catch (Exception ex) {
                            {System.out.println("No se pudó abrir el manual de usuario, por favor verifique" +
                                    "que este en el folder designado");}
                        }

                        continue;

                    case "ayu":
                        try {
                            if (Desktop.isDesktopSupported()) {
                                File file = new File("manual_de_usuario_opermat.pdf");
                                String path = file.getAbsolutePath();
                                File myFile = new File(path);
                                Desktop.getDesktop().open(myFile);
                            }
                        } catch (Exception ex) {
                            {System.out.println("No se pudó abrir el manual de usuario, por favor verifique" +
                                    "que este en el folder designado");}
                        }
                        continue;
                    case "acercade":
                        System.out.println("Acerca De:\nOperMat v. 2.0.\n06/20/2017\n" +
                                "Angelo Ramírez Ortega\n2017080055\n");
                        continue;

                    case "ace":
                        System.out.println("Acerca De:\nOperMat v. 2.0.\n06/20/2017\n" +
                                "Angelo Ramírez Ortega\n2017080055\n");
                        continue;

                    case "imprimir":
                        if(Auxiliar.matrices.size() == 0)
                        {
                            System.out.print("Todavía no existen matrices en memoria");
                        }
                        for(Matriz m : Auxiliar.matrices) {
                            if(!m.getName().equals("aux")) {
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
                        }
                        continue;
                    default:
                        if(Existen(op)){
                            for(String s : op) {
                                String[] p = {s};
                                if (Existen(p)) {
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
                            }
                            continue;
                        }
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
                            double matriz[][] = new double[row][column];

                            for (i = 0; i < row; i++)

                            {

                                for (j = 0; j < column; j++)

                                {
                                    System.out.print("Fila " + Integer.toString(i + 1) + " Columna "
                                            + Integer.toString(j + 1) + ": ");
                                    matriz[i][j] = scan.nextDouble();

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
                        continue;

                    case "leer":
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
                            double matriz[][] = new double[row][column];

                            for (i = 0; i < row; i++)

                            {

                                for (j = 0; j < column; j++)

                                {
                                    System.out.print("Fila " + Integer.toString(i + 1) + " Columna "
                                            + Integer.toString(j + 1) + ": ");
                                    matriz[i][j] = scan.nextDouble();

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
                        continue;

                    default:
                        if(Existen(op)){
                            for(String s : op) {
                                String[] p = {s};
                                if (Existen(p)) {
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
                            }
                            continue;
                        }
                        break;
                }
            }

            if(Arrays.asList(op).contains("mae")| Arrays.asList(op).contains("matrizaleatoriaenteros")) {
                arrcom = c.split(" ");
                if (arrcom.length == 2) {
                    try {
                        System.out.print("Coloque la cantidad de filas y columnas: ");
                        String x = scan.nextLine();
                        List<String> sinx = new ArrayList<String>(Arrays.asList(x.split("x")));
                        if (x.indexOf('x') > -1) {
                            sinx = new ArrayList<String>(Arrays.asList(x.split("x")));
                        } else {
                            sinx = new ArrayList<String>(Arrays.asList(x.split(" ")));
                        }
                        int row = Integer.parseInt(sinx.get(0));
                        int column = Integer.parseInt(sinx.get(1));
                        mae(row, column, arrcom[1]);
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error al crear su matriz aleatoria");
                    }
                }
                else{
                    System.out.println("Mae recibe un único argumento, el nombre asignado de matriz");
                }
            }
            else if(Arrays.asList(op).contains("maf")| Arrays.asList(op).contains("matrizaleatoriaflotantes")) {
                arrcom = c.split(" ");
                if (arrcom.length == 2) {
                    try {
                        System.out.print("Coloque la cantidad de filas y columnas: ");
                        String x = scan.nextLine();
                        List<String> sinx = new ArrayList<String>(Arrays.asList(x.split("x")));
                        if (x.indexOf('x') > -1) {
                            sinx = new ArrayList<String>(Arrays.asList(x.split("x")));
                        } else {
                            sinx = new ArrayList<String>(Arrays.asList(x.split(" ")));
                        }
                        int row = Integer.parseInt(sinx.get(0));
                        int column = Integer.parseInt(sinx.get(1));
                        maf(row, column, arrcom[1]);
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error al crear su matriz aleatoria");
                    }
                }
                else{
                    System.out.println("Maf recibe un único argumento, el nombre asignado de matriz");
                }
            }
            else if(c.indexOf('=')>-1){
                arrcom = c.split(" ");
                String nombre = arrcom[0];
                op = normalizar(arrcom);
                op = Arrays.copyOfRange(op, 1, op.length);
                c = "";
                for(int i=0; i < arrcom.length; i++)
                {
                    if(i>=2) {
                        c = c + arrcom[i];
                    }
                }
                if(Existen(op)){
                    try {
                        for(String s : op) {
                            String[] p = {s};
                            if (Existen(p)) {
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
                        }
                        String orden = sinEspacios(c);
                        Auxiliar.operar(orden).operacion();
                        Matriz resultado = Auxiliar.matrices.get(Auxiliar.matrices.size() - 1);
                        resultado.setName(nombre);
                        int i,j;
                        int row = resultado.getValor().length;
                        int column = resultado.getValor()[0].length;
                        System.out.print(nombre + ":");
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
                    }
                }
                else{
                    System.out.println("Ha ocurrido un error al procesar su operación, asegurese de que las matrices" +
                            " existan e intente de nuevo");
                }
            }
            else if(c.indexOf('+')>-1 | c.indexOf('-')>-1 | c.indexOf('*')>-1 | c.contains("**")){

                if(Existen(op)){
                    try {
                        for(String s : op) {
                            String[] p = {s};
                            if (Existen(p)) {
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
                        }
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
                    }
                }
                else{
                    System.out.println("Ha ocurrido un error al procesar su operación, asegurese de que las matrices" +
                            " existan e intente de nuevo");
                }
            }
            else if(Existen(op)) {
                for(String s : op) {
                    String[] p = {s};
                    if (Existen(p)) {
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
                }
            }
            else if(c.contains("stat")) { //Operacion definida por el programador
                arrcom = c.split(" ");

                if(!arrcom[0].equals("stat"))
                {
                    System.out.println("Se debe colocar primero 'stat' y luego el nombre de la matriz por analizar");
                    continue;
                }
                if (c.contains("fila") | c.contains("columna")) {
                    if (c.contains("fila") & c.contains("columna")) {
                        System.out.println("Solo se puede seleccionar entre filas o columnas, no ambas a la vez");
                    } else if(c.contains("fila")) {
                        arrcom = c.split(" ");
                        String nombre = arrcom[1];
                        String[] a = {nombre};
                        if(arrcom.length <= 3 & Existen(a)) {
                            System.out.println("Estadísticas de "+ arrcom[1] + ":");
                            estadistica(nombre, true, false);
                        }
                        else
                        {
                            System.out.println("Solo se puede operar una matriz a la vez");
                        }
                    }
                        else{
                        arrcom = c.split(" ");
                        String nombre = arrcom[1];
                        String[] a = {nombre};
                        if(arrcom.length <= 3 & Existen(a)) {
                            System.out.println("Estadísticas de "+ arrcom[1] + ":");
                            estadistica(nombre, false, true);
                        }
                        else
                        {
                            System.out.println("Solo se puede operar una matriz a la vez");
                        }
                    }
                } else {
                    arrcom = c.split(" ");
                    if(arrcom.length == 2) {
                        String nombre = arrcom[1];
                        String[] a = {nombre};
                        if(Existen(a)) {
                            estadistica(nombre, false, false);
                        }
                        else{
                            System.out.println("La matriz que estás operando no existe");
                        }
                    }
                    else{
                        System.out.println("Por favor inserte la matriz por operar");
                    }
                }
            }
            else
            {
                System.out.println("Comando invalido '" + c + "' por favor intente de nuevo con otro comando " +
                        "o escriba 'ayuda' para ayuda");
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
    public static void maf(int c, int f, String nombre)
    {
        double[][] maf = new double[c][f];
        Random rand;
        for(int i=0; i<c ; i++){
            for(int j=0; j<f ; j++) {
                rand = new Random();
                double start = 0;
                double end = 50;
                double random = new Random().nextDouble();
                double result = start + (random * (end - start));
                result = round(result, 3);
                maf[i][j] = result;
            }
        }
        Matriz maffin = new Matriz(nombre, maf);
        Auxiliar.matrices.add(maffin);
        System.out.println(maffin.getName() + ":");

        for (int i = 0; i < c; i++)

        {

            System.out.print("[");
            for (int j = 0; j < f; j++)

            {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(maf[i][j]);

            }
            System.out.print("]");

            System.out.println(" ");
        }
    }

    public static void mae(int c, int f, String nombre)
    {
        double[][] mae = new double[c][f];
        Random rand;
        for(int i=0; i<c ; i++){
            for(int j=0; j<f ; j++) {
                rand = new Random();
                double n = rand.nextInt(50) + 1;
                mae[i][j] = n;
            }
        }
        Matriz maefin = new Matriz(nombre, mae);
        Auxiliar.matrices.add(maefin);
        System.out.println(maefin.getName() + ":");

        for (int i = 0; i < c; i++)

        {

            System.out.print("[");
            for (int j = 0; j < f; j++)

            {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(mae[i][j]);

            }
            System.out.print("]");

            System.out.println(" ");
        }
    }
    // Redondea un número a "places" posiciones decimales
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    // Extrae operandos del string de entrada para determinar si existen posteriormente en memoria
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
    // Retorna el string de entrada sin espacios
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
    // Operación definida por el programador
    public static void estadistica(String n, boolean f, boolean c)
    {
        double[][] m = Matriz.getMatriz(n).getValor();

        if(c) {
            m = Matriz.transpuesta(Matriz.getMatriz(n).getValor());
        }

        if(f | c) {
            List<Double> prom_x = new ArrayList<>();
            List<Double> v_ma = new ArrayList<>();
            List<Double> v_min = new ArrayList<>();
            List<Double> media = new ArrayList<>();
            List<Double> modas = new ArrayList<>();
            for (int i=0; i < m.length; i++) {
                double p_aux = promedio(m[i]);
                prom_x.add(p_aux);
                v_ma.add(v_max(m[i]));
                v_min.add(v_min(m[i]));
                media.add(medial(m[i]));
                modas.add(modaLista(m[i]));
            }
            System.out.println("Promedios:");
            System.out.println(prom_x);
            System.out.println("Valores Máximos:");
            System.out.println(v_ma);
            System.out.println("Valores Mínimos:");
            System.out.println(v_min);
            System.out.println("Medias:");
            System.out.println(media);
            System.out.println("Modas:");
            System.out.println(modas);
        }
        else
        {
            int index = 0;
            double[] mp = new double[m.length * m[0].length];
            for(int i=0; i<m.length; i++)
            {
                for(int j=0; j<m[0].length; j++)
                {
                    mp[index] = m[i][j];
                    index ++;
                }
            }
            double prom_x = 0;
            double v_ma = 0;
            double v_min = 0;
            double media = 0;
            double modas = 0;

            prom_x = promedio(mp);
            v_ma = v_max(mp);
            v_min = v_min(mp);
            media = medial(mp);
            modas = modaLista(mp);

            System.out.println("Promedio:");
            System.out.println(prom_x);
            System.out.println("Valor Máximo:");
            System.out.println(v_ma);
            System.out.println("Valor Mínimo:");
            System.out.println(v_min);
            System.out.println("Media:");
            System.out.println(media);
            System.out.println("Moda:");
            System.out.println(modas);
        }
    }
    // Saca el promedio de una serie de valores
    public static double promedio(double[] a)
    {
        double aux = 0;
        int contador = 0;

        for(int i=0; i<a.length; i++)
        {
            aux = aux + a[i];
            contador += 1;
        }

        aux = aux/contador;

        return aux;
    }
    // Saca el valor máximo de una serie de valores
    public static double v_max(double[] a)
    {
        double aux = 0;
        int contador = 0;

        for(int i=0; i<a.length; i++)
        {
            if(contador==0 | aux < a[i]) {
                contador += 1;
                aux = a[i];
            }
        }

        return aux;
    }
    // Saca el valor mínimo de una serie de valores
    public static double v_min(double[] a)
    {
        double aux = 0;
        int contador = 0;

        for(int i=0; i<a.length; i++)
        {
            if(contador==0 | aux > a[i]) {
                contador += 1;
                aux = a[i];
            }
        }

        return aux;
    }
    // Saca la media de una serie de valores
    public static double medial(double[] a)
    {

        if(a.length % 2 != 0){
        int x = a.length / 2;
        return a[x];
        }

    else{
        int x = a.length / 2;
        int y = a.length / 2 - 1;
        return (double)(a[x] + a[y]) / 2;
        }
    }
    // Saca la moda de una serie de valores
    public static double modaLista(double[] a)
    {
        int contadoractual = 0;
        int contadoranterior = 0;
        double varaux;
        double var = 0;

        for(int y=0; y<a.length; y++)
        {
            varaux = a[y];
            contadoractual = 0;
            for(int i=0; i<a.length; i++)
            {
                if(a[y] == a[i])
                {
                    contadoractual++;
                }
            }
            if (contadoractual > contadoranterior)
            {
                var = varaux;
            }

        }
        return var;
    }
}