
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import Controlador.Control;
import Modelo.Grafo.GrafoLA;
import Modelo.Polinomio;
import Vista.Visual;

/**
 *
 * @author Carolina
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        
//        ReallyHeavyTask(); // llamamos a la tarea        
        GrafoLA prueba = new GrafoLA(10);
        prueba.agregarArista(1, 2);
        prueba.agregarArista(2, 3);
        prueba.agregarArista(3, 4);
        prueba.agregarArista(4, 5);
        prueba.agregarArista(5, 6);
        prueba.agregarArista(6, 7);
        prueba.agregarArista(7, 8);
        prueba.agregarArista(8, 9);
        prueba.agregarArista(9, 10);
        prueba.agregarArista(10, 1);

        boolean c, ciclo, arbol;
        double d;
        String re;

        c = prueba.esConexo();
        d = prueba.densidad();
        ciclo = prueba.esCiclo();
        arbol = prueba.esArbol();
        System.out.println("ciclo= " + ciclo + " arbol= " + arbol + " d= " + d + ". c= " + c + ". n= " + prueba.getTotalVertices() + ". m= " + prueba.getTotalAristas());
        re = prueba.polinomioCromatico();
        System.out.println("re:" + re);
        
        
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) + " milliseconds");
        
    }
}
