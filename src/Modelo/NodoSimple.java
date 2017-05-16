/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigInteger;

/**
 *
 * @author Carolina
 */
public class NodoSimple {
    
    private BigInteger coef;
    private int exp;
    private NodoSimple liga;
    
//Crea un nodo simple que almacena coeficiente y exponente    
    public NodoSimple(BigInteger coef,int exp) {
        this.coef=coef;
        this.exp=exp;
        liga = null; 
    }
       
    public BigInteger getCoef() {
        return coef;
    }

    public void setCoef(BigInteger coef) {
        this.coef = coef;
    }

    public NodoSimple getLiga() {
        return liga;
    }

    public void setLiga(NodoSimple liga) {
        this.liga = liga;
    }

    
    public int getExp() {
        return exp;
    }

    
    public void setExp(int exp) {
        this.exp = exp;
    }  
}
