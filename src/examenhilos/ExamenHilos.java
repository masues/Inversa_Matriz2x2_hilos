package examenhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamenHilos {
    public static void main(String[] args) {
        System.out.println("Creando matriz...");
        int filas = 2;
        int columnas = 2;
        float [][]A = new float[filas][columnas];
        float [][]Tran = new float[filas][columnas];
        float [][]Adj = new float[filas][columnas];
        float [][]AproductoEscalar;
        float determinante = 1;
        HiloGenerador []Filas = new HiloGenerador[filas]; //arreglo de hilos para cada fila

        System.out.println("LLenando matriz...");

        //La matriz se llena con un ciclo
        for(int i = 0; i<filas; i++){
            Filas[i] = new HiloGenerador(A,i);
            Filas[i].start();
            try {
                Filas[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("¡Matriz lista!");
        System.out.println("La matriz es:");
        imprimeMatriz(A);

        System.out.println("Calculando su determinante... ");
        HiloDeterminante Det = new HiloDeterminante(A,determinante);
        Det.start();
        try{
            
            Det.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        determinante = (float)(Det.Det);
        
        System.out.println("Calculando transpuesta...");

        HiloTranspuesta []matHiloTra = new HiloTranspuesta[A.length];
        for (int fila = 0; fila < A.length; fila++) {
            matHiloTra[fila] = new HiloTranspuesta(A,Tran,fila);
            matHiloTra[fila].start();
            try{
                matHiloTra[fila].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Su traspuesta es:");
        imprimeMatriz(Tran);

        System.out.println("Calculando adjunta de la transpuesta...");

        HiloGenAdjunta Had = new HiloGenAdjunta(Tran,Adj);
        Had.start();
        try{
            Had.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Su adjunta es:");
        imprimeMatriz(Adj);
        
        System.out.println("Calculando el producto del determinante con la matriz...");
        HiloProductoEscalar productoEscalar = new HiloProductoEscalar(A,determinante);
        productoEscalar.start();
        try {
            productoEscalar.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ExamenHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        AproductoEscalar=productoEscalar.matriz;
        System.out.println("La matriz por el producto escalar es:");

        
        imprimeMatriz(AproductoEscalar);
    }

    private static void elsif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void imprimeMatriz(float [][]A){
        for(int i=0;i<A.length;i++){
            for(int j=0; j<A[i].length;j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
