package Modelo.Grafo;

import Modelo.Polinomio;

/**
 *
 * @author Alejandro
 */
public class GrafoLA extends Polinomio {

    private NodoLA[] vecinos;
    private Polinomio poliCromatico;

    public GrafoLA(int vertices) {//Crea un nuevo grafo representado como lista de adyacencia. Recibe por parametro el numero de vertices.
        vecinos = new NodoLA[vertices + 1];//Crea un vector de vertices+1 posiciones, ya que en la posicion 0 se almacenaran los datos "vertices" y "aristas" del grafo. Luego, cada posicion del vector sera su respectivo vertice
        NodoLA vertice = new NodoLA(vertices, 0);//Crea un NodoLA con el numero de vertices en el campo vertice y 0 en el campo liga, este ultimo correspondiente al numero de aristas del grafo. Inicialmente en 0 ya que el grafo es disperso
        this.vecinos[0] = vertice;//Se agrega el NodoLA creado anteriormente en la posicion 0 del vector 
        for (int i = 1; i <= vertices; i++) {//Llena el vector con NodoLA con 0 en la posicion vertice y null y su liga. Para fines practicos, el campo "vertice" sera usado para almacenar el grado del vertice
            vertice = new NodoLA(0, null);
            this.vecinos[i] = vertice;
        }
    }

    public int getTotalAristas() {//Obtiene el numero total de aristas en el grafo. Dicho dato se encuentra almacenado en la posicion 0 del vector "vecinos" en el campo Liga 
        return ((int) vecinos[0].getLiga());
    }

    public int getTotalVertices() {//Obtiene el numero total de aristas en el grafo. Dicho dato se encuentra almacenado en la posicion 0 del vector "vecinos" en el campo vertice
        return (vecinos[0].getVertice());

    }

    public void agregarArista(int v1, int v2) {//Crea una arista entre v1 y v2, es decir, añade a v1 en la lista de vecinos de v2 y viceversa
        NodoLA vertice1, vertice2, aux;

        vertice2 = new NodoLA(v2, null);//Crea un nuevo NodoLA con v2 en su campo vertice y null en su campo liga
        aux = (NodoLA) vecinos[v1].getLiga();//Hace que el apuntador "aux" apunte al primer vecino del vertice v1
        vecinos[v1].setLiga(vertice2);//Agrega a v2 en la lista de vecinos de v1. Entre las lineas 38-39
        vertice2.setLiga(aux);
        vecinos[v1].setVertice(vecinos[v1].getVertice() + 1);//Aumenta en 1 el grado del vertice v1

        //realiza lo mismo de las lineas 36-40, solo que intercambiando el orden de los vertices
        vertice1 = new NodoLA(v1, null);
        aux = (NodoLA) vecinos[v2].getLiga();
        vecinos[v2].setLiga(vertice1);
        vertice1.setLiga(aux);
        vecinos[v2].setVertice(vecinos[v2].getVertice() + 1);

        int liga = (int) vecinos[0].getLiga();
        liga++;
        vecinos[0].setLiga(liga);//Aumenta en 1 el numero total de aristas en el grafo. Lineas 49-51

    }

    public void borrarArista(int v1, int v2) {//Elimina la arista v1, v2, es decir, elimina a v2 de la lista de vecinos de v1 y viceversa.
        NodoLA previo, actual;
        int grado, aristas;

        previo = vecinos[v1];
        actual = (NodoLA) previo.getLiga();
        while (actual != null) {//Busca al vertice v2 en la lista de vecinos de v1
            if (actual.getVertice() == v2) {//Cuando lo encuentra, realiza el borrado. Borra un nodo de una lista simplemente ligada, lineas 63 a 64
                previo.setLiga(actual.getLiga());
                actual.setLiga(null);
                grado = vecinos[v1].getVertice();
                grado = grado - 1;
                vecinos[v1].setVertice(grado);//Disminuye en 1 el grado del vertice v1. Lineas 65-67
                break;//Al encontrar y borrar la vecindad, deja de recorrer la lista 
            } else {
                previo = actual;
                actual = (NodoLA) actual.getLiga();
            }
        }

        //Entre las lineas 76-91, realiza las mismas operaciones de las lineas 59-73, solo que eliminando la vecindad v2 y v1
        previo = vecinos[v2];
        actual = (NodoLA) previo.getLiga();
        while (actual != null) {
            if (actual.getVertice() == v1) {
                previo.setLiga(actual.getLiga());
                actual.setLiga(null);

                grado = vecinos[v2].getVertice();
                grado = grado - 1;
                vecinos[v2].setVertice(grado);
                break;
            } else {
                previo = actual;
                actual = (NodoLA) actual.getLiga();
            }
        }

        aristas = this.getTotalAristas();
        aristas--;
        vecinos[0].setLiga(aristas);//Disminuye en 1 el numero total de aristas del grafo. Lineas 93-95
    }

    public void fundirVertices(int v1, int v2) {//Realiza la union de los vecinos v1 y v2 en v1. Además, "elimina el vertice v2 del grafo".  
        NodoLA aux, siguiente;
        aux = (NodoLA) vecinos[v2].getLiga();//Apuntador al primer vecino de v2
        boolean buscador;
        while (aux != null) {//Se repite para cada vecino de v2
            buscador = this.buscarVertice(v1, aux.getVertice());
            if (!buscador) {//Busca si el vecino de v2 no se encuentra en la lista de vecinos de v1
                if (aux.getVertice() != v1) {//Verifica que el vecino de v2 no sea v1, si lo es, hace que el vecino de v2 sea vecino de v1
                    this.agregarArista(v1, aux.getVertice());
                }
                //Luego de hacer que el vecino de v2 sea vecino de v1, se debe eliminar de la lista de vecinos de v2. Instrucciones realizadas en las linea 113-115
                siguiente = (NodoLA) aux.getLiga();//Apuntador al siguiente vecino de v2
                this.borrarArista(aux.getVertice(), v2);//Elimina el vecino de v2 de su respectiva lista de vecinos
                aux = siguiente;//Avanza al siguiente vecino de v2 
            } else {//En caso de que el vecino de v2 también sea vecino de v1, se elimina dicha vecindad de la lista de vecinos de v2  
                siguiente = (NodoLA) aux.getLiga();//Apuntador al siguiente vecino de v2
                this.borrarArista(aux.getVertice(), v2);//Elimina el vecino de v2 de su respectiva lista de vecinos
                aux = siguiente;//Actualiza el vecino de v2
            }
        }

        vecinos[v2].setVertice(-1);//Modifica el grado del vertice v2 a -1, en nuestro caso significa que v2 deja de ser util 
        vecinos[0].setVertice(this.getTotalVertices() - 1);//Como v2 deja de existir, se disminuye en 1 el numero total de vertices del grafo
    }

    public boolean buscarVertice(int v1, int v2) {//Verifica si el vertice v2 se encuentra en la lista de vecinos del vertice v1, retorna TRUE en caso de que sí se encuentre.
        NodoLA aux1;
        boolean retorno = false;
        aux1 = (NodoLA) vecinos[v1].getLiga(); //Apuntador al primer vertice de la lista en la que se buscará el vertice v2
        while (aux1 != null && aux1.getVertice() != v2) {//Ciclo en que se verificará si el vertice v2 se encuentra en los vecinos de v1. Se termina cuando termina el recorrido de la lista de vecinos o cuando encuentra el dato en cuestion.
            aux1 = (NodoLA) aux1.getLiga(); //Si ingresa al ciclo es porque el vertice v2 es diferente del vertice a buscar, además el apuntador no ha terminado el recorrido.
        }//Al terminar, el apuntador estará en null si terminó el recorrido y no encontro que v2 fuese vecino de v. En caso de haber encontrado que v2 se encuentra en la lista de vecinos de v1, estará apuntando al nodo que contiene al vertice v2.
        if (aux1 != null) {//Verifica que el apuntador no haya terminado el recorrido de la lista de vecinos
            return (true);//Encontró el dato en cuestion, por lo tanto, retornará verdadero.
        }
        return (retorno);//Sólo se cumple si no ingresa al anterior condicional, si es el caso, el vertice v2 no esta en la lista de vecinos de v1

    }

    public double densidad() {
        double n, m;//Sea n=numero de vertices y m=numero de aristas.
        double d;
        m = (int) vecinos[0].getLiga();//Obtiene el numero de aristas, siendo necesario hacer un casting.
        n = vecinos[0].getVertice();//Obtiene el numero de vertices.
        d = (2 * m) / (n * (n - 1));//Formula demostrada en clase para obetener la densidad de un grafo. Si tiene dudas, preguntele a Andres.
        return (d);
    }

    public boolean esCiclo() {//Un grafo es un ciclo cuando es conexo y todos sus vertices tienen grado 2
        boolean retorno = true;
        if (esConexo()) {//Verifica que el grafo sea conexo
            int i = 1;
            while (i <= this.getTotalVertices()) {//Recorre los vertices del grafo verificando que todos tengan grado 2
                if (vecinos[i].getVertice() != 2) {//Si algun vertice tiene grado diferente a 2, retornara falso
                    if (vecinos[i].getVertice() != -1) {//Si el vertice tiene grado diferente de 2, verifica que "exista", es decir, su grado sea diferente de -1, si "existe" retorna falso
                        return false;
                    }
                    i++;//Avanza en en el vector
                } else {
                    i++;//Avanza en en el vector
                }
            }
        } else {
            return false;//Si el grafo no es conexo, no puede ser ciclo
        }
        return (retorno);
    }

    public boolean esArbol() {
        return (esConexo() && this.getTotalAristas() == (this.getTotalVertices() - 1)); //Un grafo es un arbol cuando el numero de aristas es igual al numero de vertices - 1  
    }

    public boolean esConexo() {
        int n, m;//Sea n=numero de vertices y m=numero de aristas.
        m = this.getTotalAristas();//Obtiene el numero de aristas, siendo necesario hacer un casting.
        n = this.getTotalVertices();//Obtiene el numero de vertices.

        return (m >= n - 1);//Teorema de grafos
    }

    public void dfs(int vertice, int[] veci, int subGrafo) {
        veci[vertice] = subGrafo;
        NodoLA aux = (NodoLA) vecinos[vertice].getLiga();
        if (veci[aux.getVertice()] == 0) {
            dfs(aux.getVertice(), veci, subGrafo);
        }
    }
//
//     public int[] subgrafos() {
//     int[] retorno = new int[vecinos[0].getVertice() + 1];
//     int i, j;
//     boolean bandera=false;
//     while()
//     this.dfs(, retorno, i);
//     return (retorno);
//        
//     }

    public boolean esCompleto() {//Un grafo es completo, todos sus vertices estan conectados entre si, cuando su densidad es igual a 1
        return (densidad() == 1);
    }

    public boolean esDisperso() {//Un grafo es disperso, todos sus vertices estan desconectados, cuando su densidad es igual a 0
        return (densidad() == 0);
    }

    public int verticeMenorGrado() {
        int menor = vecinos[1].getVertice();
        for (int i = 1; i < vecinos[0].getVertice(); i++) {
//            menor = vecinos.get(i).getVertice();
//            aux = vecinos.get(i + 1).getVertice();
            if (vecinos[i + 1].getVertice() < vecinos[i].getVertice()) {
                menor = vecinos[i + 1].getVertice();
            }
        }
        return menor;
    }

    public int verticeMayorGradoNoCompleto() {
        int mayor = 0;
        if (vecinos[1].getVertice() != vecinos[0].getVertice() - 1) {
            mayor = vecinos[1].getVertice();
        }
        for (int i = 1; i < vecinos[0].getVertice(); i++) {
//            menor = vecinos.get(i).getVertice();
//            aux = vecinos.get(i + 1).getVertice();
            if (vecinos[i + 1].getVertice() > vecinos[i].getVertice() && vecinos[i + 1].getVertice() != vecinos[0].getVertice() - 1 && vecinos[i + 1].getVertice() != -1) {
                mayor = vecinos[i + 1].getVertice();
            }
        }
        return mayor;
    }

    public String polinomioCromatico() {

        String poli, resul = null;
        Polinomio polic = new Polinomio();
        //Polinomio px = new Polinomio();
        polic.insertarPolinomio("1");
        if (esCompleto()) { //x*(x-1)*(x-2)*....*(x-(n-1))
            for (int i = 1; i <= this.getTotalVertices(); i++) {
                poli = "x".concat(String.valueOf(-(i - 1)));
                polic = polic.mult(value(poli));
                polic = polic.mult(value("x"));
                resul = polic.listaAString();
                
            }
            return resul;
        }
        if (esDisperso()) { //x^n
            poli = "x".concat(String.valueOf(this.getTotalVertices()));
            polic = value(poli);
            return polic.listaAString();
        }
        if (esArbol()) { // x*(x-1)^(n-1)
            //poli = "x-1";
            for(int i=1;i<this.getTotalVertices();i++){
                polic=polic.mult(value("x-1"));
            }
            polic = polic.mult(value("x"));
            
            resul = polic.listaAString();
            return resul;
        }
        if (esCiclo()) { // (x-1)^n+(-1)^n*(x-1). Está agregando un 0 al final, por lo que el grado del ultimo termino es 10
           // poli = "x-1";
            for(int i=1;i<=this.getTotalVertices();i++){
                polic=polic.mult(value("x-1"));
                resul = polic.listaAString();
            }
            if(this.getTotalVertices()%2==0){
                polic=polic.sumar(value("x-1"));
                resul = polic.listaAString();
            }else{
                poli="x-1";
                polic=polic.sumar(value(poli).mult(value("-1")));
                resul = polic.listaAString();
            }
            return polic.listaAString();
        }
        if (this.densidad() >= 0.5) {
            //Añadir aristas. Completar las que de mayor grado
        } else {
            //Borrar aristas
        }

        try {

        } catch (NullPointerException ex) {

            System.out.println("BAD, VERY BAD");

        }
        return null;
    }

    /**
     * @return the poliCromatico
     */
    public Polinomio getPoliCromatico() {
        return poliCromatico;
    }

    /**
     * @param poliCromatico the poliCromatico to set
     */
    public void setPoliCromatico(Polinomio poliCromatico) {
        this.poliCromatico = poliCromatico;
    }

}
