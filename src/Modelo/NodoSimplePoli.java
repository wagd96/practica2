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
public class NodoSimplePoli {
    private NodoSimplePoli liga;
    private Polinomio poli;
    
//Crea un nodo simple que almacena un polinomio representado como lista simplemente ligada circular       
    public NodoSimplePoli(Polinomio poli){
        this.poli=poli;
        liga=null;
    }   

   
    public NodoSimplePoli getLiga() {
        return liga;
    }

    public void setLiga(NodoSimplePoli liga) {
        this.liga = liga;
    }
    public Polinomio getPoli() {
        return poli;
    }

    /**
     * @param lista the lista to set
     */
    public void setPoli(Polinomio poli) {
        this.poli = poli;
    }
}
