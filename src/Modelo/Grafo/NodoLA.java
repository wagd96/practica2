/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Grafo;

/**
 *
 * @author Alejandro
 */
public class NodoLA {

    private int vertice;
    private Object liga;//Se usara un objeto para fines practicos, ya que en ocasiones sera entero y en otras un apuntador a NodoLA

    public NodoLA(int vertice, Object liga) {

        if (liga instanceof Integer) {//Verifica si el dato Liga es un entero
            this.liga = (int) liga;
        } else {//Si no es entero, hace referencia a un NodoLA
            this.liga = (NodoLA) liga;
        }
        
        this.vertice=vertice;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public Object getLiga() {
        return liga;
    }
    
    public void setLiga(Object liga) {
        
        if (liga instanceof Integer) {
            this.liga = (int) liga;
        } else {
            this.liga = (NodoLA) liga;
        }
        
    }


}
