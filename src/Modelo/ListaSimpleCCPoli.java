/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alejandro
 */
public class ListaSimpleCCPoli {

    private NodoSimplePoli primero;
    private NodoSimplePoli ultimo;
    private int tam;
//Crea una lista simplemente ligada circular con nodo cabeza para almacenar los polinomios usados

    public ListaSimpleCCPoli() {
        primero = new NodoSimplePoli(null);
        ultimo = primero;
        primero.setLiga(primero);
        tam = 0;
    }

    public NodoSimplePoli getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoSimplePoli ultimo) {
        this.ultimo = ultimo;
    }

    public NodoSimplePoli getPrimero() {
        return primero;
    }

    public NodoSimplePoli nodoCabeza() {
        return getPrimero();
    }

    public NodoSimplePoli primerNodo() {
        return (getPrimero().getLiga());
    }

    public boolean finLista(NodoSimplePoli x) {
        return (x == getPrimero());
    }

    public boolean esVacia() {
        return (getPrimero().getLiga() == getPrimero());
    }
//Inserta al final de la lista el polinomio ingresado por el usuario a la lista de polinomios ingresados por el usuario
    public void insertarPol(Polinomio poli) {
        NodoSimplePoli x = new NodoSimplePoli(poli);
        x.setLiga(getUltimo().getLiga());
        getUltimo().setLiga(x);
        setUltimo(x);
        tam = tam + 1;
    }
//Borra el n-ésimo polinomio de la lista de polinomios    

    public void borrar(int pos) {
        NodoSimplePoli aux, auxPrev;
        auxPrev = this.nodoCabeza();
        for (int i = 0; i < pos - 1; i++) {//Obtiene el nodo previo al que se encuentra el polinomio a borrar
            auxPrev = auxPrev.getLiga();
        }
        //Cambia las ligas para borrar el respectivo polinomio y cambia el tamaño de la lista
        aux = auxPrev.getLiga();
        auxPrev.setLiga(aux.getLiga());
        tam = tam - 1;
    }

    public int getTam() {
        return tam;
    }
//Obtiene el n-ésimo polinomio de la lista de polinomios
    public Polinomio getPoli(int pos) {
        Polinomio poli;
        NodoSimplePoli x = this.nodoCabeza();
        for (int i = 0; i < pos; i++) {//Recorre la lista hasta encontrar el polinomio que se encuentra en la posición pedida
            x = x.getLiga();
        }
        poli = x.getPoli();
        return (poli);
    }
}