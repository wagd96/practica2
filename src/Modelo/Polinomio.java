/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static java.lang.Integer.compare;
import java.math.BigInteger;

public class Polinomio extends ListaSimpleCC {

 public static Polinomio value(String px) {
        Polinomio poli =new Polinomio();
        poli.insertarPolinomio(px);
        
        return poli;
    }
//Suma dos polinomios

    public Polinomio sumar(Polinomio sumando) {
        Polinomio resultado = new Polinomio();
        NodoSimple p, q;
        BigInteger suma;
        int aux;
        p = primerNodo();
        q = sumando.primerNodo();
        while (!finLista(p) || !sumando.finLista(q)) {//Verifica que no sea el final de alguno de los dos polinomios. Al ser representados como listas con nodo cabeza, utilizamos la cabeza para saber cuando es el final de alguno de los dos polinomios y así evitar más ciclos
            aux = compare(p.getExp(), q.getExp());//Compara los coeficientes de cada monomio de los dos polinomios

            if (aux > 0) {//Si el respectivo monomio del polinomio F(x) es mayor que el de Q(x), ingresa dicho monomio a la lista resultante y avanza en F(x)
                resultado.insertar(p.getCoef(), p.getExp());
                p = p.getLiga();
            }
            if (aux < 0) {//Si el respectivo monomio del polinomio Q(x) es mayor que el de F(x), ingresa dicho monomio a la lista resultante y avanza en Q(x)
                resultado.insertar(q.getCoef(), q.getExp());
                q = q.getLiga();
            }
            if (aux == 0) {//si son iguales suma sus coeficientes
                suma = p.getCoef().add(q.getCoef());
                if (!suma.equals(0)) {
                    resultado.insertar(suma, p.getExp());
                }
                p = p.getLiga();
                q = q.getLiga();
            }
        }
        return resultado;
    }
//Multiplica un monomio por un polinomio

    public Polinomio sMult(NodoSimple factor) {
        Polinomio retorno = new Polinomio();
        NodoSimple p;
        p = primerNodo();
        while (!finLista(p)) {//Recorre los monomios del polinomio y hace las respectivas operaciones
            retorno.insertar(p.getCoef().multiply(factor.getCoef()), p.getExp() + factor.getExp());
            p = p.getLiga();
        }
        return retorno;
    }

//Multiplica un polinomio por otro que ingresa como parámetro
    public Polinomio mult(Polinomio factor) {
        Polinomio retorno = new Polinomio();
        NodoSimple p;
        p = primerNodo();

        while (!finLista(p)) {//Fija un polinomio, lo multiplica por cada monomio del otro y suma cada operación al polinomio resultante
            retorno = retorno.sumar(factor.sMult(p));
            p = p.getLiga();
        }
        return retorno;
    }

//Teorema del factor para evaluar si un dato es factor de un polinomio
    public boolean esFactor(BigInteger dato) {
        return (evaluar(dato).equals(0));
    }

//Convierte la lista simplemente ligada circular con nodo cabeza en un String
    public String listaAString() {
        NodoSimple p = primerNodo();
        String polinomio = "";
        //Verifica que la lista no se encuentre vacía
        if (!esVacia()) {
            while (!(finLista(p))) {
                if (p.getExp() == 0) {
                    if (p.getCoef().signum() == 1) {//Le asigna su correspondiente signo al coeficiente en el termino independiente
                        polinomio = polinomio.concat("+".concat(p.getCoef().toString()));
                    } else {
                        polinomio = polinomio.concat((p.getCoef()).toString());
                    }

                } else if (p.getCoef().signum() == -1 || polinomio.isEmpty()) {//Separa el coeficiente y el exponente por medio de la variable x
                    polinomio = polinomio.concat(p.getCoef().toString().concat("x^").concat(Integer.toString(p.getExp())));
                } else {
                    polinomio = polinomio.concat("+".concat(p.getCoef().toString().concat("x^").concat(Integer.toString(p.getExp()))));
                }
                p = p.getLiga();
            }
        }

        return polinomio;
    }

    //Ordenamiento por burbuja mejorada de mayor a menor al polinomio
    public void mayorAMenor() {
        if (this.getTam() > 1) {
            boolean cambio;
            do {
                NodoSimple actual = this.primerNodo();
                NodoSimple anterior = this.nodoCabeza();
                NodoSimple siguiente = this.primerNodo().getLiga();
                NodoSimple aux = null;
                cambio = false;
                while (siguiente != this.nodoCabeza()) {
                    if (compare(actual.getExp(), siguiente.getExp()) < 0) {
                        cambio = true;
                        if (anterior != this.nodoCabeza()) {
                            aux = siguiente.getLiga();
                            anterior.setLiga(siguiente);
                            siguiente.setLiga(actual);
                            actual.setLiga(aux);
                        } else {
                            aux = siguiente.getLiga();
                            this.getPrimero().setLiga(siguiente);
                            siguiente.setLiga(actual);
                            actual.setLiga(aux);
                        }
                        anterior = siguiente;
                        siguiente = actual.getLiga();
                    } else {
                        anterior = actual;
                        actual = siguiente;
                        siguiente = siguiente.getLiga();
                    }
                }
            } while (cambio);
        }
    }

//Verifica que el polinomio contenga más de un monomio, lo ordena de exponente mayor a menor y suma los coeficientes
    public void ordenaPolinomio() {
        if (this.getTam() > 1) {//Verifica que tenga más de un monomio
            this.mayorAMenor();//Ordena de mayor exponente a menor exponente
            NodoSimple actual, previo, siguiente;
            BigInteger suma = null;
            actual = this.primerNodo();
            previo = this.nodoCabeza();
            siguiente = actual.getLiga();

            while (siguiente != this.nodoCabeza()) {//Recorre el polinomio
                if (actual.getExp() == siguiente.getExp()) {//Si encuentra dos monomios con exponente igual, suma sus coeficientes 
                    suma = suma.add(actual.getCoef().add(siguiente.getCoef()));
                    if (!suma.equals(0)) {//Si la suma de ambos coeficientes es diferente de cero, elimina un monomio para que quede sólo un monomio por exponente
                        siguiente.setCoef(suma);
                        previo.setLiga(siguiente);
                        actual.setLiga(null);
                        actual = siguiente;
                        siguiente = siguiente.getLiga();
                    } else {//Si la suma es igual a cero, procede a eliminar ambos monomios
                        previo.setLiga(siguiente);
                        actual.setLiga(null);
                        actual = siguiente;
                        siguiente = siguiente.getLiga();
                        previo.setLiga(siguiente);
                        actual.setLiga(null);
                        actual = siguiente;
                        siguiente = siguiente.getLiga();
                    }

                } else {
                    previo = actual;
                    actual = siguiente;
                    siguiente = actual.getLiga();
                }
            }
        }
    }

    //Evalúa el F(x) en F(dato)
    public BigInteger evaluar(BigInteger dato) {
        BigInteger resultado, retorno = null, coef;
        int exp;
        NodoSimple x;
        x = this.primerNodo();

        while (x != nodoCabeza()) {//Recorre el polinomio cambiando a X por el dato ingresado por el usuario
            coef = x.getCoef();
            exp = x.getExp();
            resultado = coef.multiply(dato.pow(exp));
            retorno = retorno.add(resultado);
            x = x.getLiga();
        }
        return retorno;
    }

    public BigInteger factorial(BigInteger num) {
        if (num.intValue() == 0) {
            return BigInteger.valueOf(1);
        }
        if (num.intValue() == 1) {
            return BigInteger.valueOf(1);
        }
        return num.multiply(factorial(num.subtract(BigInteger.valueOf(1))));
    }

    public Polinomio expansion(Polinomio poli, int exponente) {
        Polinomio resultado = new Polinomio();
        BigInteger coef;
        for (int i = 0; i <= exponente; i++) {
            coef = (BigInteger.valueOf(-1).pow(i).multiply(factorial(BigInteger.valueOf(exponente)))).divide((factorial(BigInteger.valueOf(i).multiply(factorial(BigInteger.valueOf(exponente - i)))))); //((-1)^i*(exponente!)/(i!)*(exponente-i)!  expansion del binomio (x-1)^exponente
            this.insertar(coef, exponente - i);
        }
        return resultado;
    }
    
    

//Convierte un dato en String a un polinomio representado como Lista simplemente ligada circular con nodo cabeza
      public void insertarPolinomio(String polinomio) {
        String monomio;
        int inicio = 0, fin;
        //Recorre el String reconociendo cada monomio por separado
        for (int i = 0; i < polinomio.length(); i++) {
            //Obtiene cada monomio 
            if (polinomio.charAt(i) == '+' && i != 0 || polinomio.charAt(i) == '-' && i != 0 || i == polinomio.length() - 1) {
                fin = i;
                monomio = polinomio.substring(inicio, fin + 1);
                insertarMonomio(monomio, this);
                inicio = fin;
            }
        }
        this.ordenaPolinomio();

    }
    //Ingresa el monomio obtenido a la lista 
    public void insertarMonomio(String monomio, Polinomio f) {
        String mono = ordenarMonomio(monomio);
        int x, exp = 0;
        BigInteger coef;

        // Obtiene la posición de la variable X
        x = mono.indexOf("x");
        //Verifica si es un término independiente o no
        if (x == -1) {
            coef = new BigInteger(mono);
            exp = 0;
        } else {
            //Verifica si el monomio es positivo o negativo, además separa el coeficiente y el exponente
            if (mono.charAt(0) == '-') {
                mono = mono.substring(1);
                coef = new BigInteger(mono.substring(0, x - 1));
                coef.negate();
                exp = Integer.parseInt(mono.substring(x, mono.length()));
            } else {
                coef = new BigInteger(mono.substring(0, x));
                exp = Integer.parseInt(mono.substring(x + 1, mono.length()));
            }

        }
        
        f.insertar(coef, exp);
    }

    public static String ordenarMonomio(String monomio) {
        //Elimina los espacios, los signos de potencia y convierte todo a minusculas
        monomio = monomio.replace(" ", "").replace("^", "").toLowerCase();
        //Si el monomio empieza por +, elimina el signo para que no haya problemas al momento de hacer la conversión
        if (monomio.indexOf("+") == 0) {
            monomio = monomio.substring(1);
        }
        //elimina el signo del final del monomio
        if (monomio.charAt(monomio.length() - 1) == '-' || monomio.charAt(monomio.length() - 1) == '+') {
            monomio = monomio.substring(0, monomio.length() - 1);
        }
        //Si la variable X no tiene coeficiente, le asigna 1
        if (monomio.indexOf("x") == 0) {
            monomio = "1".concat(monomio);
        }
        //Si la variable X no tiene coeficiente, le asigna 1
        if (monomio.indexOf("x") == monomio.length() - 1) {
            monomio = monomio.concat("1");
        }
        return monomio;
    }
}
