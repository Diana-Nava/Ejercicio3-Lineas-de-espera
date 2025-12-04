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
        Scanner reader   = new Scanner(System.in);
        byte option = 0;
        do {
        System.out.println("Menu");
        System.out.println("1. Modelo M/M/1");
        System.out.println("2. Modelo M/M/C");
        System.out.println("3. Modelo M/M/1K");
        System.out.println("4. Salir");
        System.out.println("Opcion: ");
        option = reader.nextByte();
        
        switch (option) {
            case 1 -> {
                System.out.println("Ingrese el valor de miu (U): ");
                double U = reader.nextInt();
                System.out.println("Ingrese el valor de lamda: ");
                double lamda = reader.nextInt();
                
                System.out.println("Resultados: ");
                double p   = lamda / U;
                double pf = p*100;
                System.out.println("La utilizacion del sistema es del " + pf + "%");
                double Lq   = Math.pow(lamda,2)/(U*(U-lamda));
                System.out.println("El promedio de cliente en la cola es de: " + Lq + " clientes");
                double Wq = Lq/lamda;
                System.out.println("El tiempo promedio de espera en la cola es de "+Wq * 60+" minutos");
                double w = Wq + (1/U);
                System.out.println("El tiempo total del sistema es de "+ w * 60 +" minutos");
         }
            case 2 -> {
                
            }
         }
        
        } while (option !=4);
    }
}
