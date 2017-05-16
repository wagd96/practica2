package Modelo;

import java.math.BigInteger;



public class ListaSimpleCC {

    private NodoSimple primero;
    private NodoSimple ultimo;
    private int tam;
//Crea una lista simplemente ligada circular con nodo cabeza
    public ListaSimpleCC() {
        primero = new NodoSimple(null, -1);
        ultimo = primero;
        primero.setLiga(primero);
        tam = 0;
    }
       
    public NodoSimple getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoSimple ultimo) {
        this.ultimo = ultimo;
    }

    public NodoSimple getPrimero() {
        return primero;
    }

    public NodoSimple nodoCabeza() {
        return getPrimero();
    }

    public NodoSimple primerNodo() {
        return (getPrimero().getLiga());
    }

    public boolean finLista(NodoSimple x) {
        return (x == getPrimero());
    }

    public boolean esVacia() {
        return (getPrimero().getLiga() == getPrimero());
    }
//inserta un dato, en este caso un monomio a la lista. Siempre inserta al final
    public void insertar(BigInteger coef, int exp) {
        NodoSimple x = new NodoSimple(coef, exp);
        x.setLiga(getUltimo().getLiga());
        getUltimo().setLiga(x);
        setUltimo(x);
        tam++;
    }

    public int getTam() {
        return tam;
    }

}
