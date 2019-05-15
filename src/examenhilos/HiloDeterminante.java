package examenhilos;

public class HiloDeterminante extends Thread{ //Hereda de Thread
    public HiloDeterminante(){ //Constructor vacío

        System.out.println(this.getName()+": Hilo generado");
    }
    public HiloDeterminante(float [][]mat,int det){ //Constructor_2
        this.Mat = mat;
        this.Det = det;
    }
    @Override
    public void run(){ //siempre definir como void y no recibe parámetros
        
        for(int j=0; j<Mat.length; j++){        //Recorrido de columnas
            for(int i=j+1; i<Mat.length; i++){    //Recorrido de renglones
                if(Mat[j][j] == 0){
                    j = Mat.length;
                    break;
                }
                //Calculo del factor para volver 0 un elemento
                float factor = (Mat[i][j]/Mat[j][j])*-1;
                System.out.println("Factor "+factor);
                
                for(int c = j; c<Mat.length; c++){    //Recorrido interno del renglon
                    Mat[i][c] = (Mat[j][c]*factor) + Mat[i][c];
                    System.out.println("A["+i+"]"+"["+c+"] = "+Mat[i][c]);
                }
            }
        }
        
        //Calculo del determinante
        for(int i=0; i<Mat.length; i++){
            this.Det = Det*Mat[i][i];
        }

        if(this.Det == 0){
            System.out.println(this.getName()+": La matriz no tiene inversa.");
            System.out.println(this.getName()+": Terminando ejecución");
            System.exit(0);
        }else{
            System.out.println(this.getName()+": El determinante de la matriz es: "+this.Det);
        }
    }
    float [][]Mat;
    float mult_1;
    float mult_2;
    float Det;
}