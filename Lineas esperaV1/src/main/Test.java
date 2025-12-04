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
            //Creacion del menu
        System.out.println("Menu");
        System.out.println("1. Modelo M/M/1");
        System.out.println("2. Modelo M/M/C");
        System.out.println("3. Modelo M/M/1/K");
        System.out.println("4. Salir");
        System.out.println("Opcion: ");
        option = reader.nextByte();
        
        switch (option) {
            case 1 -> {
                //Solicitar variables del modelo M/M/1
                System.out.println("Ingrese el valor de miu (U): ");
                double U = reader.nextInt();
                System.out.println("Ingrese el valor de lamda: ");
                double lamda = reader.nextInt();
                
                //Implemetanción de fórmulas para cada apartado
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
                //Solicitar variables del modelo M/M/C
                System.out.println("Ingrese el valor de miu (U): ");
                double U=reader.nextDouble();
                System.out.println("Ingrese el valor de lamda: ");
                double lamda=reader.nextDouble();
                System.out.println("Ingrese la cantidad de servidores: ");
                double c=reader.nextDouble();
                
                //Resultados con sus respectivas fórmulas
                System.out.println("Resultados");
                double a=lamda/U;
                System.out.println("La carga total de sistema es del " + a*10 + " %");
                double p=a/c;
                System.out.println("La utilizacion por servidor es del "+ p*100 + " %");
                double p0 = calcularP0(a, c, p);
                System.out.println("La probabilidad de que no haya nadie en el sistema es de " + (float)(p0 * 1000) + " %");
                double pEspera = (Math.pow(a, c)/(Factorial(c)*(1-p)))*p0; //Usé metodos prudentes porque no quería que se viera todo junto, aprendí de mis errores del codigo anterior :C
                System.out.println("La probabilidad de que un cliente tenga que esperar es de " + (float)pEspera * 100 + " %");
                double Lq = (pEspera*p)/(1-p);
                System.out.println("La longitud promedio de la cola es de "+ (float)Lq +" personas");
                double Wq = Lq/lamda;
                System.out.println("El tiempo promedio de espera en la cola es de "+ (float)(Wq * 60) + " minutos");
                double w = Wq + (1/U);
                System.out.println("El tiempo total en el sistema es de "+ (float)(w*60) + " minutos");
                double L = lamda*w;
                System.out.println("El número promedio en el sistema es de "+ (float)L);
            }
            
            case 3 -> {
                //Solicitar variables del modelo M/M/1/K
                System.out.println("Ingrese el valor de miu (U): ");
                double U=reader.nextDouble();
                System.out.println("Ingrese el valor de lamda: ");
                double lamda=reader.nextDouble();
                System.out.println("Ingrese el valor de la premisa (k): ");
                double k=reader.nextDouble();
                
                //Mostrar resultados con sus respectivas fórmulas
                System.out.println("Resultados");
                double p=lamda/U;
                System.out.println("La utilizacion por servidor es del "+ p*100 + " %");
                double p0 = (1-p)/(1-Math.pow(p, k+1));
                System.out.println("La probabilidad de que no haya nadie en el sistema es del "+ (float)p0*100+" %");//Me acabo de acordad, si se pregunta por los casteos fue para recortar decimales de forma rápida
                double pK = Math.pow(p, k)*p0;
                System.out.println("La probabilidad de rechazo es de "+(float)pK*100+" %");
                double labdaE=lamda*(1-Math.pow(p, k));
                System.out.println("La probabilidad efectiva de arribo es de "+(float)labdaE);
                double L=(p-(1-(k+1)*Math.pow(p, k)+k*(Math.pow(p, k+1))))/(1-p)*(1-Math.pow(p, k+1));//Me confundieron un poco los parentesis
                System.out.println("La longitud de la cola es de "+(float)L);
                double w=L/labdaE;
                System.out.println("El tiempo total del promedio del sistema es de "+(float)w*60+" minutos");
            }
         }
        
        } while (option !=4); //Para poder salir del codigo
    }
    
    //Metodo para factorial
    public static double Factorial(double num) {
        if (num == 0.0 || num == 1.0) {
            return 1.0;
        } else {
            return num * Factorial(num - 1);
        }
    }
    
    //Metodo para la fórmula de p0
    public static double calcularP0(double a, double c, double p) {
        double sum = 0.0;
        for (int k = 0; k < c; k++) {
            sum += Math.pow(a, k) / Factorial(k);
        }
        sum += (Math.pow(a, c) / Factorial(c)) * (1 / (1 - p));
        return 1.0 / sum;
    }
    
}
