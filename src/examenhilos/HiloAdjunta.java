/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhilos;

/**
 *
 * @author nacho
 */
public class HiloAdjunta extends Thread{ //Hereda de Thread
    public HiloAdjunta(){ //Constructor vacío

        System.out.println(this.getName()+": Hilo generado");
    }
    public HiloAdjunta(float [][]mat,float [][]ad){ //Constructor_2
        this.Mat = mat;
        this.Adj = ad;
    }
    @Override
    public void run(){ //siempre definir como void y no recibe parámetros
        for (int fila = 0; fila < Mat.length ; fila++) {
           for (int col = 0; col < Mat.length; col++) {
               if(col == fila && col== 0){
                this.Adj[fila][col] = this.Mat[fila+1][col+1];
               }else if(col == fila && col== 1){
                this.Adj[fila][col] = this.Mat[fila-1][col-1];
                }
               
               if(col != fila && fila== 0){
                this.Adj[fila][col] = this.Mat[fila+1][col-1]*-1;
               }else if(col != fila && fila== 1 && col ==0){
                    this.Adj[fila][col] = this.Mat[fila-1][col+1]*-1;
                }
               
               System.out.println(this.getName()+": "+ "A["+fila+"]"+"["+col+"] = "+Adj[fila][col]);
        }
    }
    }
    float [][]Mat;
    float [][]Adj;
}
