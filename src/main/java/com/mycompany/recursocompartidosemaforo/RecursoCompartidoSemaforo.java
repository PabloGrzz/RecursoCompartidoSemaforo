/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursocompartidosemaforo;

/**
 *
 * @author pablo
 */
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
class RecursoCompartido {

    private int recurso;

    public RecursoCompartido(int recursoInicial) {
        this.recurso = recursoInicial;
    }

    public synchronized void restar() {

        if (recurso > 0) {
            recurso = recurso - RecursoCompartidoSemaforo.cantidadARestarDelRecurso;
            System.out.println("Recurso restante: " + recurso);
        } else {
            System.out.println("No hay recursos disponibles para " + Thread.currentThread().getName());
        }
    }

    public int getRecurso() {
        return recurso;
    }
}

class HiloDeTrabajo extends Thread {

    private RecursoCompartido recurso;
    private Semaphore semaforo;
    

    public HiloDeTrabajo(RecursoCompartido recurso, Semaphore semaforo) {
        this.recurso = recurso;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {

        
            try {

                System.out.println(Thread.currentThread().getName() + " intentando acceder al semáforo...");
                
                
                semaforo.acquire();

                System.out.println(Thread.currentThread().getName() + " ha adquirido un permiso.");

                Thread.sleep(2000); 
                recurso.restar();
                

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                
                semaforo.release();
                System.out.println(Thread.currentThread().getName() + " ha liberado un permiso.");
                
            }
    }
}

public class RecursoCompartidoSemaforo {
    
    static Scanner sc = new Scanner(System.in);
    static int cantidadDeHilos,hilosSimultaneos,recursoInicial,cantidadARestarDelRecurso;
    

    public static void main(String[] args) {
        
        System.out.println("Introduce la cantidad de hilos que quieres : ");
        cantidadDeHilos = sc.nextInt();
        
        System.out.println("Introduce la cantidad de hilos simultaneos que accederan al recurso compartido : ");
        hilosSimultaneos = sc.nextInt();
        
        System.out.println("Introduce la cantidad inicial del recurso compartido : ");
        recursoInicial = sc.nextInt();
        
        System.out.println("Introduce cuanto quieres que cada hilo reste del recurso compartido : ");
        cantidadARestarDelRecurso = sc.nextInt();
        
        RecursoCompartido recursoCompartido = new RecursoCompartido(recursoInicial);
        Semaphore semaforo = new Semaphore(hilosSimultaneos); 

        HiloDeTrabajo[] hilos = new HiloDeTrabajo[cantidadDeHilos];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloDeTrabajo(recursoCompartido, semaforo);
            hilos[i].start();
        }
        
        for (HiloDeTrabajo hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin del programa."); 
    }
}
