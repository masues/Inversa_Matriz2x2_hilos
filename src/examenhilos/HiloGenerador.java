package examenhilos;

public class HiloGenerador extends Thread{ //Hereda de Thread
    public HiloGenerador(){ //Constructor vacío

        System.out.println(this.getName()+": Hilo generado");
    }
    public HiloGenerador(float [][]mat, int fila){ //Constructor_2
        this.Mat = mat;
        this.Fila = fila;
    }
    @Override
    public void run(){ //siempre definir como void y no recibe parámetros
        for (int i=0; i<Mat.length; i++){
            Mat[Fila][i] = (int) (Math.random() * 15);
            System.out.println(this.getName()+": "+ "A["+Fila+"]"+"["+i+"] = "+Mat[Fila][i]);
        }
    }
    float [][]Mat;
    int Fila;
}