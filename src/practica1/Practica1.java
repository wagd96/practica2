
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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Carolina
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        GrafoLA prueba = null;
        String s1;
        String s2;

        // Cargamos el buffer con el contenido del archivo
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Alejandro\\aaa\\grafo.txt"));
        while (br.ready()) {
            s1 = br.readLine();
            //System.out.println("texto de cada linea: " + s1);
            StringTokenizer st = new StringTokenizer(s1);
            if (s1.charAt(0) == 'p') {
                while (st.hasMoreTokens()) {
                    s2 = st.nextToken();
                    if (s2.equals("edge")) {
                        int n = Integer.parseInt(st.nextToken());
                        prueba = new GrafoLA(n);
                        break;
                    }
                }
            }
            if (s1.charAt(0) == 'e') {
                while (st.hasMoreTokens()) {
                    st.nextToken();
                    s2 = st.nextToken();

                    int v1 = Integer.parseInt(s2);
                    int v2 = Integer.parseInt(st.nextToken());
                    prueba.agregarArista(v1, v2);
                }
            }
        }

        boolean c, ciclo, arbol;
        double d;
        String re;

        c = prueba.esConexo();
        d = prueba.densidad();
        ciclo = prueba.esCiclo();
        arbol = prueba.esArbol();
        System.out.println("ciclo= " + ciclo + " arbol= " + arbol + " d= " + d + ". c= " + c + ". n= " + prueba.getTotalVertices() + ". m= " + prueba.getTotalAristas() + " Subgrafos:" + prueba.subgrafos());
        re = prueba.polinomioCromatico();
        System.out.println("re:" + re);

        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) + " milliseconds");

    }
}
