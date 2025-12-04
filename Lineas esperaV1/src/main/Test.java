/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author diana
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Modelo M/M/1");
        System.out.println("2. Modelo M/M/C");
        System.out.println("4. Modelo M/M/1K");
        System.out.println("Opcion: ");
        byte option = reader.nextByte();

        switch (option) {
            case 1 -> {
                System.out.println("Ingrese el valor de miu (U): ");
                int U = reader.nextInt();
                System.out.println("Ingrese el valor de lamda: ");
                int lamda = reader.nextInt();

                System.out.println("Resultados: ");
                double p  = lamda / U;
                System.out.println("La utilizacion del sistema es del " + (p * 100) + "%");
                double Lq  = Math.pow(lamda, 2 ) / U *( U -lamda);
                System.out.println("El promedio de cliente en la cola es de: " + Lq + " clientes");

                doule w = Wq + (1/U);
         
     

        } 
    }
    
}
