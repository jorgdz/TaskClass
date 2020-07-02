package ec.edu.espol.common;

import ec.edu.espol.util.Array;
import ec.edu.espol.util.Matriz;
import ec.edu.espol.util.Vector;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Francisco Mayancela
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Random rnd = new Random();
        
        System.out.println("Seleccione una opción:");
        char option;
        do{
            System.out.println("\n***********************");
            System.out.println("1. Vector");
            System.out.println("2. Array");
            System.out.println("3. Matriz");
            System.out.println("Pulse q para salir....");
            System.out.println("***********************\n");
            option = sc.next().charAt(0);
            
            switch(option){
                case '1':
                    /*EJERCICIO 1*/ 
                    System.out.print("Ingreso coordenada X del vector 1: ");
                    double x1 = sc.nextDouble();
                    System.out.print("Ingreso coordenada Y del vector 1: ");
                    double y1 = sc.nextDouble();

                    System.out.print("Ingreso coordenada X del vector 2: ");
                    double x2 = sc.nextDouble();
                    System.out.print("Ingreso coordenada Y del vector 2: ");
                    double y2 = sc.nextDouble();

                    Vector v1 = new Vector(x1, y1);
                    Vector v2 = new Vector(x2, y2);

                    if(validate(v1, v2))
                    {
                        System.out.println("Suma de vectores: "+ v1.sumar(v1, v2));
                        System.out.println("Resta de vectores: "+ v1.restar(v1, v2));
                        System.out.println("Módulo del primer vector: " + v1.modulo());
                        System.out.println("Módulo del segundo vector: " + v2.modulo());
                        System.out.println("**************Vector Unitario************");
                        System.out.println("Primer vector: "+ v1.vectorUnitario());
                        System.out.println("Segundo vector: "+ v2.vectorUnitario());
                        if(v1.equals(v2))
                            System.out.println("Los vectores son iguales");
                        else
                            System.out.println("Los vectores son diferentes");
                    }
                    else
                    {
                        System.out.println("Las coordenadas de los vectores deben tener valores positivos.");
                    }
                break;
                case '2':
                    /*EJERCICIO 2*/
                    Array a = new Array(4);
                    a.getArray()[0] = 8;
                    a.getArray()[1] = 909;
                    a.getArray()[2] = 5;
                    a.getArray()[3] = 6;

                    System.out.println("Array 1: "+ a);

                    Array a2 = new Array(2);
                    a2.getArray()[0] = 55;
                    a2.getArray()[1] = 102;
                    System.out.println("Array 2: "+ a2);

                    // Concat
                    a.concat(a2);

                    System.out.println(a);
                    System.out.println("Tamaño del array actual: " + a.getSize());

                    // Set
                    a.set(5, 11);

                    System.out.println(a);

                    System.out.println("*****************************");

                    // Get
                    int i = 2;
                    int find = a.get(i);
                    if(find != -1)
                        System.out.println("Elemento encontrado: "+find + " en el índice "+i);
                    else
                        System.out.println("No encontrado");

                    //Slicing   
                    System.out.println("Slicing: " + a.slicing(2,4));            

                    //Suma
                    System.out.println("Suma: " + a.sum());

                    //Max
                    System.out.println("Máximo: " + a.max());

                    //Min
                    System.out.println("Minimo: " + a.min());

                    // Equals
                    Array a3 = new Array(6);
                    a3.getArray()[0] = 8;
                    a3.getArray()[1] = 909;
                    a3.getArray()[2] = 5;
                    a3.getArray()[3] = 6;
                    a3.getArray()[4] = 55;
                    a3.getArray()[5] = 11;

                    System.out.println("\nArray 1: "+a);
                    System.out.println("Array 3: " + a3);
                    if(a.equals(a3)){    
                        System.out.println("Son iguales");
                    }else {
                        System.out.println("Son diferentes");
                    }
                break;
                case '3':
                    /*EJERCICIO 3*/
                    int row = 5, colum =6;
                    Matriz m = new Matriz(row, colum);

                    System.out.println("Filas: "+m.getFilas());
                    System.out.println("Columnas: "+m.getColumnas());

                    for (int i1 = 0; i1 < m.getFilas(); i1++) {
                        for (int j = 0; j < m.getColumnas(); j++) {
                            m.getMatriz()[i1][j] = rnd.nextInt(29-0)+0;
                            //m.getMatriz()[i][j] = sc.nextInt();
                        }
                    }

                    // Set
                    m.set(1, 4, 255);

                    System.out.println(m);



                    //Concat
                    System.out.println("\nSeleccione 0 para concatenar verticalmente y 1 horizontalmente:");
                    int opt = sc.nextInt();

                    int filas = 0, col = 0;
                    if(opt == 0){
                        filas = row;
                        System.out.println("Nº de Columnas para generar la nueva matriz a concatenar:");
                        col = sc.nextInt();
                    }
                    if(opt == 1)
                    {
                        col = colum;
                        System.out.println("Nº de Filas para generar la nueva matriz a concatenar:");
                        filas = sc.nextInt();
                    }

                    Matriz matrizAux = new Matriz(filas, col);
                    for (int i2 = 0; i2 < matrizAux.getFilas(); i2++) {
                        for (int j = 0; j < matrizAux.getColumnas(); j++) {
                            matrizAux.getMatriz()[i2][j] = rnd.nextInt(29-0)+0;
                        }
                    }
                    System.out.println("**********************************");
                    System.out.println("Matriz a concatenar: " + matrizAux);
                    System.out.println("Matriz concatenada: " + m.concat(matrizAux, opt));
                    System.out.println("**********************************");



                    // Get
                    int x = 1;
                    int y = 2;
                    int findMat = m.get(x,y);
                    if(findMat != -1){
                        System.out.println("Elemento encontrado: " + findMat + " en la fila: "+ x + " columna " + y);
                    }else{
                        System.out.println("No encontrado !!");
                    }

                    // Slicing
                    System.out.println("Slicing: "+ m.slicing(2, 4, 2, 4));

                    // Sum
                    System.out.println("Suma: " + m.sum());

                    // Max
                    System.out.println("Máximo: " + m.max());

                    // Min
                    System.out.println("Mínimo: " + m.min());

                    // Diagonal
                    Matriz m2 = new Matriz();
                    for (int i3 = 0; i3 < m2.getFilas(); i3++) {
                        for (int j = 0; j < m2.getColumnas(); j++) {
                            m2.getMatriz()[i3][j] = rnd.nextInt(20-0)+0;
                        }
                    }
                    System.out.println("Matriz cuadrada: " + m2);
                    int diagonal = m2.diagonal();
                    if(diagonal == -1){
                        System.out.println("La matriz no es cuadrada.");
                    }else{
                        System.out.println("Suma de la diagonal: " + diagonal);
                    }

                    // Transpuesta
                    System.out.println("Transpuesta de matriz: " + m2.transpuesta());

                    // Equals
                    System.out.println("\n"+m2);
                    System.out.println(m2.transpuesta());
                    if(m2.equals(m2.transpuesta()))
                    {
                        System.out.println("Las matrices son iguales.");
                    }
                    else
                    {
                        System.out.println("Las matrices son diferentes.");
                    }
                break;
                default:
                break;
            }
        }while(option != 'q'); 
    }
    
    public static boolean validate (Vector v1, Vector v2) {
        boolean valid = false;
        if(v1.getX() >= 0 && v1.getY() >= 0 && v2.getX() >= 0  && v2.getY() >= 0)
            valid = true;
        return valid;
    }
}
