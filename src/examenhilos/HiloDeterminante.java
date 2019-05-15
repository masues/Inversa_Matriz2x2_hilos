package examenhilos;

public class HiloDeterminante extends Thread{ //Hereda de Thread
    
    float [][]Mat;
    float mult_1 = 1;
    float mult_2 = 1;
    float Det;
    
    public HiloDeterminante(){ //Constructor vacío

        System.out.println(this.getName()+": Hilo generado");
    }
    public HiloDeterminante(float [][]mat,float det){ //Constructor_2
        this.Mat = mat;
        this.Det = det;
    }
    @Override
    public void run(){ //siempre definir como void y no recibe parámetros
        
        //Calculo de determinante para matriz 2x2
        for(int i = 0; i<Mat.length; i++){
            for(int j = 0; j<Mat.length; j++){
                if (i == j){
                    mult_1 = Mat[i][j]*mult_1;
                }else{
                    mult_2 = Mat[i][j]*mult_2;
                }
            }
        }
        Det = mult_1 - mult_2;

        if(this.Det == 0){
            System.out.println(this.getName()+": La matriz no tiene inversa, su determinante es: "+this.Det);
            System.out.println(this.getName()+": Terminando ejecución");
            System.exit(0);
        }else{
            System.out.println(this.getName()+": El determinante de la matriz es: "+this.Det);
        }
    }
    
}