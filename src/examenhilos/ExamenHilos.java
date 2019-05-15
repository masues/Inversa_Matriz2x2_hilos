package examenhilos;

public class ExamenHilos {
    public static void main(String[] args) {
        System.out.println("Creando matriz...");
        int filas = 3;
        int columnas = 3;
        float [][]A = new float[filas][columnas];
        int determinante = 1;
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

        HiloDeterminante Det = new HiloDeterminante(A,determinante);
        Det.start();
        try{
            Det.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }

    private static void elsif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
